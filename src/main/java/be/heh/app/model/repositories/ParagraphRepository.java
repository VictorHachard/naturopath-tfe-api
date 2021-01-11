package be.heh.app.model.repositories;

import be.heh.app.model.entities.app.Paragraph;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParagraphRepository extends AbstractRepository<Paragraph, Integer> {
}
