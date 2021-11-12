package cn.bngel.rcty.controller;

import cn.bngel.rcty.bean.CommonResult;
import cn.bngel.rcty.bean.User;
import cn.bngel.rcty.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public CommonResult saveUser(@RequestBody User user) {
        Integer result = userService.saveUser(user);
        if (result == 1) {
            log.info("创建用户: [" + user + "] 成功");
            return CommonResult.getSuccessResult();
        } else {
            log.info("创建用户: [" + user + "] 失败");
            return CommonResult.getFailureResult();
        }
    }

    @DeleteMapping("/user")
    public CommonResult deleteUserById(@RequestParam("id") Long id) {
        Integer result = userService.deleteUserById(id);
        if (result == 1) {
            log.info("删除用户: [" + id + "]");
            return CommonResult.getSuccessResult();
        } else {
            log.info("删除用户: [" + id + "] 失败");
            return CommonResult.getFailureResult();
        }
    }

    @PutMapping("/user")
    public CommonResult updateUserById(@RequestBody User user) {
        if (user.getId() == null) {
            log.info("更改用户信息: [" + user + "] 失败");
            return CommonResult.getFailureResult();
        }
        if (user.getUsername().length() > 15) {
            return CommonResult.getFailureResult();
        }
        Integer result = userService.updateUserById(user);
        if (result == 1) {
            log.info("更改用户信息[" + user.getId() + "]: " + user.getUsername());
            return CommonResult.getSuccessResult();
        } else {
            log.info("更改用户信息[" + user.getId() + "]: 失败");
            return CommonResult.getFailureResult();
        }
    }

    @GetMapping("/user")
    public CommonResult getUserById(@RequestParam("id") Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            log.info("查询用户: [" + user + "] 成功");
            return CommonResult.getSuccessResult();
        }
        else {
            log.info("查询用户: [" + id + "]: 失败");
            return CommonResult.getFailureResult();
        }
    }

    @PostMapping("/user/login")
    public CommonResult login(@RequestParam("account") String account,
                              @RequestParam("password") String password) {
        User user = userService.login(account, password);
        if (user != null) {
            log.info("用户登录: [" + user + "]");
            return CommonResult.getSuccessResult();
        }
        else {
            log.info("登录失败: [" + account + "]");
            return CommonResult.getFailureResult();
        }
    }
}
