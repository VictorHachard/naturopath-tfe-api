package be.heh.app.controller.services;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.TagTypeValidator;
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
public class TagTypeService extends AbstractService {

    public List<TagType> getAllTagType() {

        if (tagTypeRepository.findAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no TagType in the database");
        } else {
            return tagTypeRepository.findAll();
        }
    }

    public TagType getTagType(int id) {
        if (tagTypeRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no TagType with this TagTypeId");
        } else {
            return tagTypeRepository.findById(id).get();
        }
    }

    public TagType insertTagType(TagTypeValidator tagTypeValidator) {
        TagType tag = tagTypeMapper.map(tagTypeValidator);
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
