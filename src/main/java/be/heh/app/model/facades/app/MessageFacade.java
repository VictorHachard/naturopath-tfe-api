package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.*;
import be.heh.app.model.entities.app.enumeration.EnumState;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

@Component
public class MessageFacade extends AbstractFacade<Message> {

    public Message newInstance(String content, User user) {
        Message res = super.newInstance();
        res.setContent(content);
        res.setUser(user);
        return res;
    }

    public Message init(String content) {
        Message res = super.newInstance();
        res.setContent(content);
        res.setUser(userRepository.findById(this.userId).get());
        return res;
    }

}
