package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.InnerParatag;
import be.heh.app.model.entities.app.enumeration.EnumState;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

@Component
public class InnerParatagFacade extends AbstractFacade<InnerParatag> {

    // Init
    public InnerParatag init(String title, String content) {
        InnerParatag innerParatag = new InnerParatag();
        innerParatag.setUser(userRepository.findById(1).get());
        innerParatag.setContent(content);
        innerParatag.setTitle(title);
        innerParatag.setVersion(0);
        innerParatag.setEnumState(EnumState.VALIDATED);
        return innerParatag;
    }

}
