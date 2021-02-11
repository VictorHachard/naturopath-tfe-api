package be.heh.app.init;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.utils.Utils;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.omnifaces.cdi.Startup;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
@Startup
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InitService extends AbstractAutowire {

    public static Map<String, AbstractService> serviceMap = new HashMap<>();

    @PostConstruct
    public void init() {
        serviceMap.put("Category", categoryService);
        //serviceMap.put("Image", imageService);
        //serviceMap.put("InnerImage", innerImageService);
        //serviceMap.put("InnerPage", innerPageService);
        //serviceMap.put("InnerParagraph", innerParagraphService);
        //serviceMap.put("InnerParapage", innerParapageService);
        //serviceMap.put("InnerParatag", innerParatagService);
        //serviceMap.put("InnerTag", innerTagService);
        serviceMap.put("Message", messageService);
        serviceMap.put("Page", pageService);
        serviceMap.put("Paragraph", paragraphService);
        serviceMap.put("ParagraphType", paragraphTypeService);
        //serviceMap.put("Parapage", parapageService);
        serviceMap.put("ParapageType", parapageTypeService);
        //serviceMap.put("Paratag", paratagService);
        serviceMap.put("Tag", tagService);
        serviceMap.put("Ticket", ticketService);
        serviceMap.put("TagType", tagTypeService);
        serviceMap.put("User", userService);
        serviceMap.put("Vote", voteService);
    }

    public static <T>T get(Class c) {
        return (T) serviceMap.get(Utils.upperFirstChar(c.getSimpleName().replace("Service", ""))); //TODO
    }

}
