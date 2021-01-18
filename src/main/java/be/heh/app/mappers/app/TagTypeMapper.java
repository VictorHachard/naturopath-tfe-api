package be.heh.app.mappers.app;

import be.heh.app.controller.validators.app.GeneralTypeValidator;
import be.heh.app.dto.view.TagTypeViewDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.TagType;
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
public final class TagTypeMapper extends AbstractMapper {

    public TagType set(GeneralTypeValidator generalTypeValidator) {
        return tagTypeFacade.newInstance(generalTypeValidator.getName(), generalTypeValidator.getDescription());
    }

    public List<TagTypeViewDto> getAllView(List<TagType> j) {
        List<TagTypeViewDto> res = new ArrayList<>();
        j.forEach(i -> {
            res.add(this.getView(i));
        });
        return res;
    }

    public TagTypeViewDto getView(TagType tagType) {
        return new TagTypeViewDto(
                tagType.getId(),
                tagType.getName(),
                tagType.getDescription()
        );
    }

}
