package be.heh.app.dto.commons;

import lombok.*;
import lombok.experimental.FieldDefaults;

// Lombok
@FieldDefaults(level = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
public abstract class AbstractDto {

    int id;

}
