package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.InnerParagraphValidator;
import be.heh.app.controller.validators.app.InnerTagValidator;
import be.heh.app.controller.validators.app.update.InnerPageUpdateValidator;
import be.heh.app.controller.validators.app.update.InnerParagraphUpdateValidator;
import be.heh.app.controller.validators.app.update.InnerTagUpdateValidator;
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
public class InnerTagController extends AbstractController {

    @PostMapping("/innerTag")
    public void add(@Valid @RequestBody InnerTagValidator validator) {
        innerTagService.add(validator);
    }

    @PostMapping("/innerTag/update/{id}")
    public void update(@Valid @RequestBody InnerTagUpdateValidator validator, @PathVariable("id") int id) {
        innerTagService.update(validator, id);
    }

    @PostMapping("/innerTag/validation/{id}")
    public void validation(@PathVariable("id") int id) {
        innerTagService.validation(id);
    }

}
