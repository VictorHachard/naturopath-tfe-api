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
public class ParatagTypeViewDto implements Comparable<ParatagTypeViewDto> {

    int id;

    String name;

    String description;

    boolean alert;

    TagTypeViewDto tagType;

    EnumSize size;

    @Override
    public int compareTo(ParatagTypeViewDto o) {
        return this.getName().compareTo(o.getName());
    }

}
