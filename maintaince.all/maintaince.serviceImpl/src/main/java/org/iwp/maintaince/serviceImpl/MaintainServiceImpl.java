package org.iwp.maintaince.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.iwp.common.model.PieChartModel;
import org.iwp.common.model.ResponseModel;
import org.iwp.common.util.ResponseUtil;
import org.iwp.maintaince.dao.MaintainDao;
import org.iwp.maintaince.dataobject.MaintainDo;
import org.iwp.maintaince.service.MaintainService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaintainServiceImpl implements MaintainService {

    private MaintainDao maintainDao;
    @Override
    public ResponseModel getMaintainedRecord() {
        List<Map<String,Object>> l=findMaintainedRecord();
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

    @Override
    public ResponseModel getUnmaintainedRecord() {
        return null;
    }

    @Override
    public ResponseModel getKeepPoint(String deviceName, int status) {
        return null;
    }

    public List<Map<String, Object>> findMaintainedRecord(){
        QueryWrapper<MaintainDo> wrapper=new QueryWrapper<>();
        wrapper.isNull("maintainDateTime");
        return maintainDao.selectMaps(wrapper.groupBy("facName"));
    }
}
