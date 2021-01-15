package be.heh.app.model.repositories.app;

import be.heh.app.model.entities.app.Image;
import be.heh.app.model.entities.app.InnerImage;
import be.heh.app.model.entities.app.InnerParatag;
import be.heh.app.model.entities.app.Paratag;
import be.heh.app.model.entities.app.enumeration.EnumState;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends AbstractRepository<Image, Integer> {

    @Query(value = "select i from Image p join p.innerImageList i where p = :image and i.enumState = :enumState order by i.id desc")
    List<InnerImage> findLastFiltered(@Param("image") Image image, @Param("enumState") EnumState enumState);

}
