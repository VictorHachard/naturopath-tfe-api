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

    @Query(value = "select i from Paratag p join p.innerParatagList i where p = :paratag and i.enumState = :enumState order by i.id desc")
    List<InnerParatag> findLastFiltered(@Param("paratag") Paratag paratag, @Param("enumState") EnumState enumState);

}
