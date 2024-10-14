package org.iwp.common.util;

import org.iwp.common.model.PieChartModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PieChartUtil {

    public static PieChartModel buildPieChart(Map<String, Integer> input) {
        PieChartModel pieChartModel = new PieChartModel();
        int count = 0;
        for (Map.Entry<String, Integer> entry : input.entrySet()) {
            count += entry.getValue();
        }
        pieChartModel.setTotalCount(count);
        List<PieChartModel.PieData> pieDataList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : input.entrySet()) {
            String name = entry.getKey();
            Integer value = entry.getValue();
            Double ratio = (double) value / pieChartModel.getTotalCount();
            pieDataList.add(new PieChartModel.PieData(name, value, ratio));
            count += value;
        }
        pieChartModel.setValues(pieDataList);
        return pieChartModel;
    }
}
