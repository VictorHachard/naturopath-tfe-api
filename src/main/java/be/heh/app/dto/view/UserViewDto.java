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
public class UserViewDto extends AbstractDto {

    String username;

    public UserViewDto(int id, String username) {
        super(id);
        this.username = username;
    }

}
