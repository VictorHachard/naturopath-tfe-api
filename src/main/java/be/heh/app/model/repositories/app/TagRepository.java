package be.heh.app.model.repositories.app;

import be.heh.app.model.entities.app.Tag;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends AbstractRepository<Tag, Integer> {
}
