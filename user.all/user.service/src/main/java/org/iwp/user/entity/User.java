package org.iwp.user.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {

    private String code;
    private String name;
    private String password;
    private Integer status;
    private String remark;
    private LocalDateTime gmtCreated;
    private LocalDateTime gmtModified;

}
