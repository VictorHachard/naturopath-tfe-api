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

    /**
     * Return a list of innerParagraph filtered with enumState. The first element of the list is the last one in the
     * database (desc). A ".get(0)" get you the last element in the database with the filter.
     * @param paragraph contain the list of innerParagraph
     * @param enumState the state of the innerImage
     * @return a list of innerParagraph filtered with enumState
     */
    @Query(value = "select i from Paragraph p join p.innerParagraphList i where p = ?1 and i.enumState = ?2 order by i.id desc")
    List<InnerParagraph> findInnerParagraph(@Param("paragraph") Paragraph paragraph, @Param("enumState") EnumState enumState);

}
