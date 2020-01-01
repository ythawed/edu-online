package com.ygq.edu.controller;

import com.ygq.edu.config.WeChatConfig;
import com.ygq.edu.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 测试启动是否正常
 *
 * @author ythawed
 * @date 2019/12/21 0021
 */
@Controller
public class Test {

    /**
     * 项目跑通测试
     */
    @RequestMapping(value = "/test/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String test(@PathVariable(value = "name") String name) {
        return "Hello->" + name;
    }

    @Autowired
    private WeChatConfig weChatConfig;

    @RequestMapping("/wx")
    @ResponseBody
    public String weChatMessage() {
        return weChatConfig.getAppId() + "======" + weChatConfig.getAppSecret();
    }

    @RequestMapping("/test_json_data")
    @ResponseBody
    public JsonData test() {
        System.out.println(weChatConfig.getAppId());
        return JsonData.buildSuccess(weChatConfig.getAppId());
    }

}
