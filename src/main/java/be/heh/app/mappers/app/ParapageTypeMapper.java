package be.heh.app.mappers.app;

import be.heh.app.dto.view.ParapageTypeViewDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.ParapageType;
import be.heh.app.model.facades.app.ParapageTypeFacade;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class ParapageTypeMapper extends AbstractMapper {

    @Autowired
    ParapageTypeFacade parapageTypeFacade;

    public List<ParapageTypeViewDto> getAllView(List<ParapageType> j) {
        List<ParapageTypeViewDto> res = new ArrayList<>();
        j.forEach(i -> {
            res.add(this.getView(i));
        });
        return res;
    }

    public ParapageTypeViewDto getView(ParapageType parapageType) {
        return new ParapageTypeViewDto(
                parapageType.getId(),
                parapageType.getName(),
                parapageType.getDescription()
        );
    }

}
