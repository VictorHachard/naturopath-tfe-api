package be.heh.app.controller.services.security;

import be.heh.app.controller.services.commons.AbstractSecurityService;
import be.heh.app.dto.security.UserSecurityViewDto;
import be.heh.app.model.entities.security.CookieRememberMe;
import be.heh.app.model.entities.security.UserSecurity;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class CookieRememberMeService extends AbstractSecurityService<CookieRememberMe> {

    public UserSecurityViewDto login(String username, String token) {
        if (!userSecurityRepository.existsByUsername(username)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The username is not correct");
        }
        UserSecurity user = userSecurityRepository.findByEmailOrUsername(username).get(); //TODO all in one request
        boolean hasCookie = false;
        for (CookieRememberMe cookie : user.getCookieList()) {
            if (cookie.getToken().equals(token)) {
                hasCookie = true;
                break;
            }
        }
        if (hasCookie) {
            UserSecurityViewDto res = userSecurityMapper.getView(user);

            Authentication authentication = new UsernamePasswordAuthenticationToken(res.getUsername(), null);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(res.getUsername());
            res.setToken(jwt);
            return res;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The token is not valid");
        }
    }

}
