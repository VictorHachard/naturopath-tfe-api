package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.Message;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

@Component
public class MessageFacade extends AbstractFacade<Message> {

    public Message newInstance(String content, User user) {
        Message message = new Message();
        message.setContent(content);
        message.setUser(user);
        return message;
    }

}
