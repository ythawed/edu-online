package com.ygq.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 测试启动是否正常
 * @author ythawed
 * @date 2019/12/21 0021
 */
@Controller
public class Test {

    @RequestMapping(value = "/test/{name}",method = RequestMethod.GET)
    @ResponseBody
    public String test(@PathVariable(value = "name") String name) {
        return "Hello->" + name;
    }
}
