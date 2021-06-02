package be.heh.app.model.repositories.app;

import be.heh.app.model.entities.app.Category;
import be.heh.app.model.entities.app.Like;
import be.heh.app.model.entities.app.Page;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikeRepository extends AbstractRepository<Like, Integer> {

    @Query("select l from Like l where l.page = ?1 and l.user = ?2")
    Optional<Like> findByPageAndUser(@Param("page") Page page, @Param("user") User user);

    Boolean existsByPageAndUser(Page page, User user);

    @Query("select l from Like l where l.page = ?1 and l.actualLike = true")
    List<Like> findAllByPage(@Param("page") Page page);

    Boolean existsByPage(Page page);

}
