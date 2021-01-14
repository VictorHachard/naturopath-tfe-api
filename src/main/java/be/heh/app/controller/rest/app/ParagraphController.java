package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.ParagraphValidator;
import be.heh.app.controller.validators.app.update.ParagraphUpdateValidator;
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
public class ParagraphController extends AbstractController {

    @PostMapping("/paragraph")
    public void add(@Valid @RequestBody ParagraphValidator paragraphValidator) {
        paragraphService.add(paragraphValidator);
    }

    @PostMapping("/paragraph/update/{id}")
    public void update(@Valid @RequestBody ParagraphUpdateValidator paragraphUpdateValidator, @PathVariable("id") int id) {
        paragraphService.update(paragraphUpdateValidator, id);
    }

}
