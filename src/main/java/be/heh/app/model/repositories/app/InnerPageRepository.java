package be.heh.app.model.repositories.app;

import be.heh.app.model.entities.app.InnerPage;
import be.heh.app.model.repositories.commons.MappedInner;
import org.springframework.stereotype.Repository;

@Repository
public interface InnerPageRepository extends MappedInner<InnerPage, Integer> {
}
