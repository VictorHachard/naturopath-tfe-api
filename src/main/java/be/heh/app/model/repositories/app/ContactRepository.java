package be.heh.app.model.repositories.app;

import be.heh.app.model.entities.app.Contact;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends AbstractRepository<Contact, Integer> {

    /*@Query("select c from Contact c where c.userSecurity.id = ?1")*/
    Optional<List<Contact>> findAllByUserSecurityId(@Param("userSecurityId") int userSecurityId);

    Boolean existsByUserSecurityId(@Param("userSecurityId") int userSecurityId);

}
