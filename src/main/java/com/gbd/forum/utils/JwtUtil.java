package com.gbd.forum.utils;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author syh
 * @date 2022-10-30 14:39
 * JWT工具类
 */
public class JwtUtil {

    /**
     * 过期时间2小时，单位毫秒
     */
    public static final long EXPIRE = 1000*60*60*2;

    /*
     * 秘钥
     * */
    public static final String SECRET = "ukc8BDbRigUDaY6pZFfWus2jZWLPHO";

    /**
     * 生成token字符串的方法
     *
     * @param userName  用户名称
     * @param password  用户密码
     * @return token字符串
     */
    public static String getJwtToken(String userId){
        return Jwts.builder()
                //JWT头信息
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS2256")
                //设置分类；设置过期时间 一个当前时间，一个加上设置的过期时间常量
                .setSubject("user")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                //设置token主体信息，存储用户信息
                .claim("userId", userId)
                //.signWith(SignatureAlgorithm.ES256, SECRET)
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    /**
     * 判断token是否存在与有效
     *
     * @param jwtToken  token串
     * @return 验证结果
     */
    public static boolean checkToken(String jwtToken){
        if (StringUtils.isBlank(jwtToken)){
            return false;
        }
        try{
            //验证token
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(jwtToken);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 判断token是否存在与有效
     *
     * @param request  request
     * @return 验证结果
     */
    public static boolean checkToken(HttpServletRequest request){
        try {
            String token = request.getHeader("token");
            if (StringUtils.isBlank(token)){
                return false;
            }
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 解密token
     *
     * @param request request
     * @return 解密结果map
     */
    public static Map<String, String> getMemberIdByJwtToken(HttpServletRequest request){
        String token = request.getHeader("token");
        return decode(token);
    }

    /**
     * 解密token
     *
     * @param token token字符串
     * @return 解密结果map
     */
    public static Map<String, String> getMemberIdByJwtToken(String token){
        return decode(token);
    }

    public static String getUserIdBtJwtToken(String token){
        Map<String, String> map = decode(token);
        return map.get("userId");
    }

    public static Map<String, String> decode(String token) {
        // 封装解密结果
        Map<String, String> map = new HashMap<>();
        if (StringUtils.isEmpty(token)){
            return map;
        }
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
        Claims body = claimsJws.getBody();
        String userId = (String) body.get("userId");
        if (StringUtils.isBlank(userId)) {
            userId = "";
        }
        map.put("userId", userId);
        return map;
    }
}