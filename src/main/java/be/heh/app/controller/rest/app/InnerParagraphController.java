package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.InnerParagraphValidator;
import be.heh.app.controller.validators.app.update.InnerParagraphUpdateValidator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/innerParagraph/")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class InnerParagraphController extends AbstractController {

    @PostMapping("")
    public void add(@Valid @RequestBody InnerParagraphValidator validator) {
        innerParagraphService.add(validator);
    }

    @PutMapping("update/{id}")
    public void update(@Valid @RequestBody InnerParagraphUpdateValidator validator, @PathVariable("id") int id) {
        innerParagraphService.update(validator, id);
    }

    @PostMapping("validation/{id}")
    public void validation(@PathVariable("id") int id) {
        innerParagraphService.validation(id);
    }

}
