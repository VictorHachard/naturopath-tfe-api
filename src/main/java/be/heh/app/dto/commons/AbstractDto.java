package be.heh.app.dto.commons;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

// Lombok
@FieldDefaults(level = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
public abstract class AbstractDto {

    int id;

}
