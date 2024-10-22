package org.iwp.maintaince.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class KeepRecord {
    private int id;
    private String facCode;
    private String facName;
    private LocalDateTime keepPlanTime;
    private int status;
    private String keepContent;
    private String keeper;
    private LocalDateTime keepFinishTime;
    private String remark;

}
