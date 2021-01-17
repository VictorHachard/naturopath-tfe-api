package be.heh.app.controller.rest.security;

import be.heh.app.controller.rest.commons.AbstractSecurityController;
import be.heh.app.controller.validators.security.UserSecurityValidator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class UserSecurityController extends AbstractSecurityController {

    @PostMapping("/user/get/{id}")
    public boolean get(@PathVariable("id") int id) {
        return false;
    }

    @PostMapping("/user/connect")
    public boolean connect() {
        return false;
    }

    @PostMapping("/user/register")
    public void register(@Valid @RequestBody UserSecurityValidator validator) {
        userSecurityService.add(validator);
    }

    @PostMapping("/user/update/{id}")
    public void update(@Valid @RequestBody UserSecurityValidator validator, @PathVariable("id") int id) {
        userSecurityService.update(validator, id);
    }

    @DeleteMapping("/user/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        userSecurityService.delete(id);
    }

}
