package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.InnerParagraphValidator;
import be.heh.app.controller.validators.app.InnerParatagValidator;
import be.heh.app.controller.validators.app.MessageValidator;
import be.heh.app.controller.validators.app.update.InnerParagraphUpdateValidator;
import be.heh.app.controller.validators.app.update.InnerParatagUpdateValidator;
import be.heh.app.controller.validators.app.validation.InnerParagraphValidationValidator;
import be.heh.app.controller.validators.app.validation.InnerParatagValidationValidator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/innerParatag/")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class InnerParatagController extends AbstractController {

    @PostMapping("{paratagId}")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public void add(@Valid @RequestBody InnerParatagValidator validator, @PathVariable("paratagId") int paratagId) {
        innerParatagService.addC(validator, paratagId);
    }

    @PutMapping("update/{id}")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public void update(@Valid @RequestBody InnerParatagUpdateValidator validator, @PathVariable("id") int id) {
        innerParatagService.update(validator, id);
    }

    @PostMapping("validation/{id}")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public void validation(@Valid @RequestBody InnerParatagValidationValidator validator, @PathVariable("id") int id) {
        innerParatagService.validation(validator, id);
    }

    @PostMapping("addMessage/{id}")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public void addMessage(@Valid @RequestBody MessageValidator validator, @PathVariable("id") int id) {
        innerParatagService.addMessage(validator, id);
    }

}