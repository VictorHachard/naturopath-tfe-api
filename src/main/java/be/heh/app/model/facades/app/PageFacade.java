package be.heh.app.model.facades.app;

import be.heh.app.model.entities.app.*;
import be.heh.app.model.facades.commons.AbstractFacade;
import org.springframework.stereotype.Component;

@Component
public class PageFacade extends AbstractFacade<Page> {

    public Page newInstance(InnerPage innerPage, User user, Category category) {
        Page page = new Page();
        page.addInnerPage(innerPage);
        page.setUser(user);
        page.setCategory(category);
        return page;
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
