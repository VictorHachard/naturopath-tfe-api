package be.heh.app.mappers.app;

import be.heh.app.controller.validators.app.GeneralTypeValidator;
import be.heh.app.controller.validators.app.ParagraphTypeValidator;
import be.heh.app.dto.view.ParagraphTypeViewDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.ParagraphType;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class ParagraphTypeMapper extends AbstractMapper {

    public ParagraphType set(ParagraphTypeValidator validator) {
        return paragraphTypeFacade.newInstance(
                validator.getName(),
                validator.getDescription(),
                validator.isAlert()
        );
    }

    public void update(ParagraphType paragraphType, ParagraphTypeValidator validator) {
        paragraphType.setName(validator.getName());
        paragraphType.setDescription(validator.getDescription());
        paragraphType.setAlert(validator.isAlert());
    }

    public List<ParagraphTypeViewDto> getAllView(List<ParagraphType> j) {
        List<ParagraphTypeViewDto> res = new ArrayList<>();
        j.forEach(i -> {
            res.add(this.getView(i));
        });
        Collections.sort(res);
        return res;
    }

    public ParagraphTypeViewDto getView(ParagraphType j) {
        return new ParagraphTypeViewDto(
                j.getId(),
                j.getName(),
                j.getDescription(),
                j.isAlert()
        );
    }

}
