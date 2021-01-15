package be.heh.app.model.repositories.app;

import be.heh.app.model.entities.app.InnerParagraph;
import be.heh.app.model.repositories.commons.MappedInner;
import org.springframework.stereotype.Repository;

@Repository
public interface InnerParagraphRepository extends MappedInner<InnerParagraph, Integer> {
}
