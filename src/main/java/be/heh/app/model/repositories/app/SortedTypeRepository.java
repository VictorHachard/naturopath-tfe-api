package be.heh.app.model.repositories.app;

import be.heh.app.model.entities.app.SortedType;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SortedTypeRepository extends AbstractRepository<SortedType, Integer> {
}
