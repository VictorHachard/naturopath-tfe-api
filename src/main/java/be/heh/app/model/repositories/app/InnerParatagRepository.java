package be.heh.app.model.repositories.app;

import be.heh.app.model.entities.app.InnerParatag;
import be.heh.app.model.repositories.commons.MappedInner;
import org.springframework.stereotype.Repository;

@Repository
public interface InnerParatagRepository extends MappedInner<InnerParatag, Integer> {
}
