package be.heh.app.model.repositories.security;

import be.heh.app.model.entities.security.UserSecurity;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSecurityRepository extends AbstractRepository<UserSecurity, Integer> {

    /**
     *
     * @param username
     * @param email
     * @return
     */
    @Query("select u from UserSecurity u where u.username = ?1 or u.email = ?2")
    UserSecurity findUserByEmailOrUsername(@Param("username") String username, @Param("email") String email);

}
