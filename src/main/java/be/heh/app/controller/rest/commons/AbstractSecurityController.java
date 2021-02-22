package be.heh.app.controller.rest.commons;

import be.heh.app.init.AbstractSecurityAutowire;
import be.heh.app.springjwt.JwtUtils;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

// Lombok
@FieldDefaults(level = AccessLevel.PUBLIC)
public abstract class AbstractSecurityController extends AbstractSecurityAutowire {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

}
