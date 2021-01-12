package be.heh.app.model.repositories.app;

import be.heh.app.model.entities.app.Paratag;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParatagRepository extends AbstractRepository<Paratag, Integer> {
}
