package be.heh.app.controller.rest.commons;

import be.heh.app.init.AbstractAutowire;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;

// Lombok
@FieldDefaults(level = AccessLevel.PROTECTED)
@Log
public abstract class AbstractController extends AbstractAutowire {
}
