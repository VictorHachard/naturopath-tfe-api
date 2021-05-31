package be.heh.app.model.repositories.app;

import be.heh.app.model.entities.app.Image;
import be.heh.app.model.entities.app.InnerImage;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.app.enumeration.EnumState;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends AbstractRepository<Image, Integer> {

    /**
     * Return a list of innerImage filtered with enumState. The first element of the list is the last one in the
     * database (desc). A ".get(0)" get you the last element in the database with the filter.
     * @param image contain the list of innerImage
     * @param enumState the state of the innerImage
     * @return a list of innerImage filtered with enumState
     */
    @Query(value = "select i from Image p join p.innerImageList i where p = ?1 and i.enumState = ?2 order by i.id desc")
    List<InnerImage> findInnerImage(@Param("image") Image image, @Param("enumState") EnumState enumState);

    @Query(value = "select i from Image i join i.innerImageList inn where i.user = ?1 order by i.id desc")
    List<Image> findImageByUser(@Param("user") User user);

}
