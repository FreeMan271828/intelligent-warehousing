package org.iwp.miantaince;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.iwp.common.model.ResponseModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Maintaince")
@Tag(name="维修接口")
public class MaintainApi {

    @GetMapping("CountMaintainedRecord")
    @Operation(summary = "已完成维保记录")
    public ResponseModel countMaintainedRecord(@RequestParam Boolean Flag){
        return null;
    }
    @GetMapping("getKeepPoint")
    @Operation(summary = "已完成维保记录")
    public ResponseModel getKeepPoint(@RequestParam String DeviceName,@RequestParam int status){
        return null;
    }


}
