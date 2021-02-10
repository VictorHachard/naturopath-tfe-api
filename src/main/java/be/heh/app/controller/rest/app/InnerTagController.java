package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.MessageValidator;
import be.heh.app.controller.validators.app.update.InnerTagUpdateValidator;
import be.heh.app.controller.validators.app.validation.InnerTagValidationValidator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/innerTag/")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class InnerTagController extends AbstractController {

    @PostMapping("{tagId}")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public void add(@Valid @RequestBody InnerTagUpdateValidator validator, @PathVariable("tagId") int tagId) {
        innerTagService.addC(validator, tagId);
    }

    @PutMapping("update/{id}")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public void update(@Valid @RequestBody InnerTagUpdateValidator validator, @PathVariable("id") int id) {
        innerTagService.update(validator, id);
    }

    @PostMapping("validation/{id}")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public void validation(@Valid @RequestBody InnerTagValidationValidator validator, @PathVariable("id") int id) {
        innerTagService.validation(validator, id);
    }

    @PostMapping("addMessage/{id}")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public void addMessage(@Valid @RequestBody MessageValidator validator, @PathVariable("id") int id) {
        innerTagService.addMessage(validator, id);
    }

}
