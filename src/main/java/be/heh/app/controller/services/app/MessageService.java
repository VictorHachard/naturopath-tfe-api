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
        MessageValidator validator = (MessageValidator) abstractValidator;
        User user = this.getUser();
        Message message;
        if (validator.getType().equals("InnerPage")) {
            message = messageMapper.set(validator.getContent(), user);
            if (innerPageRepository.findById(validator.getTypeId()).isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no innerPage with this typeId");
            }
            InnerPage innerPage = innerPageRepository.findById(validator.getTypeId()).get();
            messageRepository.save(message);
            innerPage.addMessage(message);
            innerPageRepository.save(innerPage);
        } else if (validator.getType().equals("InnerParagraph")) {
            message = messageMapper.set(validator.getContent(), user);
            if (innerPageRepository.findById(validator.getTypeId()).isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no InnerParagraph with this typeId");
            }
            InnerParagraph innerParagraph = innerParagraphRepository.findById(validator.getTypeId()).get();
            messageRepository.save(message);
            innerParagraph.addMessage(message);
            innerParagraphRepository.save(innerParagraph);

        } else if (validator.getType().equals("InnerTag")) {
            message = messageMapper.set(validator.getContent(), user);
            if (innerTagRepository.findById(validator.getTypeId()).isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no InnerTag with this typeId");
            }
            InnerTag innerTag = innerTagRepository.findById(validator.getTypeId()).get();
            messageRepository.save(message);
            innerTag.addMessage(message);
            innerTagRepository.save(innerTag);
        } else { // TODO 2 nouveau inner a ajouter
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "logique getType est pas bon");
        }
    }

    @Override
    public void update(AbstractValidator abstractValidator, int id) {
        super.update(abstractValidator, id);//TODO edited bool
    }
}
