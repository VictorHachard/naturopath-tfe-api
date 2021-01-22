package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.*;
import be.heh.app.model.entities.app.enumeration.EnumState;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

@Component
public class PageFacade extends AbstractFacade<Page> {

    public Page newInstance(InnerPage innerPage, User user, Category category) {
        Page res = super.newInstance();
        res.setEnumState(EnumState.DRAFT);
        res.addInnerPage(innerPage);
        res.setUser(user);
        res.setCategory(category);
        return res;
    }

    // Init
    public Page init(InnerPage innerPage, Category category) {
        Page res = super.newInstance();
        res.setEnumState(EnumState.VALIDATED);
        res.addInnerPage(innerPage);
        res.setUser(userRepository.findById(1).get());
        res.setCategory(category);
        return res;
    }

    public boolean verifyTypeParagraph(Page page, ParagraphType type) {
        for (Paragraph paragraph: page.getParagraphList()) {
            if (paragraph.getParagraphType().getName().equals(type.getName())) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyTypeTag(Page page, TagType type) {
        for (Tag tag: page.getTagList()) {
            if (tag.getTagType().getName().equals(type.getName())) {
                return false;
            }
        }
        return true;
    }

}
