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
     * 微信公众号appid
     */
    @Value("${wxpay.appid}")
    private String appId;
    /**
     * 公众号密钥
     */
    @Value("${wxpay.appsecret}")
    private String appSecret;

    /**
     * 开发平台id
     */
    @Value("${wxopen.appid}")
    private String openAppId;
    /**
     * 开发平台密钥
     */
    @Value("${wxopen.appsecret}")
    private String openAppSecret;
    /**
     * 微信开发平台回调第三方服务器的地址
     */
    @Value("${wxopen.redirect_url}")
    private String openRedirectUrl;

    /**
     * 微信开放平台二维码连接
     * 该链接需要插入对应三个参数，见%s占位符
     * appid=%s
     * redirect_uri=%s
     * state=%s
     */
    private final static String OPEN_QRCODE_URL= "https://open.weixin.qq.com/connect/qrconnect?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_login&state=%s#wechat_redirect";

    public String getOpenQrcodeUrl() {
        return OPEN_QRCODE_URL;
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

    public String getOpenAppId() {
        return openAppId;
    }

    public void setOpenAppId(String openAppId) {
        this.openAppId = openAppId;
    }

    public String getOpenAppSecret() {
        return openAppSecret;
    }

    public void setOpenAppSecret(String openAppSecret) {
        this.openAppSecret = openAppSecret;
    }

    public String getOpenRedirectUrl() {
        return openRedirectUrl;
    }

    public void setOpenRedirectUrl(String openRedirectUrl) {
        this.openRedirectUrl = openRedirectUrl;
    }
}
