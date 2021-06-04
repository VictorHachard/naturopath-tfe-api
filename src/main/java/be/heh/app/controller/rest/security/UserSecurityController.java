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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Base64;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/v1/userSecurity/")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class UserSecurityController extends AbstractSecurityController {

    @PostMapping("login")
    public UserSecurityViewDto login(@Valid @RequestBody UserSecurityLoginValidator validator) {
        String token = new String(Base64.getDecoder().decode(validator.getToken().replace("Basic ", "")));

        UserSecurityViewDto res = userSecurityService.login(token.substring(0, token.indexOf(":")),
                token.substring(token.indexOf(":") + 1),
                validator.getRememberMe());

        log.info("LOGIN " + res.getToken() + " is the token of user " + res.getUsername());
        return res;
    }

    @PostMapping("connectFromCookie")
    public UserSecurityViewDto connectFromCookie(@Valid @RequestBody UserSecurityLoginValidator validator) {
        String token = new String(Base64.getDecoder().decode(validator.getToken().replace("Basic ", "")));
        System.out.println(token);
        UserSecurityViewDto res = cookieRememberMeService.login(token.substring(0 , token.indexOf(":")),
                token.substring(token.indexOf(":") + 1));

        log.info("LOGIN " + res.getToken() + " is the token of user " + res.getUsername());
        return res;
    }

    @PostMapping("confirmAuth")
    public UserSecurityViewDto confirmAuth(@Valid @RequestBody UserSecurityDoubleAuthValidator validator) {
        String token = new String(Base64.getDecoder().decode(validator.getToken().replace("Basic ", "")));

        UserSecurityViewDto res = userSecurityService.confirmDoubleAuth(
                token.substring(0, token.indexOf(":")),
                token.substring(token.indexOf(":") + 1),
                validator.getCode(),
                validator.getRememberMe());

        log.info("LOGIN D" + res.getToken() + " is the token of user " + res.getUsername());
        return res;
    }

    @PostMapping("register")
    public UserSecurityViewDto register(@Valid @RequestBody UserSecurityRegisterValidator validator) {
        UserSecurityViewDto res = userSecurityService.addC(validator);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(res.getUsername(), validator.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        res.setToken(jwt);

        log.info("REGISTER " + jwt + " is the token of user " + res.getUsername());
        return res;
    }

    @GetMapping("dto/edit")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public UserSecurityEditDto getEditDto() {
        UserSecurity u = (UserSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userSecurityMapper.getEdit(u);
    }

    @GetMapping("dto/edit/all")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR')")
    public List<UserSecurityEditDto> getAllEditDto() {
        return userSecurityService.getAllEditDto();
    }

    @PostMapping("confirmAccount")
    public Boolean confirmAccount(@Valid @RequestBody UserSecurityTokenValidator validator) {
        return userSecurityService.confirmAccount(validator);
    }

    @PostMapping("resetAccount")
    public void resetAccount(@Valid @RequestBody UserSecurityResetValidator validator) {
        userSecurityService.resetAccount(validator);
    }

    @PostMapping("deleteAccount")
    public void deleteAccount(@Valid @RequestBody UserSecurityTokenValidator validator) {
        userSecurityService.deleteAccount(validator);
    }

    @PostMapping("set/confirmAccount")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public void setConfirmAccount() {
        userSecurityService.setConfirmAccount(((UserSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
    }

    @PostMapping("set/resetAccount")
    public void setResetAccount(@Valid @RequestBody UserSecuritySetResetValidator validator) {
        userSecurityService.setResetAccount(validator);
    }

    @PostMapping("set/deleteAccount")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public void setDeleteAccount(@Valid @RequestBody UserSecurityDeleteValidator validator) {
        userSecurityService.setDeleteAccount(validator, ((UserSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
    }

    @PutMapping("update")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public UserSecurityViewDto updateUsernameEmail(@Valid @RequestBody UserSecurityRegisterValidator validator) {
        UserSecurity userSecurity = ((UserSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        userSecurityService.updateUsernameEmail(validator, userSecurity);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userSecurity.getUsername(), validator.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserSecurityViewDto userSecurityViewDto = userSecurityMapper.getView(userSecurity);
        userSecurityViewDto.setToken(jwt);

        log.info("UPDATE " + jwt + " is the token of user " + userSecurityViewDto.getUsername());

        return userSecurityViewDto; //TODO if email not confirmed cannot edit email
    }

    @PutMapping("updateName")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public void updateFirstNameLastName(@Valid @RequestBody UserSecurityNameUpdateValidator validator) {
        userSecurityService.updateFirstNameLastName(validator, ((UserSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
    }

    @PutMapping("updatePassword")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public void updatePassword(@Valid @RequestBody UserSecurityPasswordUpdateValidator validator) {
        userSecurityService.updatePassword(validator, ((UserSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
    }

    @PutMapping("updateAppearance")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public void updateAppearance(@Valid @RequestBody UserSecurityAppearanceUpdateValidator validator) {
        userSecurityService.updateAppearance(validator, ((UserSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
    }

    @PutMapping("updatePrivacy")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public void updatePrivacy(@Valid @RequestBody UserSecurityPrivacyUpdateValidator validator) {
        userSecurityService.updatePrivacy(validator, ((UserSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
    }

    @PutMapping("updateSecurity")
    @PreAuthorize("hasRole('USER')")
    public void updateSecurity(@Valid @RequestBody UserSecuritySecurityUpdateValidator validator) {
        userSecurityService.updateSecurity(validator, ((UserSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
    }

    @PutMapping("forceUpdate/{id}")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR')")
    public void forceUpdate(@PathVariable("id") int id, @Valid @RequestBody UserForceUpdateValidator validator) {
        userSecurityService.forceUpdate(validator, id);
    }

}
