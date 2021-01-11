package be.heh.app.controller.rest.commons;

import be.heh.app.controller.services.app.UserService;
import be.heh.app.controller.services.app.VoteService;
import be.heh.app.controller.services.security.UserSecurityService;
import be.heh.app.model.entities.security.UserSecurity;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

// Lombok
@FieldDefaults(level = AccessLevel.PUBLIC)
public abstract class AbstractSecurityController extends AbstractController {

    @Autowired
    UserSecurityService userSecurityService;

}
