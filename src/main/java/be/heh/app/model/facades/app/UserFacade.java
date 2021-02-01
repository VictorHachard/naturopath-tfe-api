package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.User;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

@Component
public class UserFacade extends AbstractFacade<User> {

    public User newInstance(String username) {
        User res = super.newInstance();
        res.setUsername(username);
        return res;
    }

    public void update(User user, String username) {
        user.setUsername(username);
    }

    // Init
    public User init(String username) {
        User res = super.newInstance();
        res.setUsername(username);
        return res;
    }

}
