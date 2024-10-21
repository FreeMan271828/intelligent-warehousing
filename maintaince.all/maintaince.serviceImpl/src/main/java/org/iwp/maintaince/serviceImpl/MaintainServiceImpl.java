package org.iwp.maintaince.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.iwp.common.model.PageModel;
import org.iwp.common.model.PieChartModel;
import org.iwp.common.model.ResponseModel;
import org.iwp.common.util.PageUtil;
import org.iwp.common.util.ResponseUtil;
import org.iwp.maintaince.dao.KeepPointDao;
import org.iwp.maintaince.dao.KeepRecordDao;
import org.iwp.maintaince.dao.MaintainDao;
import org.iwp.maintaince.dataobject.KeepPointDo;
import org.iwp.maintaince.dataobject.KeepRecordDo;
import org.iwp.maintaince.dataobject.MaintainDo;
import org.iwp.maintaince.service.MaintainService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class MaintainServiceImpl implements MaintainService {

    private MaintainDao maintainDao;
    private KeepPointDao keepPointDao;
    private KeepRecordDao keepRecordDao;
    @Override
    public ResponseModel getMaintainedRecord() {
        List<Map<String,Object>> l=findUnmaintainedRecord();
        if(l.isEmpty()){
            ResponseModel responseModel=ResponseUtil.ServerError(null);
            responseModel.setMsg("没有已完成维修记录");
            return responseModel;
        }
        return getRecord(l);
    }

    @Override
    public ResponseModel getUnmaintainedRecord() {
        List<Map<String,Object>> l=findMaintainedRecord();
        if(l.isEmpty()){
            ResponseModel responseModel=ResponseUtil.ServerError(null);
            responseModel.setMsg("没有未完成维修记录");
            return responseModel;
        }
        return getRecord(l);
    }

    @Override
    public ResponseModel getKeepPoint(String deviceName, int status) {
        QueryWrapper<KeepPointDo> point_wrapper=new QueryWrapper<>();
        point_wrapper.eq("device_name",deviceName);
        KeepPointDo keepPointDo=keepPointDao.selectOne(point_wrapper);
        if(keepPointDo==null){
            ResponseModel responseModel=ResponseUtil.ServerError(null);
            responseModel.setMsg("该设备名称不存在");
            return responseModel;
        }
        String DeviceCode= keepPointDo.getDeviceCode();
        QueryWrapper<KeepRecordDo> record_wrapper=new QueryWrapper<>();
        record_wrapper.eq("fac_name",deviceName).eq("status",status);
        List<KeepRecordDo> keepRecordDos=keepRecordDao.selectList(record_wrapper);
        AtomicInteger count= new AtomicInteger();
        List<Object> responseList = keepRecordDos.stream()
                .map(keepRecordDo -> {
                    Map<String, String> map = new HashMap<>();
                    map.put("PlanTime", keepRecordDo.getKeepPlanTime()!= null? keepRecordDo.getKeepPlanTime().toString() : "");
                    map.put("CompleteTime", keepRecordDo.getKeepFinishTime()!= null? keepRecordDo.getKeepFinishTime().toString() : "");
                    map.put("DeviceCode", DeviceCode);
                    map.put("KeepContent", keepRecordDo.getKeepContent()!= null? keepRecordDo.getKeepContent() : "");
                    return map;
                })
                .collect(Collectors.toList());
        PageModel pageModel= PageUtil.buildPage(3,10,count.get(),responseList);
        return ResponseUtil.Success(pageModel);
    }

    public List<Map<String, Object>> findMaintainedRecord(){
        QueryWrapper<MaintainDo> wrapper=new QueryWrapper<>();
        wrapper.isNull("maintainDateTime");
        return maintainDao.selectMaps(wrapper.groupBy("facName"));
    }
    public List<Map<String,Object>> findUnmaintainedRecord(){
        QueryWrapper<MaintainDo> wrapper=new QueryWrapper<>();
        wrapper.isNotNull("maintainDateTime");
        return maintainDao.selectMaps(wrapper.groupBy("facName"));
    }

    public ResponseModel getRecord(List<Map<String,Object>> l){
        List<PieChartModel.PieData> pieDataList=new ArrayList<>();
        int total=0;
        for(Map<String,Object> map:l){
            total+=(Integer)map.get("count");
        }
        for(Map<String,Object> m:l){
            int count=(Integer) m.get("count");
            double ratio=(double)count/total;
            PieChartModel.PieData pieData=new PieChartModel.PieData(m.get("facName").toString(),count,ratio);
            pieDataList.add(pieData);
        }
        PieChartModel pieChartModel=new PieChartModel();
        pieChartModel.setValues(pieDataList);
        pieChartModel.setTotalCount(total);
        return ResponseUtil.Success(pieChartModel);
    }
}
