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
public class ParagraphTypeViewDto extends AbstractDto {

    String name;

    String description;

    public ParagraphTypeViewDto(int id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }

}
