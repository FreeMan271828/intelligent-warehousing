package org.iwp.user.dataObject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.iwp.user.entity.User;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName(value = "member")
public class UserDo implements Serializable {

    @Schema(name = "User Code", description = "用户的唯一标识码")
    @TableId(value = "code", type = IdType.INPUT)
    private String code;

    @Schema(name = "User Name", description = "用户的姓名")
    @TableField("name")
    private String name;

    @Schema(name = "Password", description = "用户的密码")
    @TableField("password")
    private String password;

    @Schema(name = "Status", description = "用户的状态，true为激活，false为未激活")
    @TableField("status")
    private int status;

    @Schema(name = "Remark", description = "用户的备注信息")
    @TableField("remark")
    private String remark;

    @Schema(name = "GMT Created", description = "用户创建时间")
    @TableField("gmt_created")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime gmtCreated;

    @Schema(name = "GMT Modified", description = "用户最后修改时间")
    @TableField("gmt_modified")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime gmtModified;

    public UserDo() {}

    public UserDo(User user) {
        this.code = user.getCode();
        this.name = user.getName();
        this.password = user.getPassword();
        this.status = user.getStatus();
        this.remark = user.getRemark();
        this.gmtCreated = user.getGmtCreated();
        this.gmtModified = user.getGmtModified();
    }

    public User toUser() {
        User user = new User();
        user.setCode(this.code);
        user.setName(this.name);
        user.setPassword(this.password);
        user.setStatus(this.status);
        user.setRemark(this.remark);
        user.setGmtCreated(this.gmtCreated);
        user.setGmtModified(this.gmtModified);
        return user;
    }
}