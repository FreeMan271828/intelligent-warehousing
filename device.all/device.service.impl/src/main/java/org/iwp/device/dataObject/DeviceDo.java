package org.iwp.device.dataObject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.iwp.device.entity.Device;

import java.io.Serializable;

@Data
@TableName(value = "device")
public class DeviceDo implements Serializable {

    @Schema(name = "Device Id", description = "设备id")
    @TableId(type = IdType.AUTO)
    private int id;

    @Schema(name = "Device Code", description = "设备的唯一标识码")
    @TableId(value = "code", type = IdType.INPUT)
    private String code;

    @Schema(name = "Device Name", description = "设备的名称")
    @TableField("name")
    private String name;

    @Schema(name = "Type", description = "设备的类型，true为激活，false为未激活")
    @TableField("type")
    private boolean type;

    @Schema(name = "Model", description = "设备的型号")
    @TableField("model")
    private String model;

    @Schema(name = "Application", description = "设备的用途")
    @TableField("application")
    private String application;

    @Schema(name = "Life", description = "设备的寿命")
    @TableField("life")
    private Double life;

    @Schema(name = "Depreciation", description = "设备的折旧")
    @TableField("depreciation")
    private Double depreciation;

    @Schema(name = "Parent Code", description = "上级设备的代码")
    @TableField("parentCode")
    private String parentCode;

    @Schema(name = "Stock Num", description = "库存数量")
    @TableField("stockNum")
    private int stockNum;

    @Schema(name = "Stock Warn", description = "库存警告阈值")
    @TableField("stockWarn")
    private int stockWarn;

    @Schema(name = "Status", description = "设备的状态，true为激活，false为未激活")
    @TableField("status")
    private boolean status;

    @Schema(name = "Location", description = "设备的位置")
    @TableField("location")
    private String location;

    @Schema(name = "Remark", description = "设备的备注信息")
    @TableField("remark")
    private String remark;

    @Schema(name = "Supplier", description = "设备的供应商")
    @TableField("supplyer")
    private String supplier;

    @Schema(name = "producer", description = "设备的生产商")
    @TableField("producer")
    private String producer;

    public DeviceDo(){}

    public DeviceDo(Device device) {
        this.code = device.getCode();
        this.name = device.getName();
        this.life = device.getLife();
        this.depreciation = device.getDepreciation();
        this.parentCode = device.getParentCode();
        this.stockNum = device.getStockNum();
        this.stockWarn = device.getStockWarn();
        this.remark = device.getRemark();
    }

    /**
     * 将DeviceDo转换为Device实体
     * @return Device实体
     */
    public Device toDevice() {
        Device device = new Device();
        device.setCode(this.code);
        device.setName(this.name);
        device.setType(this.type);
        device.setLife(this.life);
        device.setDepreciation(this.depreciation);
        device.setParentCode(this.parentCode);
        device.setStockNum(this.stockNum);
        device.setStockWarn(this.stockWarn);
        device.setStatus(this.status);
        device.setRemark(this.remark);
        return device;
    }
}