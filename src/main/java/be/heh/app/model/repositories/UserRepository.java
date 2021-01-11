package be.heh.app.model.repositories;

import be.heh.app.model.entities.app.User;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends AbstractRepository<User, Integer> {
}
