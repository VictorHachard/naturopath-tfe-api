package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.GeneralTypeValidator;
import be.heh.app.model.entities.app.Category;
import be.heh.app.model.entities.app.TagType;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class TagTypeService extends AbstractService<TagType> {

    public TagType insertTagType(GeneralTypeValidator generalTypeValidator) {
        TagType tag = tagTypeMapper.map(generalTypeValidator);
        tagTypeRepository.save(tag);
        return tag;
    }

    public void linkTagTypeToCategory(int categoryId, int tagTypeId) {
        if (categoryRepository.findById(categoryId).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
        } else if (tagTypeRepository.findById(tagTypeId).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no TagType with this tagTypeId");
        } else {
            Category category = categoryRepository.findById(categoryId).get();
            category.addTagType(tagTypeRepository.findById(tagTypeId).get());
            categoryRepository.save(category);
        }
    }

}
