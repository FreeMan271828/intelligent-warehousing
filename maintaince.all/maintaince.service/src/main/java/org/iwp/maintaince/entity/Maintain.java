package org.iwp.maintaince.entity;

import java.time.LocalDateTime;

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
