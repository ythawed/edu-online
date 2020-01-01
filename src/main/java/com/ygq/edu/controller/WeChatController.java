package com.ygq.edu.controller;

import com.ygq.edu.config.WeChatConfig;
import com.ygq.edu.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 微信开发平台授权
 *
 * @author ythawed
 * @date 2020/1/1 0001
 */
@RestController
@RequestMapping("/api/v1/wechat")
public class WeChatController {


    @Autowired
    private WeChatConfig weChatConfig;


    @GetMapping("/test")
    public String test() {
        return "hello";
    }

    @GetMapping("login")
    public JsonData qd(@RequestParam(value = "access_page",required = true) String accessPage) throws UnsupportedEncodingException {
        //获取开发平台的锁持有的第三方地址（也就是我们所要）
        String redirectUrl = weChatConfig.getOpenRedirectUrl();
        //url编码
        String encodeUrl = URLEncoder.encode(redirectUrl, "GBK");
        //获取二维码。需要动态拼接三个参数，作为二维码地址.format(),会自动替换%s占位符
        String qrcode = String.format(weChatConfig.getOpenQrcodeUrl(), weChatConfig.getOpenAppId(), encodeUrl, accessPage);
        return JsonData.buildSuccess(qrcode);
    }

}
