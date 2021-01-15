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

    @Query(value = "select i from Parapage p join p.innerParapageList i where p = :parapage and i.enumState = :enumState order by i.id desc")
    List<InnerParapage> findLastFiltered(@Param("parapage") Parapage parapage, @Param("enumState") EnumState enumState);

}
