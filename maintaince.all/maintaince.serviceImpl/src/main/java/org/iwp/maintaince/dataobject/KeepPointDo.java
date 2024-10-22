package org.iwp.maintaince.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.objenesis.instantiator.perc.PercInstantiator;

import java.io.Serializable;

@Data
@TableName(value = "keep_point")
public class KeepPointDo implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    @Schema(name = "KeepPoint Id",description = "保养点标识码")
    private int id;

    @Schema(name = "Device Name",description = "设备名称")
    @TableField(value = "device_name")
    private String deviceName;

    @Schema(name = "Device Code",description = "设备标识码")
    @TableField(value = "device_code")
    private String deviceCode;

    @Schema(name = "Keep Content",description = "保养内容")
    @TableField(value = "keep_content")
    private String keepContent;

    @Schema(name = "Operation Guide",description = "操作指导")
    @TableField(value = "operation_guide")
    private String operationGuide;

    @Schema(name = "Remark",description = "备注")
    @TableField(value = "remark")
    private String remark;
}
