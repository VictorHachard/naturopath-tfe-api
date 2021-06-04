package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.Category;
import be.heh.app.model.entities.app.InnerParatag;
import be.heh.app.model.entities.app.SortedType;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.app.enumeration.EnumState;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InnerParatagFacade extends AbstractFacade<InnerParatag> {

    public InnerParatag newInstance(User user) {
        InnerParatag res = super.newInstance();
        res.setUser(user);
        res.setVersion(0);
        res.setEnumState(EnumState.DRAFT);
        return res;
    }

    public InnerParatag newInstance(String title, String content, int version, User user) {
        InnerParatag res = super.newInstance();
        res.setUser(user);
        res.setContent(content);
        res.setTitle(title);
        res.setVersion(version);
        res.setEnumState(EnumState.DRAFT);
        return res;
    }

    // Init
    public InnerParatag init(String title, String content) {
        InnerParatag res = super.newInstance();
        res.setUser(userRepository.findById(this.userId).get());
        res.setContent(content);
        res.setTitle(title);
        res.setVersion(0);
        res.setEnumState(EnumState.VALIDATED);
        return res;
    }

}
