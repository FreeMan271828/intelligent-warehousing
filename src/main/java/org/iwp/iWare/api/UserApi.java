package org.iwp.iWare.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.iwp.iWare.entity.UserDo;
import org.iwp.iWare.model.ResponseResult.Result;
import org.iwp.iWare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "用户接口")
@RequestMapping("/api/user")
public class UserApi {

    private final UserService userService;

    @Autowired
    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @Operation(summary = "注册用户")
    public Result register(@RequestParam String username,
                           @RequestParam String password) {
        UserDo input = new UserDo();
        input.setName(username);
        input.setPassword(password);
        return userService.register(input);
    }

    @GetMapping("queryAll")
    @Operation(summary = "查询全部用户")
    public Result queryAll() {
        return userService.findAll();
    }
}
