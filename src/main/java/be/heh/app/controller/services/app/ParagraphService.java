package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.ParagraphUpdateValidator;
import be.heh.app.controller.validators.app.ParagraphValidator;
import be.heh.app.model.entities.app.InnerParagraph;
import be.heh.app.model.entities.app.Page;
import be.heh.app.model.entities.app.Paragraph;
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
public class ParagraphService extends AbstractService {

    public List<Paragraph> getAllParagraph() {
        if (paragraphRepository.findAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Paragraph in the database");
        } else {
            return paragraphRepository.findAll();
        }
    }

    public Paragraph getParagraph(int id) {
        if (paragraphRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Paragraph with this paragraphId");
        } else {
            return paragraphRepository.findById(id).get();
        }
    }

    public Paragraph insertParagraph(ParagraphValidator paragraphValidator) {
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
            innerParagraphRepository.save(innerParagraph);
            paragraphRepository.save(paragraph);
            Page page = pageRepository.findById(paragraphValidator.getPageId()).get();
            page.addParagraph(paragraph);
            pageRepository.save(page);
            return paragraph;
            //throw new ResponseStatusException(HttpStatus.CREATED, "The rule of the paragraph is duplicate");
        }
    }

    public Paragraph updateParagraph(ParagraphUpdateValidator paragraphUpdateValidator, int id) {
        if (userRepository.findById(paragraphUpdateValidator.getUserId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no User with this userId");
        } else if (paragraphRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Paragraph with this id");
        } else {
            Paragraph paragraph = paragraphRepository.findById(id).get();
            InnerParagraph innerParagraph = innerParagraphMapper.map(paragraphUpdateValidator, paragraph.getInnerParagraphList().get(paragraph.getInnerParagraphList().size() - 1).getVersion() + 1, userRepository.findById(paragraphUpdateValidator.getUserId()).get());
            innerParagraphRepository.save(innerParagraph);
            paragraph.addInnerParagraph(innerParagraph);
            paragraphRepository.save(paragraph);
            return paragraph;
            //throw new ResponseStatusException(HttpStatus.CREATED, "The rule of the paragraph is duplicate");
        }
    }

}
