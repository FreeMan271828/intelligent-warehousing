package org.iwp.iWare.object.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class PieChartModel {

    private Integer totalCount;
    private List<PieData>values;

    public static class PieData{
        // 每一项的名称
        private String name;
        // 每一项的数目
        private Integer count;
        // 每一项的占比
        private Double ratio;

        public PieData(String name, Integer value, Double ratio) {
        }
    }
}
