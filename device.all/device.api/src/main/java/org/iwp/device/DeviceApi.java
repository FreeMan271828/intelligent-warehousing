package org.iwp.device;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.iwp.common.model.ResponseModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "设备接口")
@RestController
@RequestMapping("/api/device")
public class DeviceApi {

    @GetMapping("getAllDeviceName")
    @Operation(summary = "获取所有device名称")
    public ResponseModel getAllDeviceName(){
        return null;
    }

    @GetMapping("getFacCodeByDeviceName")
    @Operation(summary = "根据deviceName获取设备编号")
    public ResponseModel getFacCodeByDeviceName(String deviceCode){
        return null;
    }

    @GetMapping("getElementCodeByFacCode")
    @Operation(summary = "根据facCode获取零件代号")
    public ResponseModel getElementCodeByFacCode(String facCode){
        return null;
    }

    @GetMapping("getElementInfo")
    @Operation(summary = "根据零件代号获取零件信息")
    public ResponseModel getElementInfo(String elementCode){
        return null;
    }
}
