package org.iwp.common.model;

import lombok.Data;
import lombok.Setter;

import java.io.Serializable;

@Data
public class ResponseModel implements Serializable {
    private Integer code;
    @Setter
    private String msg;
    private Object data;

    public ResponseModel() {}

}
