package be.heh.app.model.repositories.app;

import be.heh.app.model.entities.app.InnerParatag;
import be.heh.app.model.entities.app.Paratag;
import be.heh.app.model.entities.app.enumeration.EnumState;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParatagRepository extends AbstractRepository<Paratag, Integer> {

    /**
     * Return a list of innerParatag filtered with enumState. The first element of the list is the last one in the
     * database (desc). A ".get(0)" get you the last element in the database with the filter.
     * @param paratag contain the list of innerParatag
     * @param enumState the state of the innerImage
     * @return a list of innerParatag filtered with enumState
     */
    @Query(value = "select i from Paratag p join p.innerParatagList i where p = ?1 and i.enumState = ?2 order by i.id desc")
    List<InnerParatag> findInnerParatag(@Param("paratag") Paratag paratag, @Param("enumState") EnumState enumState);

}
