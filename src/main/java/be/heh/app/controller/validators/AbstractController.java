package be.heh.app.controller.validators;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public abstract class AbstractController {

    public void getAll(JpaRepository repository, String string) {

        if (repository.findAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no " + string.replace("Controller", "") + " in the database");
        }
    }
}
