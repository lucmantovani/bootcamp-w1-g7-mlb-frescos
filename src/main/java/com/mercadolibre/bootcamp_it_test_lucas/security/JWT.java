package com.mercadolibre.bootcamp_it_test_lucas.security;

import java.util.Date;

import com.mercadolibre.bootcamp_it_test_lucas.model.Account;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;


public class JWT {
    protected static final String secret = "test";

    protected static final int expirationTime = 99999;

    public static String getJWT(Account account){
        return Jwts.builder()
                   .setSubject(account.getUserName())
                   .claim("account_id", account.getId())
                   .setIssuedAt(new Date(System.currentTimeMillis()))
                   .setExpiration(new Date(System.currentTimeMillis() ))
                   .signWith(SignatureAlgorithm.HS256,
                             secret).compact();
    
    }

    public static String getId(String token){
        Claims claim = decodeJWT(token);
        return claim.getId();
    }

    public static Claims decodeJWT(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    public static boolean validateToken(String token){
        return ! decodeJWT(token).getExpiration().before(new Date(System.currentTimeMillis()));
    }
}
