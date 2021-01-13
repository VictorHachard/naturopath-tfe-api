package be.heh.app.dto.commons;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

// Lombok
@FieldDefaults(level = AccessLevel.PROTECTED)
@NoArgsConstructor
@Getter
@Setter
public abstract class AbstractDto {
}
