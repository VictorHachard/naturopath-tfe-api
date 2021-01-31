package be.heh.app.model.repositories.security;

import be.heh.app.model.entities.security.Role;
import be.heh.app.model.entities.security.enumeration.EnumRole;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends AbstractRepository<Role, Integer> {

    Optional<Role> findByName(EnumRole name);

}
