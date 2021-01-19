package be.heh.app.dto.view;

import be.heh.app.dto.commons.AbstractDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class ParatagTypeViewDto extends AbstractDto {

    String name;

    String description;

    TagTypeViewDto tagType;

    public ParatagTypeViewDto(int id, String name, String description, TagTypeViewDto tagType) {
        super(id);
        this.name = name;
        this.description = description;
        this.tagType = tagType;
    }

}
