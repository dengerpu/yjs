package com.ep.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.ep.domain.User;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class JwtUtil {

    /**
     * 生成token
     */
    public static String createToken(User user) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 7); //默认令牌过期时间7天
        JWTCreator.Builder builder = JWT.create();
        builder.withClaim("id", user.getId())
                .withClaim("username", user.getUsername())
                .withClaim("role", user.getRid());

        return builder.withExpiresAt(calendar.getTime())
                .sign(Algorithm.HMAC256(user.getPassword()));
    }

    /**
     * 解析token
     */
    public static DecodedJWT verifyToken(String token) {
        if (token==null){
            System.out.println("token不能为空");
        }
        //获取登录用户真正的密码假如数据库查出来的是123456
        String password = "admin";
        JWTVerifier build = JWT.require(Algorithm.HMAC256(password)).build();
        return build.verify(token);
    }
}
