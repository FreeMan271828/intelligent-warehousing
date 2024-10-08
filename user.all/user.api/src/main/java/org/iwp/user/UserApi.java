package org.iwp.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.iwp.common.model.ResponseModel;
import org.iwp.common.util.ResponseUtil;
import org.iwp.user.entity.User;
import org.iwp.user.service.impl.UserService;
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

//    @PostMapping("/login")
//    @Operation(summary = "登录")
//    public ResponseModel login(@RequestBody String username, String password) {
//
//    }

    @PostMapping("/register")
    @Operation(summary = "注册用户")
    public ResponseModel register(@RequestParam String username,
                                  @RequestParam String password) {
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        return ResponseUtil.Success(userService.register(user));
    }

    @GetMapping("queryAll")
    @Operation(summary = "查询全部用户")
    public ResponseModel queryAll() {
        return ResponseUtil.Success(userService.findAll());
    }
}
