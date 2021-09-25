package com.example.ClinicaaOdontologica.Hibernate.security.jwt;

import com.example.ClinicaaOdontologica.Hibernate.security.persistence.entities.PrimaryUser;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    private static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Integer expiration;

    public String generateToken(Authentication authentication){
        PrimaryUser primaryUser = (PrimaryUser) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(primaryUser.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String getByUserNameFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJwt(token).getBody().getSubject();
    }

    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJwt(token);
            return true;
        }catch (MalformedJwtException malformedJwtException){
            logger.error("Error, malformed token");
        }
        catch (UnsupportedJwtException unsupportedJwtException){
            logger.error("Error, token not supported");
        }
        catch (ExpiredJwtException expiredJwtException){
            logger.error("Error, expired token");
        }
        catch (IllegalArgumentException illegalArgumentException){
            logger.error("Error, empty token");
        }
        catch (SignatureException signatureException){
            logger.error("Error, signature failure");
        }
        return false;
    }
}
