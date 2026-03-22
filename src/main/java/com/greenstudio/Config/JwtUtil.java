package com.greenstudio.Config;


import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;


@Component
public class JwtUtil
{
	
	private final String SECRET = "greenstudio_secret_key_2024_abcdefghijklmno";

    // ── CREATE TOKEN after successful login ──
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(
                    System.currentTimeMillis() + 1000 * 60 * 60 * 8  // 8 hours
                ))
                .signWith(
                    Keys.hmacShaKeyFor(SECRET.getBytes()),
                    SignatureAlgorithm.HS256
                )
                .compact();
    }

    // ── VALIDATE TOKEN ──
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(SECRET.getBytes()))
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
