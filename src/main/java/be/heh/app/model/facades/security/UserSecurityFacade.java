package be.heh.app.model.facades.security;

import be.heh.app.model.entities.security.UserSecurity;
import be.heh.app.model.facades.commons.AbstractFacade;
import be.heh.app.utils.Utils;
import lombok.extern.java.Log;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * Cannot use super for new instance
 */
@Component
//Lombok
@Log
public class UserSecurityFacade extends AbstractFacade<UserSecurity> {

    public UserSecurity newInstance(String username, String email, String password) {
        UserSecurity res = new UserSecurity();
        res.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        res.setUsername(username);
        res.setEmail(email);
        res.setEmailAuth(true);
        res.setIsDark(false);
        res.setIsProfilePrivacy(true);
        this.updatePassword(res, password);
        this.setConfirm(res);
        return res;
    }

    public void updatePassword(UserSecurity userSecurity, String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userSecurity.setPassword(passwordEncoder.encode(password));
    }

    public void update(UserSecurity userSecurity, String username, String email) {
        userSecurity.setUsername(username);
        if (!userSecurity.getEmail().equals(email)) {
            userSecurity.setEmail(email);
            this.setConfirm(userSecurity);
        }
    }

    public void updatePrivacy(UserSecurity userSecurity, boolean isPrivate) {
        userSecurity.setIsProfilePrivacy(isPrivate);
    }

    public void updateSecurity(UserSecurity userSecurity, boolean emailAuth) {
        userSecurity.setEmailAuth(emailAuth);
    }

    public void updateAppearance(UserSecurity userSecurity, boolean dark) {
        userSecurity.setIsDark(dark);
    }

    public void updateName(UserSecurity userSecurity, String firstName, String lastName) {
        userSecurity.setFirstName(firstName);
        userSecurity.setLastName(lastName);
    }

    public static UserSecurity build(UserSecurity u) {
        UserSecurity res = new UserSecurity();
        res.setId(u.getId());
        res.setUser(u.getUser());
        res.setUsername(u.getUsername());
        res.setEmail(u.getEmail());
        res.setPassword(u.getPassword());
        res.setEnumPermissionList(u.getEnumPermissionList());
        return res;
    }

    public void setConfirm(UserSecurity userSecurity) {
        userSecurity.setConfirmToken(Utils.generateNewToken(42));//TODO unique
        userSecurity.setConfirmSet(new Timestamp(System.currentTimeMillis()));
        userSecurity.setConfirmedAt(null);
        log.info("Validation token for " + userSecurity.getUsername() + " user: " + userSecurity.getConfirmToken()
                + ", the link is: http://localhost:4200/confirm/" + userSecurity.getConfirmToken());
    }

    public void confirm(UserSecurity userSecurity) {
        userSecurity.setConfirmedAt(new Timestamp(System.currentTimeMillis()));
        userSecurity.setConfirmToken(null);
        userSecurity.setConfirmSet(null);
    }

    public void setReset(UserSecurity userSecurity) {
        userSecurity.setResetToken(Utils.generateNewToken(42));//TODO unique
        userSecurity.setResetSet(new Timestamp(System.currentTimeMillis()));
        userSecurity.setResetAt(null);
        log.info("Reset token for " + userSecurity.getUsername() + " user: " + userSecurity.getResetToken()
                + ", the link is: http://localhost:4200/reset/" + userSecurity.getResetToken());
    }

    public void reset(UserSecurity userSecurity, String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userSecurity.setPassword(passwordEncoder.encode(password));
        userSecurity.setResetAt(new Timestamp(System.currentTimeMillis()));
        userSecurity.setResetSet(null);
        userSecurity.setResetToken(null);
    }

    public void setDelete(UserSecurity userSecurity) {
        userSecurity.setDeleteToken(Utils.generateNewToken(42));//TODO unique
        userSecurity.setDeleteSet(new Timestamp(System.currentTimeMillis()));
        log.info("Delete token for " + userSecurity.getUsername() + " user: " + userSecurity.getDeleteToken()
                + ", the link is: http://localhost:4200/delete/" + userSecurity.getDeleteToken());
    }

    public void setDoubleEmail(UserSecurity userSecurity) {
        userSecurity.setEmailAuthToken(Utils.randomNumber(5));
        userSecurity.setEmailAuthSet(new Timestamp(System.currentTimeMillis()));
        userSecurity.setConfirmedAt(null);
        log.info("DoubleAuth token for " + userSecurity.getUsername() + " user: " + userSecurity.getEmailAuthToken());
    }

    public void confirmDoubleEmail(UserSecurity userSecurity) {
        userSecurity.setEmailAuthToken(null);
        userSecurity.setEmailAuthSet(null);
        userSecurity.setConfirmedAt(new Timestamp(System.currentTimeMillis()));
    }

}
