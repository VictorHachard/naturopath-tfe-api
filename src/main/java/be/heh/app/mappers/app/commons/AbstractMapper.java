package be.heh.app.mappers.app.commons;

import be.heh.app.init.AbstractAutowire;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;

// Lombok
@FieldDefaults(level = AccessLevel.PROTECTED)
@Log
public abstract class AbstractMapper extends AbstractAutowire {

}
