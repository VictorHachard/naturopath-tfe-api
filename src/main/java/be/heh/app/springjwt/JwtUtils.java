package be.heh.app.springjwt;

import be.heh.app.model.entities.security.UserSecurity;
import io.jsonwebtoken.*;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
// Lombok
@Log
public class JwtUtils {

    @Value("${bezkoder.app.jwtSecret}")
    private String jwtSecret;

    @Value("${bezkoder.app.jwtExpirationMs}") //24h
    private int jwtExpirationMs;

    public String generateJwtToken(Authentication authentication) {
        UserSecurity userSecurity = (UserSecurity) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject((userSecurity.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String generateJwtToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            // Reset expiration
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken).getBody().setExpiration(new Date((new Date()).getTime() + jwtExpirationMs)).getSubject();
            return true;
        } catch (SignatureException e) {
            log.info("Invalid JWT signature: " + e.getMessage());
        } catch (MalformedJwtException e) {
            log.info("Invalid JWT token: " + e.getMessage());
        } catch (ExpiredJwtException e) {
            log.info("JWT token is expired: " + e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.info("JWT token is unsupported: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            log.info("JWT claims string is empty: " + e.getMessage());
        }
        return false;
    }

}
