package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class UserController extends AbstractController {

    /*@PostMapping("/category")
    public void add(@Valid @RequestBody UserValidator categoryValidator) {
        categoryService.add(categoryValidator);
    }

    @PostMapping("/category/update/{id}")
    public void update(@Valid @RequestBody CategoryValidator categoryValidator, @PathVariable("id") int id) {
        categoryService.update(categoryValidator, id);
    }*/


}
