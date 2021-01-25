package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.dto.view.ParagraphViewDto;
import be.heh.app.model.entities.app.Paragraph;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class ParagraphService extends AbstractService<Paragraph> {

    public List<ParagraphViewDto> getAllDto() {
        return paragraphMapper.getAllView(super.getAll());
    }

    public ParagraphViewDto getDto(int id) {
        return paragraphMapper.getView(super.get(id));
    }

    /*@Override
    public void add(AbstractValidator abstractValidator) {
        ParagraphValidator validator = (ParagraphValidator) abstractValidator;

        if (pageRepository.findById(validator.getPageId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Page with this categoryId");
        } else if (userRepository.findById(validator.getUserId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no User with this userId");
        } else if (paragraphTypeRepository.findById(validator.getParagraphTypeId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no ParagraphType with this paragraphTypeId");
        } else {
            InnerParagraph innerParagraph = innerParagraphMapper.set(validator, userRepository.findById(validator.getUserId()).get());
            Paragraph paragraph = paragraphMapper.set(innerParagraph, paragraphTypeRepository.findById(validator.getParagraphTypeId()).get(), userRepository.findById(validator.getUserId()).get());
            if (!pageRepository.findById(validator.getPageId()).get().getCategory().getSortedTypeList().contains(paragraph.getParagraphType())) {//TODO
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The paragraph don't math the rule");
            } else if (!pageFacade.verifyTypeParagraph(pageRepository.findById(validator.getPageId()).get(), paragraph.getParagraphType())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The rule of the paragraph is duplicate");
            }
            innerParagraphRepository.save(innerParagraph);
            paragraphRepository.save(paragraph);
            Page page = pageRepository.findById(validator.getPageId()).get();
            page.addParagraph(paragraph);
            pageRepository.save(page);
            //throw new ResponseStatusException(HttpStatus.CREATED, "The rule of the paragraph is duplicate");
        }
    }*/

}
