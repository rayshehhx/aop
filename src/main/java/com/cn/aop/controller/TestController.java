package com.cn.aop.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Created on 2020/1/11.
 */
@RestController
public class TestController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }
}
