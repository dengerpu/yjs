package com.ep.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.ep.pojo.User;
import com.ep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class JwtUtil {

    @Autowired
    private static UserService userService;

    @Autowired
    public void setService(UserService userService)  {
        JwtUtil.userService = userService;
    }

    /**
     * 生成token
     */
    public static String createToken(User user) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 7); //默认令牌过期时间7天
        JWTCreator.Builder builder = JWT.create();
        builder.withClaim("id", user.getId())
                .withClaim("username", user.getUsername())
                .withClaim("rid", user.getRid());

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
        Claim claim = getClaimByName(token,"id");
        Integer id = claim.asInt();
        User user = userService.getById(id);
        //获取登录用户真正的密码假如数据库查出来的是123456
        JWTVerifier build = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        return build.verify(token);
    }

    public static Claim getClaimByName(String token, String name){
        return JWT.decode(token).getClaim(name);
    }
}
