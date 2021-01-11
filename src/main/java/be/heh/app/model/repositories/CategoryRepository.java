package be.heh.app.model.repositories;

import be.heh.app.model.entities.app.Category;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends AbstractRepository<Category, Integer> {
}
