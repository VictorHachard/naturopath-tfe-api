package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/role/")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class RoleController extends AbstractController {
}
