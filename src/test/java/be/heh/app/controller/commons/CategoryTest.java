package be.heh.app.controller.commons;

import be.heh.app.controller.rest.app.CategoryController;
import be.heh.app.controller.services.app.CategoryService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

//@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@WebMvcTest(CategoryController.class)
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryTest {

    @Autowired
    MockMvc mvc;

}
