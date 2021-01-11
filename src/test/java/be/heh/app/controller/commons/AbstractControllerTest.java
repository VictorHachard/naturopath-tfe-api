package be.heh.app.controller.commons;

import be.heh.app.controller.rest.app.CategoryController;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;

// Lombok
@FieldDefaults(level = AccessLevel.PUBLIC)
@Log
public class AbstractControllerTest {

    @Autowired
    CategoryController categoryController;

}
