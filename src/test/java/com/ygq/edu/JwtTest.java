package com.ygq.edu;

import com.ygq.edu.domain.User;
import com.ygq.edu.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.junit.Test;

/**
 * @author ythawed
 * @date 2019/12/31 0031
 */
public class JwtTest {


    /**
     * 模拟用户登录过程中的jwt过程
     */
    @Test
    public void a_genJwt() {
        User user = new User();
        user.setId(4536251);
        user.setName("ygq");
        user.setHeadImg("www.xyz.com");

        //加密
        String token = JwtUtils.geneJsonWebToken(user);
        System.out.println(token);
    }

    @Test
    public void checkJwt() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJFRFVfWUdRIiwiaWQiOjQ1MzYyNTEsIm5hbWUiOiJ5Z3EiLCJoZWFkX2ltZyI6Ind3dy54eXouY29tIiwiaWF0IjoxNTc3Nzk5NTY0LCJleHAiOjE1Nzc4ODU5NjR9.R0B37IAEDCpqYHb6oXGcDIpnbBi_KAd9DMiqD0zf7HU";
        Claims claims = JwtUtils.checkToken(token);
        //解析claims对象，获取加密数据
        if (claims != null) {
            //根据设置的属性名称，获取属性
            int id= (Integer) claims.get("id");
            String name =(String) claims.get("name");
            String head_img = (String)claims.get("head_img");

            System.out.println(id);
            System.out.println(name);
            System.out.println(head_img);
        }


    }
}
