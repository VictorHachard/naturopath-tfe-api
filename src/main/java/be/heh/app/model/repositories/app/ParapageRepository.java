package be.heh.app.model.repositories.app;

import be.heh.app.model.entities.app.Parapage;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParapageRepository extends AbstractRepository<Parapage, Integer> {
}
