package org.iwp.health;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.iwp.common.model.PieChartModel;
import org.iwp.common.model.ResponseModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

@Tag(name="健康接口")
@RestController
@RequestMapping("api/health")

public class HealthApi {

    @GetMapping("getHealthDegree")
    @Operation(summary = "获取设备健康指数")
    public ResponseModel getHealthDegree(@RequestParam String startYear, @RequestParam String startMonth,
                                         @RequestParam String endYear, @RequestParam String endMonth){
        return null;
    }

    @GetMapping("CountEquipOperation")
    @Operation(summary = "获取fac的故障分析")
    public ResponseModel countEquipOperation(@RequestParam String facCode,@RequestParam String Year,@RequestParam String Month){
        return  null;
    }

    @GetMapping("CountMaintainMsg")
    @Operation(summary = "维修保养统计")
    public ResponseModel countMaintainMsg(@RequestParam String Year,@RequestParam String Month){
        return null;
    }

}
