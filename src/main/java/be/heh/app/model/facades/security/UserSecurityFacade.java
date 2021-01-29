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
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        res.setPassword(passwordEncoder.encode(password));
        res.setAllEmails(1);
        res.setProfilePrivacy(0);
        this.setConfirm(res);
        return res;
    }

    public void setConfirm(UserSecurity userSecurity) {
        userSecurity.setConfirmToken(Utils.generateNewToken(42));//TODO unique
        userSecurity.setConfirmSet(new Timestamp(System.currentTimeMillis()));
        userSecurity.setConfirmedAt(null);
        log.info("Validation token for " + userSecurity.getUsername() + " user :" + userSecurity.getConfirmToken());
    }

    public void confirm(UserSecurity userSecurity) {
        userSecurity.setConfirmedAt(new Timestamp(System.currentTimeMillis()));
        userSecurity.setConfirmToken(null);
        userSecurity.setConfirmSet(null);
    }

    public void setReset(UserSecurity userSecurity) {
        userSecurity.setResetToken(Utils.generateNewToken(42));//TODO unique
        userSecurity.setResetSet(new Timestamp(System.currentTimeMillis()));
        userSecurity.setResetToken(null);
        log.info("Reset token for " + userSecurity.getUsername() + " user :" + userSecurity.getResetToken());
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
        log.info("Delete token for " + userSecurity.getUsername() + " user :" + userSecurity.getResetToken());
    }

}
