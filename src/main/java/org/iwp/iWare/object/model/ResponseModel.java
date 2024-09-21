package org.iwp.iWare.object.model;

import lombok.Data;
import java.io.Serializable;

@Data
public class ResponseModel implements Serializable {
    private Integer code;
    private String msg;
    private Object data;

    public ResponseModel() {}
}
