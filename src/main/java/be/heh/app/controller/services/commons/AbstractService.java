package be.heh.app.controller.services.commons;

import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.init.AbstractAutowire;
import be.heh.app.init.InitRepository;
import be.heh.app.model.repositories.commons.AbstractRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

// Lombok
@FieldDefaults(level = AccessLevel.PROTECTED)
@Log
public abstract class AbstractService<I> extends AbstractAutowire {

    public List<I> getAll() {
        AbstractRepository repository = InitRepository.get(this.getClass());
        if (repository.findAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no " + this.getClass().getSimpleName() + " in the database");
        } else {
            return (List<I>) repository.findAll();
        }
    }

    public I get(int id) {
        AbstractRepository repository = InitRepository.get(this.getClass());
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no " + this.getClass().getSimpleName() + " in the database");
        } else {
            return (I) repository.findById(id).get();
        }
    }

    public void add(AbstractValidator abstractValidator) {

    }

    public void update(AbstractValidator abstractValidator, int id) {
        AbstractRepository repository = InitRepository.get(this.getClass());
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no " + this.getClass().getSimpleName() + " in the database");
        }
    }

    public void delete(int id) {
        AbstractRepository repository = InitRepository.get(this.getClass());
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no " + this.getClass().getSimpleName() + " in the database");
        } else {
            repository.deleteById(id);
        }
    }

}
