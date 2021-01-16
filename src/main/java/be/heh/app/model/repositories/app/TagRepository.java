package be.heh.app.model.repositories.app;

import be.heh.app.model.entities.app.InnerTag;
import be.heh.app.model.entities.app.Tag;
import be.heh.app.model.entities.app.enumeration.EnumState;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends AbstractRepository<Tag, Integer> {

    /**
     * Return a list of innerTag filtered with enumState. The first element of the list is the last one in the
     * database (desc). A ".get(0)" get you the last element in the database with the filter.
     * @param tag contain the list of innerTag
     * @param enumState the state of the innerImage
     * @return a list of innerTag filtered with enumState
     */
    @Query(value = "select i from Tag p join p.innerTagList i where p = ?1 and i.enumState = ?2 order by i.id desc")
    List<InnerTag> findInnerTag(@Param("tag") Tag tag, @Param("enumState") EnumState enumState);

}
