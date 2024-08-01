package org.iwp.iWare.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
public class UserDo implements Serializable {

    @Schema(name = "User Code", description = "用户的唯一标识码")
    private String code;

    @Schema(name = "User Name", description = "用户的姓名")
    private String name;

    @Schema(name = "Password", description = "用户的密码")
    private String password;

    @Schema(name = "Status", description = "用户的状态，true为激活，false为未激活")
    private Integer status;

    @Schema(name = "Remark", description = "用户的备注信息")
    private String remark;

    @Schema(name = "GMT Created", description = "用户创建时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime gmtCreated;

    @Schema(name = "GMT Modified", description = "用户最后修改时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime gmtModified;

}