package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.GeneralTypeValidator;
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
public class TagTypeController extends AbstractController {

    @PostMapping("/tagType")
    public void add(@Valid @RequestBody GeneralTypeValidator generalTypeValidator) {
        tagTypeService.add(generalTypeValidator);
    }

    @PostMapping("/tagType/{tagTypeId}/linkToCategory/{categoryId}")
    public void linkTagTypeToCategory(@PathVariable("categoryId") int categoryId, @PathVariable("tagTypeId") int tagTypeId) {
        tagTypeService.linkTagTypeToCategory(categoryId, tagTypeId);
    }

}
