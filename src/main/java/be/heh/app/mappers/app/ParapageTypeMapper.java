package be.heh.app.mappers.app;

import be.heh.app.controller.validators.app.ParagraphTypeValidator;
import be.heh.app.dto.view.ParapageTypeViewDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.ParapageType;
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
public final class ParapageTypeMapper extends AbstractMapper {

    public ParapageType set(ParagraphTypeValidator validator) {
        return parapageTypeFacade.newInstance(
                validator.getName(),
                validator.getDescription(),
                validator.isAlert()
        );
    }

    public void update(ParapageType parapageType, ParagraphTypeValidator validator) {
        parapageType.setName( validator.getName());
        parapageType.setDescription(validator.getDescription());
        parapageType.setAlert(validator.isAlert());
    }

    public List<ParapageTypeViewDto> getAllView(List<ParapageType> j) {
        List<ParapageTypeViewDto> res = new ArrayList<>();
        j.forEach(i -> {
            res.add(this.getView(i));
        });
        Collections.sort(res);
        return res;
    }

    public ParapageTypeViewDto getView(ParapageType j) {
        return new ParapageTypeViewDto(
                j.getId(),
                j.getName(),
                j.getDescription(),
                j.isAlert()
        );
    }

}
