package be.heh.app.mappers.app;

import be.heh.app.dto.view.MessageViewDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.Message;
import be.heh.app.model.entities.app.User;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class MessageMapper extends AbstractMapper {

    public Message set(String content, User user) {
        return messageFacade.newInstance(
                content,
                user);
    }

    public List<MessageViewDto> getAllViewDto(List<Message> messageList) {
        List<MessageViewDto> res = new ArrayList<>();
        messageList.forEach(i -> {
            res.add(this.getViewDto(i));
        });
        return res;
    }

    public MessageViewDto getViewDto(Message message) {
        return new MessageViewDto(
                message.getId()
        );
    }

}
