package be.heh.app.model.repositories;

import be.heh.app.model.entities.security.UserSecurity;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSecurityRepository extends AbstractRepository<UserSecurity, Integer> {
}
