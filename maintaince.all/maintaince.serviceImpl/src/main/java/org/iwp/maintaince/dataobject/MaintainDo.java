package org.iwp.maintaince.dataobject;

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
import jdk.vm.ci.meta.Value;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName(value = "maintain")
public class MaintainDo implements Serializable {
    @Schema(name="Maintain Id",description = "保养标识码")
    @TableId(value="id",type= IdType.AUTO)
    private int id;

    @Schema(name="Equipment Id",description = "设备代号")
    @TableField("facCode")
    private String facCode;

    @Schema(name="Equipment Name",description = "设备名称")
    @TableField("facName")
    private String facName;

    @Schema(name="Error Code",description = "错误代号")
    @TableField("errorCode")
    private String errorCode;

    @Schema(name="Error Name",description = "错误名称")
    @TableField("errorName")
    private String errorName;

    @Schema(name="Error DateTime",description = "出错时间")
    @TableField("errorDateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime errorDateTime;

    @Schema(name="Maintain DateTime",description = "保养时间")
    @TableField("maintainDateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime maintainDateTime;

    @Schema(name="Maintain Status",description = "保养状态")
    @TableField("status")
    private int status;

    @Schema(name="Reporter",description = "申请人")
    @TableField("reporter")
    private String reporter;

    @Schema(name="Reason",description = "申请理由")
    @TableField("reason")
    private String reason;

    @Schema(name="Maintainer",description = "保养工人")
    @TableField("maintainer")
    private String maintainer;

    @Schema(name="Remark",description = "备注")
    @TableField("remark")
    private String remark;
}
