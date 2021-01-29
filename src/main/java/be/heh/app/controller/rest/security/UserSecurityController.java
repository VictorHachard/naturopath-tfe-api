package be.heh.app.controller.rest.security;

import be.heh.app.controller.rest.commons.AbstractSecurityController;
import be.heh.app.controller.validators.security.*;
import be.heh.app.dto.security.UserSecurityViewDto;
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

    @PostMapping("/user/login")
    public UserSecurityViewDto login(@Valid @RequestBody UserSecurityLoginValidator validator) {
        return userSecurityService.login(validator);
    }

    @PostMapping("/user/register")
    public UserSecurityViewDto register(@Valid @RequestBody UserSecurityRegisterValidator validator) {
        return userSecurityService.addC(validator);
    }

    @PostMapping("/user/confirmAccount")
    public boolean confirmAccount(@Valid @RequestBody UserSecurityTokenValidator validator) {
        return userSecurityService.confirmAccount(validator);
    }

    @PostMapping("/user/resetAccount")
    public UserSecurityViewDto resetAccount(@Valid @RequestBody UserSecurityResetValidator validator) {
        return userSecurityService.resetAccount(validator);
    }

    @DeleteMapping("/user/deleteAccount")
    public boolean deleteAccount(@Valid @RequestBody UserSecurityTokenValidator validator) {
        return userSecurityService.deleteAccount(validator);
    }

    @PostMapping("/user/set/resetAccount")
    public boolean setResetAccount(@Valid @RequestBody UserSecuritySetResetValidator validator) {
        return userSecurityService.setResetAccount(validator);
    }

    @PostMapping("/user/set/deleteAccount/{id}")
    public boolean setDeleteAccount(@PathVariable("id") int id) {
        return userSecurityService.setDeleteAccount(id);
    }

    /*@PostMapping("/user/update/{id}")
    public void update(@Valid @RequestBody UserSecurityRegisterValidator validator, @PathVariable("id") int id) {
        userSecurityService.update(validator, id);
    }}*/

}
