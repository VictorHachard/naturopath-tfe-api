package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.MessageValidator;
import be.heh.app.controller.validators.app.update.InnerImageUpdateValidator;
import be.heh.app.controller.validators.app.validation.InnerImageValidationValidator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/innerImage/")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class InnerImageController extends AbstractController {

    @PostMapping("{imageId}")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public void add(@Valid @RequestBody InnerImageUpdateValidator validator, @PathVariable("imageId") int imageId) {
        innerImageService.addC(validator, imageId);
    }

    @PutMapping("update/{id}")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public void update(@Valid @RequestBody InnerImageUpdateValidator validator, @PathVariable("id") int id) {
        innerImageService.update(validator, id);
    }

    @PostMapping("validation/{id}")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public void validation(@Valid @RequestBody InnerImageValidationValidator validator, @PathVariable("id") int id) {
        innerImageService.validation(validator, id);
    }

    @PostMapping("addMessage/{id}")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public void addMessage(@Valid @RequestBody MessageValidator validator, @PathVariable("id") int id) {
        innerImageService.addMessage(validator, id);
    }

}
