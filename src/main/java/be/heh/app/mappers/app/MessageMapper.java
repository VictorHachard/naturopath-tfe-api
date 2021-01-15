package be.heh.app.mappers.app;

import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.Message;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.facades.app.MessageFacade;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class MessageMapper extends AbstractMapper {

    @Autowired
    MessageFacade messageFacade;

    public Message set(String content, User user) {
        return messageFacade.newInstance(content, user);
    }

}
