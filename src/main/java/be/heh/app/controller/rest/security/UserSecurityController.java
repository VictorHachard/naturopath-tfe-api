package be.heh.app.controller.rest.security;

import be.heh.app.controller.rest.commons.AbstractSecurityController;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class UserSecurityController extends AbstractSecurityController {

    @PostMapping("/user/get/{id}")
    public boolean get() {
        return false;
    }

    @PostMapping("/user/connect")
    public boolean connect() {
        return false;
    }

    @PostMapping("/user/register")
    public boolean register() {
        return false;
    }

    @DeleteMapping("/user/delete/{id}")
    public boolean delete() {
        return false;
    }

}
