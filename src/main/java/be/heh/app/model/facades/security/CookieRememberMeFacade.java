package be.heh.app.model.facades.security;

import be.heh.app.model.entities.security.CookieRememberMe;
import be.heh.app.model.facades.commons.AbstractFacade;
import be.heh.app.utils.Utils;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Component
//Lombok
@Log
public class CookieRememberMeFacade extends AbstractFacade<CookieRememberMe> {

    public CookieRememberMe newInstance() {
        CookieRememberMe res = new CookieRememberMe();
        res.setToken(Utils.generateNewToken(42));//TODO unique
        return res;
    }

}
