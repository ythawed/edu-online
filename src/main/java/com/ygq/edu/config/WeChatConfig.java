package com.ygq.edu.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 微信相关配置类，调用本类来获取配置中的数据
 * @author ythawed
 * @date 2019/12/22 0022
 */
@Configuration
@PropertySource(value = "classpath:application.yml")
public class WeChatConfig {
    /**
     * 微信小程序appid
     */
    @Value("${wxpay.appid}")
    private String appId;
    /**
     * 小程序密钥
     */
    @Value("${wxpay.appsecret}")
    private String appSecret;

    @Override
    public String toString() {
        return "WeChatConfig{" +
                "appId='" + appId + '\'' +
                ", appSecret='" + appSecret + '\'' +
                '}';
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }
}
