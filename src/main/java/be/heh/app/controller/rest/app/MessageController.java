package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.MessageValidator;
import be.heh.app.controller.validators.app.update.MessageUpdateValidator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/message/")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class MessageController extends AbstractController {

    @PostMapping("")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public void add(@Valid @RequestBody MessageValidator validator) {
        messageService.add(validator);
    }

    @PostMapping("update/{id}")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public void update(@Valid @RequestBody MessageUpdateValidator validator, @PathVariable("id") int id) {
        messageService.update(validator, id);
    }

}
