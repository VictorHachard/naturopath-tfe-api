package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.MessageValidator;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.model.entities.app.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class MessageService extends AbstractService<Message> {

    @Override
    public void add(AbstractValidator abstractValidator) {
        MessageValidator messageValidator = (MessageValidator) abstractValidator;

        if (userRepository.findById(messageValidator.getUserId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no User with this userId");
        }
        User user = userRepository.findById(messageValidator.getUserId()).get();
        Message message;
        if (messageValidator.getType().equals("InnerPage")) {
            message = messageMapper.set(messageValidator.getContent(), user);
            if (innerPageRepository.findById(messageValidator.getTypeId()).isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no innerPage with this typeId");
            }
            InnerPage innerPage = innerPageRepository.findById(messageValidator.getTypeId()).get();
            messageRepository.save(message);
            innerPage.addMessage(message);
            innerPageRepository.save(innerPage);
        } else if (messageValidator.getType().equals("InnerParagraph")) {
            message = messageMapper.set(messageValidator.getContent(), user);
            if (innerPageRepository.findById(messageValidator.getTypeId()).isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no InnerParagraph with this typeId");
            }
            InnerParagraph innerParagraph = innerParagraphRepository.findById(messageValidator.getTypeId()).get();
            messageRepository.save(message);
            innerParagraph.addMessage(message);
            innerParagraphRepository.save(innerParagraph);

        } else if (messageValidator.getType().equals("InnerTag")) {
            message = messageMapper.set(messageValidator.getContent(), user);
            if (innerTagRepository.findById(messageValidator.getTypeId()).isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no InnerTag with this typeId");
            }
            InnerTag innerTag = innerTagRepository.findById(messageValidator.getTypeId()).get();
            messageRepository.save(message);
            innerTag.addMessage(message);
            innerTagRepository.save(innerTag);
        } else { // TODO 2 nouveau inner a ajouter
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "logique  getType est pas bon");
        }
    }

}
