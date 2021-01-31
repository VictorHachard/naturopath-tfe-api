package be.heh.app.controller.rest.security;

import be.heh.app.controller.rest.commons.AbstractSecurityController;
import be.heh.app.controller.validators.security.*;
import be.heh.app.dto.security.UserSecurityEditDto;
import be.heh.app.dto.security.UserSecurityViewDto;
import be.heh.app.model.entities.security.UserSecurity;
import be.heh.app.springjwt.JwtUtils;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @GetMapping("dto/edit")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public UserSecurityEditDto getEditDto() {
        UserSecurity u = (UserSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userSecurityMapper.getEdit(u);
    }

    @PostMapping("logout")
    public void logout() {
        //TODO
    }

    @PostMapping("confirmAccount")
    public Boolean confirmAccount(@Valid @RequestBody UserSecurityTokenValidator validator) {
        return userSecurityService.confirmAccount(validator);
    }

    @PostMapping("resetAccount")
    public void resetAccount(@Valid @RequestBody UserSecurityResetValidator validator) {
        userSecurityService.resetAccount(validator);
    }

    @DeleteMapping("deleteAccount")
    public void deleteAccount(@Valid @RequestBody UserSecurityTokenValidator validator) {
        userSecurityService.deleteAccount(validator);
    }

    @PostMapping("set/confirmAccount")
    public void setConfirmAccount() {
        userSecurityService.setConfirmAccount(((UserSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
    }

    @PostMapping("set/resetAccount")
    public void setResetAccount(@Valid @RequestBody UserSecuritySetResetValidator validator) {
        userSecurityService.setResetAccount(validator);
    }

    @PostMapping("set/deleteAccount")
    public void setDeleteAccount() {
        userSecurityService.setDeleteAccount(((UserSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
    }

    /*@PostMapping("update/{id}")
    public void update(@Valid @RequestBody UserSecurityRegisterValidator validator) {
        userSecurityService.update(validator, ((UserSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }}*/

}
