package be.heh.app.model.repositories.security;

import be.heh.app.model.entities.security.CookieRememberMe;
import be.heh.app.model.repositories.commons.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CookieRememberMeRepository extends AbstractRepository<CookieRememberMe, Integer> {

}
