package be.heh.app.mappers.app;

import be.heh.app.controller.validators.app.GeneralTypeValidator;
import be.heh.app.dto.view.ParagraphTypeViewDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.ParagraphType;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class ParagraphTypeMapper extends AbstractMapper {

    public ParagraphType set(GeneralTypeValidator generalTypeValidator) {
        return paragraphTypeFacade.newInstance(
                generalTypeValidator.getName(),
                generalTypeValidator.getDescription());
    }

    public List<ParagraphTypeViewDto> getAllView(List<ParagraphType> j) {
        List<ParagraphTypeViewDto> res = new ArrayList<>();
        j.forEach(i -> {
            res.add(this.getView(i));
        });
        return res;
    }

    public ParagraphTypeViewDto getView(ParagraphType j) {
        return new ParagraphTypeViewDto(
                j.getId(),
                j.getName(),
                j.getDescription()
        );
    }

}
