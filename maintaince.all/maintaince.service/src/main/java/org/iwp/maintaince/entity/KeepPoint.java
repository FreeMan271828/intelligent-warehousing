package org.iwp.maintaince.entity;

import lombok.Data;

@Data
public class KeepPoint {
    private int id;
    private String deviceName;
    private String deviceCode;
    private String keepContent;
    private String operationGuide;
    private String remark;
}
