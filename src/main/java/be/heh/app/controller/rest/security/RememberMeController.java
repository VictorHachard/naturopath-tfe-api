package be.heh.app.controller.rest.security;

import be.heh.app.controller.rest.commons.AbstractSecurityController;
import be.heh.app.controller.validators.security.UserSecurityLoginValidator;
import be.heh.app.dto.security.UserSecurityViewDto;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Base64;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/v1/rememberMe/")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class RememberMeController extends AbstractSecurityController {

    @PostMapping("login")
    public UserSecurityViewDto login(@Valid @RequestBody UserSecurityLoginValidator validator) {
        String token = new String(Base64.getDecoder().decode(validator.getToken().replace("Basic ", "")));

        UserSecurityViewDto res = cookieRememberMeService.login(token.substring(0 , token.indexOf(":")),
                token.substring(token.indexOf(":") + 1));

        log.info("LOGIN " + res.getToken() + " is the token of user " + res.getUsername());
        return res;
    }

}
