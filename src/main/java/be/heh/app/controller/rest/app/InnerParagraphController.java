package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.InnerParagraphValidator;
import be.heh.app.controller.validators.app.update.InnerParagraphUpdateValidator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/innerParagraph/")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class InnerParagraphController extends AbstractController {

    @PostMapping("")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public void add(@Valid @RequestBody InnerParagraphValidator validator) {
        innerParagraphService.add(validator);
    }

    @PutMapping("update/{id}")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public void update(@Valid @RequestBody InnerParagraphUpdateValidator validator, @PathVariable("id") int id) {
        innerParagraphService.update(validator, id);
    }

    @PostMapping("validation/{id}")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public void validation(@PathVariable("id") int id) {
        innerParagraphService.validation(id);
    }

}
