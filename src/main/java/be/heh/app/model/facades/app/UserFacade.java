package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.User;
import be.heh.app.model.facades.commons.AbstractFacade;
import be.heh.app.model.repositories.app.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserFacade extends AbstractFacade<User> {

    @Autowired
    UserRepository userRepository;

    public User newInstance(String lang) {
        //User res = super.newInstance(); //TODO
        User res = new User();
        res.setLang(lang);
        return res;
    }

}
