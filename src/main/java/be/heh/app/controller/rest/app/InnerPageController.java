package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.MessageValidator;
import be.heh.app.controller.validators.app.update.InnerPageUpdateValidator;
import be.heh.app.controller.validators.app.validation.InnerPageValidationValidator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/innerPage/")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class InnerPageController extends AbstractController {

    @PostMapping("{PageId}")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public void add(@Valid @RequestBody InnerPageUpdateValidator validator, @PathVariable("PageId") int PageId) {
        innerPageService.addC(validator, PageId);
    }

    @PutMapping("update/{id}")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public void update(@Valid @RequestBody InnerPageUpdateValidator validator, @PathVariable("id") int id) {
        innerPageService.update(validator, id);
    }

    @PostMapping("validation/{id}")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public void validation(@Valid @RequestBody InnerPageValidationValidator validator, @PathVariable("id") int id) {
        innerPageService.validation(validator, id);
    }

    @PostMapping("addMessage/{id}")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public void addMessage(@Valid @RequestBody MessageValidator validator, @PathVariable("id") int id) {
        innerPageService.addMessage(validator, id);
    }

}
