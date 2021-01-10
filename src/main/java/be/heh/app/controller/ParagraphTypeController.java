package be.heh.app.controller;

import be.heh.app.controller.validators.ParagraphTypeValidator;
import be.heh.app.mapper.ParagraphTypeMapper;
import be.heh.app.model.entities.app.Category;
import be.heh.app.model.entities.app.ParagraphType;
import be.heh.app.model.repositories.CategoryRepository;
import be.heh.app.model.repositories.ParagraphTypeRepository;
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
public class ParagraphTypeController {

    @Autowired
    ParagraphTypeRepository paragraphTypeRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/paragraphType")
    public List<ParagraphType> getAllParagraphType() {
        if (paragraphTypeRepository.findAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no ParagraphType in the database");
        } else {
            return paragraphTypeRepository.findAll();
        }
    }

    @GetMapping("/paragraphType/{id}")
    public ParagraphType getParagraphType(@PathVariable("id") int id) {
        if (paragraphTypeRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no ParagraphType with this paragraphTypeId");
        } else {
            return paragraphTypeRepository.findById(id).get();
        }
    }

    @PostMapping("/paragraphType")
    public ParagraphType insertParagraphType(@Valid @RequestBody ParagraphTypeValidator paragraphTypeValidator) {
        ParagraphType tag = ParagraphTypeMapper.map(paragraphTypeValidator);
        paragraphTypeRepository.save(tag);
        return tag;
    }

    @PostMapping("/paragraphTypeLink/{categoryId}/{paragraphTypeId}")
    public void link(@PathVariable("categoryId") int categoryId, @PathVariable("paragraphTypeId") int paragraphTypeId) {
        if (categoryRepository.findById(categoryId).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Category with this categoryId");
        } else if (paragraphTypeRepository.findById(paragraphTypeId).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no ParagraphType with this paragraphTypeId");
        } else {
            Category category = categoryRepository.findById(categoryId).get();
            category.addParagraphType(paragraphTypeRepository.findById(paragraphTypeId).get());
            categoryRepository.save(category);
        }
    }

}
