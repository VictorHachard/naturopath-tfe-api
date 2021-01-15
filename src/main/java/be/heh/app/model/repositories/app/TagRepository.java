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

    @Query(value = "select i from Tag p join p.innerTagList i where p = :tag and i.enumState = :enumState order by i.id desc")
    List<InnerTag> findLastFiltered(@Param("tag") Tag tag, @Param("enumState") EnumState enumState);

}
