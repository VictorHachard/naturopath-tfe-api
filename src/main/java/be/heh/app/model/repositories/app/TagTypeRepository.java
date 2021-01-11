package be.heh.app.model.repositories.app;

import be.heh.app.model.entities.app.TagType;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagTypeRepository extends AbstractRepository<TagType, Integer> {
}
