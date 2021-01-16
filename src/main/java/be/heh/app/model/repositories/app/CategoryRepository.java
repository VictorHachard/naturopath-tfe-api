package be.heh.app.model.repositories.app;

import be.heh.app.model.entities.app.Category;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends AbstractRepository<Category, Integer> {

    /**
     * Return a list of categories containing all the children of the category given in parameter.
     * @param category the parent category
     * @return a list of categories containing all the children
     */
    @Query("select c from Category c where c.parentCategory = ?1")
    List<Category> findChild(@Param("category") Category category);

    /**
     * Return a list containing all the parents.
     * @return a list containing all the parents
     */
    @Query("select c from Category c where c.parentCategory = null")
    List<Category> findAllParent();

}
