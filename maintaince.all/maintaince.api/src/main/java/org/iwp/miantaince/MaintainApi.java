package org.iwp.miantaince;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.iwp.common.model.ResponseModel;
import org.iwp.maintaince.service.MaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Maintaince")
@Tag(name="维修接口")
public class MaintainApi {

    private MaintainService maintainService;

    @GetMapping("CountMaintainedRecord")
    @Operation(summary = "已完成/未完成维保记录")
    public ResponseModel countMaintainedRecord(@RequestParam Boolean Flag){
        if(Flag){
            return maintainService.getMaintainedRecord();
        }else{
            return maintainService.getUnmaintainedRecord();
        }
    }
    @GetMapping("getKeepPoint")
    @Operation(summary = "获取保养点")
    public ResponseModel getKeepPoint(@RequestParam String DeviceName,@RequestParam int status){
        return maintainService.getKeepPoint(DeviceName,status);
    }


}
