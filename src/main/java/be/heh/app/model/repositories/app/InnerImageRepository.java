package be.heh.app.model.repositories.app;

import be.heh.app.model.entities.app.InnerImage;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InnerImageRepository extends AbstractRepository<InnerImage, Integer>  {
}
