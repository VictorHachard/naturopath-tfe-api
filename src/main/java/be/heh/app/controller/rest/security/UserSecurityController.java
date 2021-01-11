package be.heh.app.controller.rest.security;

import be.heh.app.controller.rest.commons.AbstractSecurityController;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class UserSecurityController extends AbstractSecurityController {

    @PostMapping("/connect")
    public boolean connect() {
        return false;
    }

    @PostMapping("/register")
    public boolean register() {
        return false;
    }

}
