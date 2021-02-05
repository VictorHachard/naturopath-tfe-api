package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.Contact;
import be.heh.app.model.entities.security.UserSecurity;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

@Component
public class ContactFacade extends AbstractFacade<Contact> {

    public Contact newInstance(String username, String email, String content) {
        Contact res = super.newInstance();
        res.setUsername(username);
        res.setEmail(email);
        res.setContent(content);
        return res;
    }

    public Contact newInstance(UserSecurity userSecurity, String content) {
        Contact res = super.newInstance();
        res.setUserSecurity(userSecurity);
        res.setContent(content);
        return res;
    }

}
