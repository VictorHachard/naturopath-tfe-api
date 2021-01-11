package be.heh.app.model.repositories.app;

import be.heh.app.model.entities.app.InnerTag;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InnerTagRepository extends AbstractRepository<InnerTag, Integer> {
}
