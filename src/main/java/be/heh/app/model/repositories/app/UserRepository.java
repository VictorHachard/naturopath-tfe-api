package be.heh.app.model.repositories.app;

import be.heh.app.model.entities.app.User;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends AbstractRepository<User, Integer> {

    Optional<User> findByUsername(String username);

}
