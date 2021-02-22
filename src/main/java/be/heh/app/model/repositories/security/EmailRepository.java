package be.heh.app.model.repositories.security;

import be.heh.app.model.entities.security.Email;
import be.heh.app.model.entities.security.Role;
import be.heh.app.model.entities.security.enumeration.EnumEmail;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmailRepository extends AbstractRepository<Email, Integer> {

    Optional<Role> findByName(EnumEmail name);

}
