package org.iwp.iWare.model.ResponseResult;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Data
public class Result implements Serializable {
    private Integer code;
    private String msg;
    private Object data;

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(ResultCode.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    public static Result ParamError(Object data) {
        Result result = new Result();
        result.setCode(ResultCode.PARAM_ERROR.getCode());
        result.setMsg(ResultCode.PARAM_ERROR.getMessage());
        result.setData(data);
        return result;
    }

    public static Result ServerError(Object data) {
        Result result = new Result();
        result.setCode(ResultCode.SERVER_ERROR.getCode());
        result.setMsg(ResultCode.SERVER_ERROR.getMessage());
        result.setData(data);
        return result;
    }

    public Result() {}
}
