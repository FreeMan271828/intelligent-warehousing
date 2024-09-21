package org.iwp.iWare.object.model;

import lombok.Getter;

@Getter
public enum ResponseCode {
    //成功状态
    SUCCESS(1, "成功"),
    //参数错误状态
    PARAM_ERROR(1000,"参数错误"),
    PARAM_IS_INVALID(1001,"参数无效"),
    PARAM_IS_BLANK(1002, "参数为空"),
    PARAM_NOT_EXIST(1003,"参数缺失"),
    //服务器内部错误
    SERVER_ERROR(2000,"服务器内部错误");

    private final Integer code;
    private final String message;

    // 枚举的构造函数，它必须为 private 或者 package-private（即默认访问级别）
    private ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}