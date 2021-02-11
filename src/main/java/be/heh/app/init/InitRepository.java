package be.heh.app.init;

import be.heh.app.model.repositories.commons.AbstractRepository;
import be.heh.app.utils.Utils;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.omnifaces.cdi.Startup;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Startup
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class InitRepository extends AbstractAutowire {

    public static Map<String, AbstractRepository> repositoryMap = new HashMap<>();

    @PostConstruct
    public void init() {
        repositoryMap.put("Category", categoryRepository);
        repositoryMap.put("Image", imageRepository);
        repositoryMap.put("InnerImage", innerImageRepository);
        repositoryMap.put("InnerPage", innerPageRepository);
        repositoryMap.put("InnerParagraph", innerParagraphRepository);
        repositoryMap.put("InnerParapage", innerParapageRepository);
        repositoryMap.put("InnerParatag", innerParatagRepository);
        repositoryMap.put("InnerTag", innerTagRepository);
        repositoryMap.put("Message", messageRepository);
        repositoryMap.put("Page", pageRepository);
        repositoryMap.put("Paragraph", paragraphRepository);
        repositoryMap.put("ParagraphType", paragraphTypeRepository);
        repositoryMap.put("Parapage", parapageRepository);
        repositoryMap.put("ParapageType", parapageTypeRepository);
        repositoryMap.put("Paratag", paratagRepository);
        repositoryMap.put("Tag", tagRepository);
        repositoryMap.put("TagType", tagTypeRepository);
        repositoryMap.put("User", userRepository);
        repositoryMap.put("SortedType", sortedTypeRepository);
        repositoryMap.put("ParatagType", paratagTypeRepository);
        repositoryMap.put("Ticket", ticketRepository);
        repositoryMap.put("TicketContent", ticketContentRepository);
        repositoryMap.put("Vote", voteRepository);

        try {
            List<Class> allClasses = Utils.getClasses("be.heh.app.model.repositories.app");
            for (Class clazz : allClasses) {
                if (!repositoryMap.containsKey(clazz.getSimpleName().replace("Repository", ""))) {
                    log.warning(clazz.getSimpleName() + " is missing in the repositoryMap");
                }
            }
        } catch (Exception ignored) { }
    }

    public static <T>T get(Class c) {
        return (T) repositoryMap.get(c.getSimpleName().replace("Service", ""));
    }

}
