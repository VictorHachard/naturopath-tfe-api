package be.heh.app.controller.rest.security;

import be.heh.app.controller.rest.commons.AbstractSecurityController;
import be.heh.app.controller.validators.security.UserSecurityLoginValidator;
import be.heh.app.controller.validators.security.UserSecurityRegisterValidator;
import be.heh.app.dto.security.UserSecurityViewDto;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class UserSecurityController extends AbstractSecurityController {

    @PostMapping("/user/login")
    public UserSecurityViewDto login(UserSecurityLoginValidator validator) {
        return userSecurityService.login(validator);
    }

    @PostMapping("/user/register")
    public UserSecurityViewDto register(@Valid @RequestBody UserSecurityRegisterValidator validator) {
        return userSecurityService.addC(validator);
    }

    /*@PostMapping("/user/update/{id}")
    public void update(@Valid @RequestBody UserSecurityRegisterValidator validator, @PathVariable("id") int id) {
        userSecurityService.update(validator, id);
    }

    @DeleteMapping("/user/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        userSecurityService.delete(id);
    }*/

}
