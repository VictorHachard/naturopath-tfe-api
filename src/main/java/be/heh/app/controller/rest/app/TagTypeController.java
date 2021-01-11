package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.services.app.TagTypeService;
import be.heh.app.controller.validators.app.TagTypeValidator;
import be.heh.app.model.entities.app.TagType;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class TagTypeController extends AbstractController {

    @GetMapping("/tagType")
    public List<TagType> getAllTagType() {
        return tagTypeService.getAllTagType();
    }

    @GetMapping("/tagType/{id}")
    public TagType getTagType(@PathVariable("id") int id) {
        return tagTypeService.getTagType(id);
    }

    @PostMapping("/tagType")
    public TagType insertTagType(@Valid @RequestBody TagTypeValidator tagTypeValidator) {
        return tagTypeService.insertTagType(tagTypeValidator);
    }

    @PostMapping("/tagType/{tagTypeId}/linkToCategory/{categoryId}")
    public void linkTagTypeToCategory(@PathVariable("categoryId") int categoryId, @PathVariable("tagTypeId") int tagTypeId) {
        tagTypeService.linkTagTypeToCategory(categoryId, tagTypeId);
    }

}
