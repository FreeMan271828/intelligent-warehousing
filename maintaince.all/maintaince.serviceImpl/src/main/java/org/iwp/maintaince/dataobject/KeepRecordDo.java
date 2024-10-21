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
import lombok.Data;

import javax.naming.Name;
import java.io.Serializable;
import java.time.LocalDateTime;
@Data
@TableName(value = "keep_record")
public class KeepRecordDo implements Serializable {
    @Schema(name = "Keep Record id",description = "保养记录标识码")
    @TableId(value = "id",type = IdType.AUTO)
    private int id;

    @Schema(name = "Fac Code",description = "设备标识码")
    @TableField(value = "fac_code")
    private String facCode;

    @Schema(name = "Fac Name",description = "设备名称")
    @TableField(value = "fac_name")
    private String facName;

    @Schema(name="Keep Plan Time",description = "保养预计时间")
    @TableField("keep_plan_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime keepPlanTime;

    @Schema(name = "Status",description = "状态码")
    @TableField(value = "status")
    private int status;

    @Schema(name = "Keep Content",description = "保养内容")
    @TableField(value = "keep_content")
    private String keepContent;

    @Schema(name = "Keeper",description = "保养人")
    @TableField(value = "keeper")
    private String keeper;

    @Schema(name="Keep Finish Time",description = "保养完成时间")
    @TableField("keep_finish_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime keepFinishTime;

    @Schema(name = "Remark",description = "备注")
    @TableField(value = "remark")
    private String remark;
}
