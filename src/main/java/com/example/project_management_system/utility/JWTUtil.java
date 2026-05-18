package com.example.project_management_system.utility;

import com.example.project_management_system.model.Users;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JWTUtil {

    private String SECRET_KEY = "ndsvssvbsjbosuevspaldjfhlaehfajefhaowlefjkb";

    private Key getSignKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    private Claims getClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String generateToken(Users user){
        return Jwts.builder()
                .setSubject(user.getUserName())
                .claim("userId",user.getUserId())
                .claim("role",user.getRole())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(getSignKey(),SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUserName(String token){
        return getClaims(token).getSubject();
    }

    public String extractUserRole(String token){
        return getClaims(token).get("role",String.class);
    }


}
