package be.heh.app.model.repositories.app;

import be.heh.app.model.entities.app.Ticket;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends AbstractRepository<Ticket, Integer>  {

    Optional<List<Ticket>> findAllByUserSecurityId(@Param("userSecurityId") int userSecurityId);

    @Query("select c from Ticket c where c.userSecurity.id = ?1 and c.id = ?2")
    Optional<Ticket> findByUserSecurityId(@Param("userSecurityId") int userSecurityId, @Param("id") int id);

    Boolean existsByUserSecurityId(@Param("userSecurityId") int userSecurityId);

    @Query("select c from Ticket c where c.isClose = false")
    Optional<List<Ticket>> findAllOpen();

    @Query("select case when (count(c) > 0) then true else false end from Ticket c where c.isClose = false")
    Boolean existsAllOpen();



}
