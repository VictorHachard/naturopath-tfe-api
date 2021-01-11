package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.Message;
import be.heh.app.model.facades.commons.AbstractFacade;
import be.heh.app.model.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageFacade extends AbstractFacade<Message> {

    @Autowired
    MessageRepository messageRepository;

    @Override
    public Message newInstance() {
        return messageRepository.newInstance();
    }

}
