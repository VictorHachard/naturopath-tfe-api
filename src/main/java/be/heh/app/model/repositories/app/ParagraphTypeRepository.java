package be.heh.app.model.repositories.app;

import be.heh.app.model.entities.app.ParagraphType;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParagraphTypeRepository extends AbstractRepository<ParagraphType, Integer> {
}
