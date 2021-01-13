package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.TagUpdateValidator;
import be.heh.app.controller.validators.app.TagValidator;
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
public class TagController extends AbstractController {

    @PostMapping("/tag")
    public void add(@Valid @RequestBody TagValidator tagValidator) {
        tagService.add(tagValidator);
    }

    @PostMapping("/tag/update/{id}")
    public void update(@Valid @RequestBody TagUpdateValidator tagUpdateValidator, @PathVariable("id") int id) {
        tagService.update(tagUpdateValidator, id);
    }

}
