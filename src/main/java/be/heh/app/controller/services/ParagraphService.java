package be.heh.app.controller.services;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.ParagraphValidator;
import be.heh.app.mappers.ParagraphMapper;
import be.heh.app.model.entities.app.InnerParagraph;
import be.heh.app.model.entities.app.Page;
import be.heh.app.model.entities.app.Paragraph;
import be.heh.app.model.repositories.PageRepository;
import be.heh.app.model.repositories.ParagraphRepository;
import be.heh.app.model.repositories.ParagraphTypeRepository;
import be.heh.app.model.repositories.UserRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class ParagraphService extends AbstractService {

    @GetMapping("/paragraph")
    public List<Paragraph> getAllParagraph() {
        if (paragraphRepository.findAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Paragraph in the database");
        } else {
            return paragraphRepository.findAll();
        }
    }

    @GetMapping("/paragraph/{id}")
    public Paragraph getParagraph(@PathVariable("id") int id) {
        if (paragraphRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Paragraph with this paragraphId");
        } else {
            return paragraphRepository.findById(id).get();
        }
    }

    @PostMapping("/paragraph")
    public Paragraph insertParagraph(@Valid @RequestBody ParagraphValidator paragraphValidator) {
        if (pageRepository.findById(paragraphValidator.getPageId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Page with this categoryId");
        } else if (userRepository.findById(paragraphValidator.getUserId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no User with this userId");
        } else if (paragraphTypeRepository.findById(paragraphValidator.getParagraphTypeId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no ParagraphType with this paragraphTypeId");
        } else {
            InnerParagraph innerParagraph = innerParagraphMapper.map(paragraphValidator, userRepository.findById(paragraphValidator.getUserId()).get());
            Paragraph paragraph = paragraphMapper.map(innerParagraph, paragraphTypeRepository.findById(paragraphValidator.getParagraphTypeId()).get(), userRepository.findById(paragraphValidator.getUserId()).get());
            if (!pageRepository.findById(paragraphValidator.getPageId()).get().getCategory().getParagraphTypeList().contains(paragraph.getParagraphType())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The paragraph don't math the rule");
            } else if (!pageRepository.findById(paragraphValidator.getPageId()).get().verifyTypeParagraph(paragraph.getParagraphType())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The rule of the paragraph is duplicate");
            }
            Page page = pageRepository.findById(paragraphValidator.getPageId()).get();
            page.addParagraph(paragraph);

            paragraphRepository.save(paragraph);
            pageRepository.save(page);
            return paragraph;
            //throw new ResponseStatusException(HttpStatus.CREATED, "The rule of the paragraph is duplicate");
        }
    }

}
