package be.heh.app.model.repositories.app;

import be.heh.app.model.entities.app.Category;
import be.heh.app.model.entities.app.InnerPage;
import be.heh.app.model.entities.app.Page;
import be.heh.app.model.entities.app.enumeration.EnumState;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageRepository extends AbstractRepository<Page, Integer> {

    /**
     * Return a list of innerPage filtered with enumState. The first element of the list is the last one in the
     * database (desc). A ".get(0)" get you the last element in the database with the filter.
     * @param page contain the list of innerPage
     * @param enumState the state of the innerImage
     * @return a list of innerPage filtered with enumState
     */
    @Query(value = "select i from Page p join p.innerPageList i where p = ?1 and i.enumState = ?2 order by i.id desc")
    List<InnerPage> findInnerPage(@Param("page") Page page, @Param("enumState") EnumState enumState);

    //TODO sort by args, limit
    /**
     * Return a list of all pages belonging to a category.
     * @param category the category
     * @param enumState the state of the page
     * @return a list of pages
     */
    @Query("select p from Page p where p.category = ?1 and p.enumState = ?2")
    List<Page> findAllByCategory(@Param("category") Category category, @Param("enumState") EnumState enumState);

    //TODO sort by args, limit
    /**
     * Return a list of all pages belonging to a category.
     * @param categoryId the id of the category
     * @param enumState the state of the page
     * @return a list of pages
     */
    @Query("select p from Page p where p.category.id = ?1 and p.enumState = ?2")
    List<Page> findAllByCategoryById(@Param("categoryId") int categoryId, @Param("enumState") EnumState enumState);

    //TODO sort by args, limit
    /**
     * Return a list of all pages belonging to a EnumState.
     * @param enumState the state of the page
     * @return a list of pages
     */
    @Query("select p from Page p where p.enumState = 1")
    List<Page> findAllByEnumState(@Param("enumState") EnumState enumState);

}
