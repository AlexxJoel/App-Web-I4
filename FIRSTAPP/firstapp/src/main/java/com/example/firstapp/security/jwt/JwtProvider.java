package com.example.firstapp.security.jwt;

import com.example.firstapp.security.model.UserAuth;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    //public final static Logger LOGGER = (Logger) LoggerFactory.getLogger(JwtProvider.class);
    public final static Logger LOGGER =  LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private int expiration;
    public String generateToken(Authentication authentication){
        UserAuth userAuth =
                (UserAuth) authentication.getPrincipal();
        return Jwts.builder().setSubject(userAuth.getUsername()).setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime()+expiration*1000L))
                .signWith(SignatureAlgorithm.HS512,secret).compact(); //Crea el token
    }

    public String getUsernameFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException e){
            LOGGER.error("Token invalido");
        }catch (UnsupportedJwtException e){
            LOGGER.info("Token no soportado");
        }catch (ExpiredJwtException e){
            LOGGER.info("Token caducado");
        }catch (IllegalArgumentException e){
            LOGGER.info("Token vacio");
        }catch (SignatureException e){
            LOGGER.info("Fallo en la firma del token");
        }
        return false;
    }
}
