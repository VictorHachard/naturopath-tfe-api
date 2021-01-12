package be.heh.app.model.repositories.app;

import be.heh.app.model.entities.app.Image;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends AbstractRepository<Image, Integer>  {
}
