package be.heh.app.model.facades.secutity;

import be.heh.app.model.entities.security.UserSecurity;
import be.heh.app.model.facades.commons.AbstractFacade;
import be.heh.app.model.repositories.UserSecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSecurityFacade extends AbstractFacade<UserSecurity> {

    @Autowired
    UserSecurityRepository userSecurityRepository;

    @Override
    public UserSecurity newInstance() {
        return new UserSecurity();
    }

}
