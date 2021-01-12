package be.heh.app.controller.rest.commons;

import be.heh.app.controller.services.app.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

// Lombok
@FieldDefaults(level = AccessLevel.PUBLIC)
public abstract class AbstractController {

    @Autowired
    TagTypeService tagTypeService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    MessageService messageService;

    @Autowired
    PageService pageService;

    @Autowired
    ParagraphService paragraphService;

    @Autowired
    ParagraphTypeService paragraphTypeService;

    @Autowired
    TagService tagService;

    @Autowired
    VoteService voteService;

    @Autowired
    UserService userService;

    @Autowired
    ParatagTypeService paratagTypeService;

    @Autowired
    ParapageTypeService parapageTypeService;

}
