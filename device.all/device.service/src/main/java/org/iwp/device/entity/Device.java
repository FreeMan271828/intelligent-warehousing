package org.iwp.device.entity;

import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.Data;

@Data
public class Device {
    Integer id;
    String code;
    String name;
    Boolean type;
    Double life;
    Double depreciation;
    Integer stockNum;
    Integer stockWarn;
    Boolean status;
    String remark;
    String parentCode;
}
