package org.iwp.maintaince.entity;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Maintain {
    private int id;
    private String facCode;

    private String facName;

    private String errorCode;
    private String errorName;
    private LocalDateTime errorDateTime;
    private LocalDateTime maintainDateTime;

    private int status;
    private String reporter;
    private String reason;
    private String maintainer;

    private String remark;


}
