package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.MessageValidator;
import be.heh.app.controller.validators.app.update.MessageUpdateValidator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class MessageController extends AbstractController {

    @PostMapping("/message")
    public void add(@Valid @RequestBody MessageValidator validator) {
        messageService.add(validator);
    }

    @PostMapping("/message/update/{id}")
    public void add(@Valid @RequestBody MessageUpdateValidator validator, @PathVariable("id") int id) {
        messageService.update(validator, id);
    }

}
