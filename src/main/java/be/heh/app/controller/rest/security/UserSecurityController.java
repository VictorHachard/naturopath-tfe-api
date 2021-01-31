package be.heh.app.controller.rest.security;

import be.heh.app.controller.rest.commons.AbstractSecurityController;
import be.heh.app.controller.validators.security.*;
import be.heh.app.dto.security.UserSecurityViewDto;
import be.heh.app.springjwt.JwtUtils;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/v1/userSecurity/")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class UserSecurityController extends AbstractSecurityController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("login")
    public ResponseEntity<?> login(@Valid @RequestBody UserSecurityLoginValidator validator) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(validator.getEmailOrUsername(), validator.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserSecurityViewDto res = userSecurityService.login(validator);
        res.setToken(jwt);

        log.info("LOGIN " + jwt + " is the token of user " + res.getUsername());

        return ResponseEntity.ok(res);
    }

    @PostMapping("register")
    public ResponseEntity<?> register(@Valid @RequestBody UserSecurityRegisterValidator validator) {
        UserSecurityViewDto res = userSecurityService.addC(validator);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(res.getUsername(), validator.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        res.setToken(jwt);

        log.info("REGISTER " + jwt + " is the token of user " + res.getUsername());

        return ResponseEntity.ok(res);
    }

    @PostMapping("logout")
    public void logout() {
        //TODO
    }

    @PostMapping("confirmAccount")
    public boolean confirmAccount(@Valid @RequestBody UserSecurityTokenValidator validator) {
        return userSecurityService.confirmAccount(validator);
    }

    @PostMapping("resetAccount")
    public UserSecurityViewDto resetAccount(@Valid @RequestBody UserSecurityResetValidator validator) {
        return userSecurityService.resetAccount(validator);
    }

    @DeleteMapping("deleteAccount")
    public boolean deleteAccount(@Valid @RequestBody UserSecurityTokenValidator validator) {
        return userSecurityService.deleteAccount(validator);
    }

    @PostMapping("set/confirmAccount/{id}")
    public boolean setConfirmAccount(@PathVariable("id") int id) {
        return userSecurityService.setConfirmAccount(id);
    }

    @PostMapping("set/resetAccount")
    public boolean setResetAccount(@Valid @RequestBody UserSecuritySetResetValidator validator) {
        return userSecurityService.setResetAccount(validator);
    }

    @PostMapping("set/deleteAccount/{id}")
    public boolean setDeleteAccount(@PathVariable("id") int id) {
        return userSecurityService.setDeleteAccount(id);
    }

    /*@PostMapping("update/{id}")
    public void update(@Valid @RequestBody UserSecurityRegisterValidator validator, @PathVariable("id") int id) {
        userSecurityService.update(validator, id);
    }}*/

}
