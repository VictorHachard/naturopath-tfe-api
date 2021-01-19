package be.heh.app.dto.edit;

import be.heh.app.dto.commons.AbstractDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class TagEditDto extends AbstractDto {

    public TagEditDto(int id) {
        super(id);
    }

}
