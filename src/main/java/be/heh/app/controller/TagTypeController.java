package be.heh.app.controller;

import be.heh.app.controller.validators.TagTypeValidator;
import be.heh.app.mapper.TagTypeMapper;
import be.heh.app.model.entities.app.Category;
import be.heh.app.model.entities.app.TagType;
import be.heh.app.model.repositories.CategoryRepository;
import be.heh.app.model.repositories.TagTypeRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class TagTypeController {

    @Autowired
    TagTypeRepository tagTypeRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/tagType")
    public List<TagType> getAllTagType() {
        if (tagTypeRepository.findAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no TagType in the database");
        } else {
            return tagTypeRepository.findAll();
        }
    }

    @GetMapping("/tagType/{id}")
    public TagType getTagType(@PathVariable("id") int id) {
        if (!tagTypeRepository.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no TagType with this TagTypeId");
        } else {
            return tagTypeRepository.findById(id).get();
        }
    }

    @PostMapping("/tagType")
    public TagType insertTagType(@Valid @RequestBody TagTypeValidator tagTypeValidator) {
        TagType tag = TagTypeMapper.map(tagTypeValidator);
        tagTypeRepository.save(tag);
        return tag;
    }

    @PostMapping("/tagTypeLink/{categoryId}/{tagTypeId}")
    public void link(@PathVariable("categoryId") int categoryId, @PathVariable("tagTypeId") int tagTypeId) {
        if (!categoryRepository.findById(categoryId).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
        } else if (!tagTypeRepository.findById(tagTypeId).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no TagType with this tagTypeId");
        } else {
            Category category = categoryRepository.findById(categoryId).get();
            category.addTagType(tagTypeRepository.findById(tagTypeId).get());
            categoryRepository.save(category);
        }
    }
}
