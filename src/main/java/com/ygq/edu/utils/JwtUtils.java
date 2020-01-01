package com.ygq.edu.utils;

import com.ygq.edu.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * Jwt工具类，用于加密解密登录用户信息，以此判断是否已经登录
 * JsonWebToken
 *
 * @author ythawed
 * @date 2019/12/31 0031
 */
public class JwtUtils {

    /**
     * 请求发行者，任意一个字符串即可
     */
    private static final String SUBJECT = "EDU_YGQ";
    /**
     * 过期时间，设置为7天
     */
    private static final long EXPIRATION = 1000 * 60 * 60 * 24;
    /**
     * token加密解密的密钥.密钥不能太短，否则会出现secret key cannot be null or empty异常
     */
    private static final String APPSECRET = "my name is ygq";

    /**
     * 生成JWT
     * @param user 登录用户对象
     * @return token
     */
    public static String geneJsonWebToken(User user) {

        if (user == null || user.getId() == null || user.getName() == null || user.getHeadImg() == null) {
            return null;
        }
        String token = Jwts.builder().setSubject(SUBJECT)
                //token属性
                .claim("id", user.getId())
                .claim("name", user.getName())
                .claim("head_img", user.getHeadImg())
                //token发行时间
                .setIssuedAt(new Date())
                //token过期时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                //加密算法与密钥
                .signWith(SignatureAlgorithm.HS256, APPSECRET)
                //压缩密文
                .compact();
        return token;
    }

    /**
     * 校验JWT
     * @param token token
     * @return 校验结果
     */
    public static Claims checkToken(String token) {

        try {
            return Jwts.parser().setSigningKey(APPSECRET).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }
}
