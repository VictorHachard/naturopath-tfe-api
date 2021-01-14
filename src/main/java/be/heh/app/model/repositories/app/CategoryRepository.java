package be.heh.app.model.repositories.app;

import be.heh.app.model.entities.app.Category;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends AbstractRepository<Category, Integer> {

    List<Category> findAllChild(Category category);

    List<Category> findAllParent();

}
