package org.iwp.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.iwp.common.model.ResponseModel;
import org.iwp.common.util.ResponseUtil;
import org.iwp.user.entity.User;
import org.iwp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@Tag(name = "用户接口")
public class UserApi {

    private final UserService userService;

    @Autowired
    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    @Operation(summary = "登录")
    public ResponseModel login(@RequestParam String username, @RequestParam String password) {
        return userService.ifExist(username, password);
    }

    @PostMapping("/register")
    @Operation(summary = "注册用户")
    public ResponseModel register(@RequestParam String username,
                                  @RequestParam String password) {
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        return userService.add(user);
    }

    @GetMapping("/getStatus")
    @Operation(summary = "获取用户状态")
    public ResponseModel getStatus(@RequestParam String username) {
        return userService.getStatus(username);
    }

    @PostMapping("/updateStatus")
    @Operation(summary = "修改用户状态")
    public ResponseModel updateStatus(@RequestParam String username){
        return userService.updateStatus(username);
    }

    @GetMapping("queryAll")
    @Operation(summary = "查询全部用户")
    public ResponseModel queryAll() {
        return ResponseUtil.Success(userService.findAll());
    }
}
