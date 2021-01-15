package be.heh.app.mappers.app;

import be.heh.app.mappers.app.commons.AbstractMapper;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class UserMapper extends AbstractMapper {
}
