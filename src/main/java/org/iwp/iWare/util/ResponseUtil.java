package org.iwp.iWare.util;

import org.iwp.iWare.object.model.ResponseCode;
import org.iwp.iWare.object.model.ResponseModel;

public class ResponseUtil {

    public static ResponseModel Success(Object data) {
        ResponseModel response = new ResponseModel();
        response.setData(data);
        response.setCode(ResponseCode.SUCCESS.getCode());
        response.setMsg(ResponseCode.SUCCESS.getMessage());
        return response;
    }

    public static ResponseModel ParamError(Object data) {
        ResponseModel response = new ResponseModel();
        response.setData(data);
        response.setMsg(ResponseCode.PARAM_ERROR.getMessage());
        response.setCode(ResponseCode.PARAM_ERROR.getCode());
        return response;
    }

    public static ResponseModel ServerError(Object data) {
        ResponseModel response = new ResponseModel();
        response.setData(data);
        response.setMsg(ResponseCode.SERVER_ERROR.getMessage());
        response.setCode(ResponseCode.SERVER_ERROR.getCode());
        return response;
    }
}
