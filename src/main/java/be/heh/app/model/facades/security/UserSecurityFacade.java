package be.heh.app.model.facades.security;

import be.heh.app.model.entities.security.UserSecurity;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserSecurityFacade extends AbstractFacade<UserSecurity> {

    public UserSecurity newInstance(String username, String email, String firstName, String lastName, String password, Date birth) {
        UserSecurity res = super.newInstance();
        res.setUsername(username);
        res.setEmail(email);
        res.setFirstName(firstName);
        res.setLastName(lastName);
        res.setPassword(password);
        res.setBirth(birth);
        res.setAllEmails(1);
        res.setProfilePrivacy(0);
        return res;
    }

}
