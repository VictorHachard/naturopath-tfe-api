package be.heh.app.model.repositories.security;

import be.heh.app.model.entities.security.UserSecurity;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserSecurityRepository extends AbstractRepository<UserSecurity, Integer> {

    /**
     *
     * @param emailOrUsername
     * @return
     */
    @Query("select u from UserSecurity u where u.username = ?1 or u.email = ?1")
    Optional<UserSecurity> findByEmailOrUsername(@Param("emailOrUsername") String emailOrUsername);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    /**
     *
     * @param confirmToken the token
     * @return the user who has this confirmation token
     */
    Optional<UserSecurity> findByConfirmToken(String confirmToken);

    Boolean existsByConfirmToken(String confirmToken);

    /**
     *
     * @param resetToken the token
     * @return the user who has this reset token
     */
    Optional<UserSecurity> findByResetToken(String resetToken);

    Boolean existsByResetToken(String resetToken);

    /**
     *
     * @param deleteToken the token
     * @return the user who has this delete token
     */
    Optional<UserSecurity> findByDeleteToken(String deleteToken);

    Boolean existsByDeleteToken(String deleteToken);

}
