package be.heh.app.dto.view;

import be.heh.app.model.entities.app.enumeration.EnumSize;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
public class ParatagTypeViewDto {

    int id;

    String name;

    String description;

    TagTypeViewDto tagType;

    EnumSize size;

}
