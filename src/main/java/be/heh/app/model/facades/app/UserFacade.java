package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.User;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

@Component
public class UserFacade extends AbstractFacade<User> {

    // Init
    public User init(String username) {
        //User res = super.newInstance(); //TODO
        User res = new User();
        res.setUsername(username);
        return res;
    }

}
