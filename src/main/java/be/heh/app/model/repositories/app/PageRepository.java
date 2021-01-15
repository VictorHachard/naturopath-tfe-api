package be.heh.app.model.repositories.app;

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

    @Query(value = "select i from Page p join p.innerPageList i where p = :page and i.enumState = :enumState order by i.id desc")
    List<InnerPage> findLastFiltered(@Param("page") Page page, @Param("enumState") EnumState enumState);

}
