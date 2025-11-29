package com.example.SpringSecurityPlayground.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

@Service
public class JWTService {

    private final String secretKey;

    @Autowired
    private MyUserDetailsService MyUserDetailsService;

    public JWTService() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSha256");
            SecretKey sk = keyGen.generateKey();
            secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String generateToken(String username) {

        Map<String, Object> claims = Map.of(
                "alg", "HS256",
                "typ", "JWT");

        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000)) // 1 hour expiration
                .and()
                .signWith(getKey())
                .compact();
    }

    private SecretKey getKey() {
//        System.out.println("Secret Key: " + secretKey);
        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    public String extractUsername(String token) {
        //extract username from token
        try {
            return Jwts.parser().verifyWith(getKey()).build().parseSignedClaims(token).getPayload().getSubject();
        } catch (Exception e) {
            System.out.println("Invalid Token: " + e.getMessage());
            return "Invalid Token: " + e.getMessage();
        }
    }


    public UserDetails loadUserByUsername(String username) {
        return MyUserDetailsService.loadUserByUsername(username);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        try {
            final Date expiration = Jwts.parser().verifyWith(getKey()).build().parseSignedClaims(token).getPayload().getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            System.out.println("Token Parsing Error: " + e.getMessage());
            return true;
        }
    }
}
