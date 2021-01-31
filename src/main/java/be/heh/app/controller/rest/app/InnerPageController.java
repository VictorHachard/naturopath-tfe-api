package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.InnerPageValidator;
import be.heh.app.controller.validators.app.update.InnerPageUpdateValidator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/innerPage/")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class InnerPageController extends AbstractController {

    @PostMapping("")
    public void add(@Valid @RequestBody InnerPageValidator validator) {
        innerPageService.add(validator);
    }

    @PutMapping("update/{id}")
    public void update(@Valid @RequestBody InnerPageUpdateValidator validator, @PathVariable("id") int id) {
        innerPageService.update(validator, id);
    }

    @PostMapping("validation/{id}")
    public void validation(@PathVariable("id") int id) {
        innerPageService.validation(id);
    }

}
