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
@RequestMapping("api/v1")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class InnerPageController extends AbstractController {

    @PostMapping("/innerPage")
    public void add(@Valid @RequestBody InnerPageValidator validator) {
        innerPageService.add(validator);
    }

    @PostMapping("/innerPage/update/{id}")
    public void update(@Valid @RequestBody InnerPageUpdateValidator validator, @PathVariable("id") int id) {
        System.out.println(10);
        innerPageService.update(validator, id);
    }

    @PostMapping("/innerPage/validation/{id}")
    public void validation(@PathVariable("id") int id) {
        innerPageService.validation(id);
    }

}
