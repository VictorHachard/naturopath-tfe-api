package be.heh.app.model.repositories.app;

import be.heh.app.model.entities.app.ParapageType;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParapageTypeRepository extends AbstractRepository<ParapageType, Integer> {
}
