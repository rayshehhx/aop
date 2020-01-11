package com.cn.aop.test;

import org.springframework.web.bind.annotation.*;

/**
 * Created on 2020/1/11.
 */
@RestController
public class Test2Controller {
    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    @ResponseBody
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }
}
