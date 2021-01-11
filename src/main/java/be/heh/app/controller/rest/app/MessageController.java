package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.services.app.MessageService;
import be.heh.app.controller.validators.app.MessageValidator;
import be.heh.app.model.entities.app.Message;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class MessageController extends AbstractController {

    @GetMapping("/message")
    public List<Message> getAllMessage() {
        return messageService.getAllMessage();
    }

    @GetMapping("/message/{id}")
    public Message getMessage(@PathVariable("id") int id) {
        return messageService.getMessage(id);
    }

    @PostMapping("/message")
    public Message insertMessage(@Valid @RequestBody MessageValidator messageValidator) {
        return messageService.insertMessage(messageValidator);
    }

}
