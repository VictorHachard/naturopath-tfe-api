package be.heh.app.model.repositories.app;

import be.heh.app.model.entities.app.InnerParapage;
import be.heh.app.model.repositories.commons.MappedInner;
import org.springframework.stereotype.Repository;

@Repository
public interface InnerParapageRepository extends MappedInner<InnerParapage, Integer> {
}
