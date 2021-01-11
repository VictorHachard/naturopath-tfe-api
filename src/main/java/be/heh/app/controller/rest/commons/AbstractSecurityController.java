package be.heh.app.controller.rest.commons;

import be.heh.app.controller.services.security.UserSecurityService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

// Lombok
@FieldDefaults(level = AccessLevel.PUBLIC)
public abstract class AbstractSecurityController extends AbstractController {

    @Autowired
    UserSecurityService userSecurityService;

}
