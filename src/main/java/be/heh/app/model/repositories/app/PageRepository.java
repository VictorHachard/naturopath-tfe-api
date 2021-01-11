package be.heh.app.model.repositories.app;

import be.heh.app.model.entities.app.Page;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepository extends AbstractRepository<Page, Integer> {
}
