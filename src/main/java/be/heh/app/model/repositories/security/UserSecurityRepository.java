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
     * @param emailOrUsername
     * @return
     */
    @Query("select u from UserSecurity u where u.username = ?1 or u.email = ?1")
    UserSecurity findUserByEmailOrUsername(@Param("emailOrUsername") String emailOrUsername);

    /**
     *
     * @param confirmToken the token
     * @return the user who has this confirmation token
     */
    @Query("select u from UserSecurity u where u.confirmToken = ?1")
    UserSecurity findUserByConfirmToken(@Param("confirmToken") String confirmToken);

    /**
     *
     * @param resetToken the token
     * @return the user who has this reset token
     */
    @Query("select u from UserSecurity u where u.resetToken = ?1")
    UserSecurity findUserByResetToken(@Param("resetToken") String resetToken);

    /**
     *
     * @param deleteToken the token
     * @return the user who has this delete token
     */
    @Query("select u from UserSecurity u where u.deleteToken = ?1")
    UserSecurity findUserByDeleteToken(@Param("deleteToken") String deleteToken);

}
