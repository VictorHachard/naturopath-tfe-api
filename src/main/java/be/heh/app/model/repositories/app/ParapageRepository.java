package be.heh.app.model.repositories.app;

import be.heh.app.model.entities.app.InnerParapage;
import be.heh.app.model.entities.app.Parapage;
import be.heh.app.model.entities.app.enumeration.EnumState;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParapageRepository extends AbstractRepository<Parapage, Integer> {

    /**
     * Return a list of innerParapage filtered with enumState. The first element of the list is the last one in the
     * database (desc). A ".get(0)" get you the last element in the database with the filter.
     * @param parapage contain the list of innerParapage
     * @param enumState the state of the innerImage
     * @return a list of innerParapage filtered with enumState
     */
    @Query(value = "select i from Parapage p join p.innerParapageList i where p = ?1 and i.enumState = ?2 order by i.id desc")
    List<InnerParapage> findInnerParapage(@Param("parapage") Parapage parapage, @Param("enumState") EnumState enumState);

}
