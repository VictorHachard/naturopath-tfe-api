package be.heh.app.model.repositories.app;

import be.heh.app.model.entities.app.*;
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
     * @param tag the tag
     * @param enumState the state of the innerImage
     * @return a list of innerTag filtered with enumState
     */
    @Query("select i from Tag p join p.innerTagList i where p = ?1 and i.enumState = ?2 order by i.id desc")
    List<InnerTag> findInnerTag(@Param("tag") Tag tag, @Param("enumState") EnumState enumState);

    /**
     * Return a list of innerTag filtered with enumState. The first element of the list is the last one in the
     * database (desc). A ".get(0)" get you the last element in the database with the filter.
     * @param tagId the id of the tag
     * @param enumState the state of the innerImage
     * @return a list of innerTag filtered with enumState
     */
    @Query("select i from Tag p join p.innerTagList i where p.id = ?1 and i.enumState = ?2 order by i.id desc")
    List<InnerTag> findInnerTagById(@Param("tag") int tagId, @Param("enumState") EnumState enumState);

    /**
     * Return a list of all tags belonging to a tagType.
     * @param tagType the tagType
     * @param enumState the state of the tag
     * @return a list of tag
     */
    @Query("select t from Tag t join t.innerTagList i where t.tagType = ?1 and i.enumState = ?2")
    List<Tag> findAllByTagType(@Param("tagType") TagType tagType, @Param("enumState") EnumState enumState);

    /**
     * Return a list of all tags belonging to a tagType.
     * @param tagTypeId the tagType
     * @param enumState the state of the tag
     * @return a list of tag
     */
    @Query("select t from Tag t join t.innerTagList i where t.tagType.id = ?1 and i.enumState = ?2")
    List<Tag> findAllTagByTagTypeId(@Param("tagType") int tagTypeId, @Param("enumState") EnumState enumState);

    @Query(value = "select i from Tag i join i.innerTagList inn where i.user = ?1 order by i.id desc")
    List<Tag> findTagByUser(@Param("user") User user);

}
