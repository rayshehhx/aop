package com.cn.aop.controller;

import com.cn.aop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created on 2020/1/13.
 */
@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseBody
    public String hello(@RequestParam String name) {
        userService.add();
        return "add success " + name;
    }
}
