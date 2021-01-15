package be.heh.app.model.repositories.app;

import be.heh.app.model.entities.app.InnerParagraph;
import be.heh.app.model.entities.app.Paragraph;
import be.heh.app.model.entities.app.enumeration.EnumState;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParagraphRepository extends AbstractRepository<Paragraph, Integer> {

    @Query(value = "select i from Paragraph p join p.innerParagraphList i where p = :paragraph and i.enumState = :enumState order by i.id desc")
    List<InnerParagraph> findLastFiltered(@Param("paragraph") Paragraph paragraph, @Param("enumState") EnumState enumState);

}
