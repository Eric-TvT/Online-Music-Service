package com.example.onlinemusicservice.common;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

/**
 * @author zhaojunsir
 * JWT工具类
 */
public class JwtUtils {
  public static final String SECRET_KEY = "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901";
  /**
   * 过期时间，单位为秒   默认7天
    */

  private static final long EXPIRATION_TIME = 7*24*60*60;

  /**
   * 生成 JWT   subject 用户信息
   */

  public static String generateToken(String subject) {
    // 计算过期时间
    Date expirationDate = new Date(System.currentTimeMillis() + EXPIRATION_TIME * 1000);
    String jwt = Jwts.builder()
            .setSubject(subject)
            .setExpiration(expirationDate)
            .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
            .compact();
    return jwt;
  }

  /**
   * 解析 JWT
   * @param jwt
   * @return 返回Claims
   */
  public static Claims parseToken(String jwt) {
    Claims claims = Jwts.parser()
            .setSigningKey(SECRET_KEY)
            .parseClaimsJws(jwt)
            .getBody();
    return claims;
  }

  /**
   * 验证JWT是否过期
   * @param jwt token串
   * @return 是否过期标志
   */
  public static boolean isTokenExpired(String jwt) {
    try {
      Claims claims = parseToken(jwt);
      Date expirationDate = claims.getExpiration();
      return expirationDate.before(new Date());
    } catch (Exception e) {
      //过期会抛异常，所以直接捕捉  返回ture代表已过期
      throw new ExpiredJwtException(null, null, "Token已经过期");
      //return true;
    }
  }

  /**
   *  测试
   * @param args 不需要
   */
  public static void main(String[] args) {
    String token = generateToken("admin");
    System.out.println(token);
    System.out.println(parseToken(token));
    System.out.println(isTokenExpired(token));
  }
}
