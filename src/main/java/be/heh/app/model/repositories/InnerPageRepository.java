package be.heh.app.model.repositories;

import be.heh.app.model.entities.app.InnerPage;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InnerPageRepository extends AbstractRepository<InnerPage, Integer> {
}
