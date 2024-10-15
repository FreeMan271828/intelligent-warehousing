package org.iwp.maintaince.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import jdk.vm.ci.meta.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MaintainDo implements Serializable {
    @Schema(name="Maintain Id",description = "维修标识码")
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

    @Schema(name="Maintain DateTime",description = "维修时间")
    @TableField("maintainDateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime maintainDateTime;

    @Schema(name="Maintain Status",description = "维修状态")
    @TableField("status")
    private int status;

    @Schema(name="Reporter",description = "报修人")
    @TableField("reporter")
    private String reporter;

    @Schema(name="Reason",description = "报修理由")
    @TableField("reason")
    private String reason;

    @Schema(name="Maintainer",description = "维修人")
    @TableField("maintainer")
    private String maintainer;

    @Schema(name="Remark",description = "备注")
    @TableField("remark")
    private String remark;
}
