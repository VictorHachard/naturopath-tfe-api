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
public class ParagraphTypeController extends AbstractController {

    @PostMapping("/paragraphType")
    public void add(@Valid @RequestBody GeneralTypeValidator generalTypeValidator) {
        paragraphTypeService.add(generalTypeValidator);
    }

    @PostMapping("/paragraphType/{paragraphTypeId}/linkToCategory/{categoryId}")
    public void linkParagraphTypeToCategory(@PathVariable("categoryId") int categoryId, @PathVariable("paragraphTypeId") int paragraphTypeId) {
        paragraphTypeService.linkParagraphTypeToCategory(categoryId, paragraphTypeId);
    }

}
