package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.*;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

@Component
public class LikeFacade extends AbstractFacade<Like> {

    public Like newInstance(User user, boolean actualLike, Page page) {
        Like res = super.newInstance();
        res.setLiked(true);
        res.setPage(page);
        res.setActualLike(actualLike);
        res.setUser(user);
        return res;
    }

}
