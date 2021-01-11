package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.ParagraphTypeValidator;
import be.heh.app.model.entities.app.ParagraphType;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class ParagraphTypeController extends AbstractController {

    @GetMapping("/paragraphType")
    public List<ParagraphType> getAllParagraphType() {
        return paragraphTypeService.getAllParagraphType();
    }

    @GetMapping("/paragraphType/{id}")
    public ParagraphType getParagraphType(@PathVariable("id") int id) {
        return paragraphTypeService.getParagraphType(id);
    }

    @PostMapping("/paragraphType")
    public ParagraphType insertParagraphType(@Valid @RequestBody ParagraphTypeValidator paragraphTypeValidator) {
        return paragraphTypeService.insertParagraphType(paragraphTypeValidator);
    }

    @PostMapping("/paragraphType/{paragraphTypeId}/linkToCategory/{categoryId}")
    public void linkParagraphTypeToCategory(@PathVariable("categoryId") int categoryId, @PathVariable("paragraphTypeId") int paragraphTypeId) {
        paragraphTypeService.linkParagraphTypeToCategory(categoryId, paragraphTypeId);
    }

}
