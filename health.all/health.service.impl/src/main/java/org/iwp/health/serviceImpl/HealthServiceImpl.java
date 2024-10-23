package org.iwp.health.serviceImpl;

import org.iwp.common.model.PieChartModel;
import org.iwp.common.model.ResponseModel;
import org.iwp.common.util.ResponseUtil;
import org.iwp.health.service.HealthService;
import org.iwp.maintaince.dao.MaintainDao;
import org.iwp.maintaince.dataobject.MaintainDo;
import org.springframework.data.convert.Jsr310Converters;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HealthServiceImpl implements HealthService {
    private MaintainDao maintainDao;
    @Override
    public ResponseModel getHealthDegree(String startYear, String startMonth, String endYear, String endMonth) {
        String start=startYear+startMonth;
        String end=endYear+endMonth;
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM");
        LocalDateTime startTime=LocalDateTime.parse(start+"-1 00:00:00",formatter);
        LocalDateTime endTime=LocalDateTime.parse(end+"-1 00:00:00",formatter);
        List<MaintainDo> maintainDos=maintainDao.getHealthDegree(startTime,endTime);
        Map<String,Integer> map=new HashMap<>();
        for(MaintainDo maintainDo : maintainDos){
            map.compute(maintainDo.getFacName(),(k,v)-> v==null?0:v+1);
        }
        int total=map.size();
        PieChartModel pieChartModel=new PieChartModel();
        pieChartModel.setTotalCount(total);
        List<PieChartModel.PieData> list=new ArrayList<>();
        maintainDos.forEach(maintainDo -> {
            int count=map.get(maintainDo.getFacName());
            double ratio=(double)count/total;
            PieChartModel.PieData data=new PieChartModel.PieData(maintainDo.getFacName(),count,ratio);
            list.add(data);
        });
        pieChartModel.setValues(list);
        return ResponseUtil.Success(pieChartModel);
    }


}
