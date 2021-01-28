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
        res.setValidationToken(Utils.generateNewToken());//TODO unique
        res.setConfirmSet(new Timestamp(System.currentTimeMillis()));
        //TODO send mail
        log.info("Validation token for " + username + " user :" + res.getValidationToken());
        res.setAllEmails(1);
        res.setProfilePrivacy(0);
        return res;
    }

}
