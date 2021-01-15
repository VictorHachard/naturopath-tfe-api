package be.heh.app.init.data;

import be.heh.app.init.AbstractAutowire;
import be.heh.app.model.entities.app.*;
import be.heh.app.model.entities.app.enumeration.EnumState;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.omnifaces.cdi.Startup;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Startup
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Init extends AbstractAutowire {

    static List<User> userList = new ArrayList<>();
    static List<Category> categoryList = new ArrayList<>();

    static List<TagType> tagTypeList = new ArrayList<>();
    static List<ParagraphType> paragraphTypeList = new ArrayList<>();
    static List<ParapageType> parapageTypeList = new ArrayList<>();
    static List<ParatagType> paratagTypeList = new ArrayList<>();

    static List<Paragraph> paragraphList = new ArrayList<>();
    static List<Tag> tagList = new ArrayList<>();
    static List<Parapage> parapageList = new ArrayList<>();
    static List<Paratag> paratagList = new ArrayList<>();
    static List<Image> imageList = new ArrayList<>();
    static List<Page> pageList = new ArrayList<>();


    public void initUser() {
        userList.add(userFacade.newInstance("FR"));
    }

    public void initTagType() {
        tagTypeList.add(tagTypeFacade.newInstance("Nom latin", "")); //0
        tagTypeList.add(tagTypeFacade.newInstance("Famille", "")); //1

        tagTypeList.add(tagTypeFacade.newInstance("Principes actifs", "")); //2
    }

    public void initParatagType() {
        paratagTypeList.add(paratagTypeFacade.newInstance("Principes actifs" , "", tagTypeList.get(2))); //0
    }

    public void initParagraphType() {
        paragraphTypeList.addAll(Arrays.asList(
                paragraphTypeFacade.newInstance("Habitat et culture", ""), //0
                paragraphTypeFacade.newInstance("Espèces voisines", ""), //1
                paragraphTypeFacade.newInstance("Usages traditionnels et courants", ""), //2
                paragraphTypeFacade.newInstance("Recherches en cours", ""), //3
                paragraphTypeFacade.newInstance("Parties utilisées", ""), //4
                paragraphTypeFacade.newInstance("Preparations et usages", ""), //5
                paragraphTypeFacade.newInstance("Toxicité et contre-indication", ""), //6
                paragraphTypeFacade.newInstance("Synonymes", ""), //7
                paragraphTypeFacade.newInstance("Risques de confusions", ""))); //8
    }

    public void initCategory() {
        categoryList.addAll(Arrays.asList(
                categoryFacade.newInstance("Tisanes", "") //0
                ));
        categoryList.addAll(Arrays.asList(
                categoryFacade.newInstance("Plantes", ""), //1
                categoryFacade.newInstance("Huiles Essentielles", ""), //2
                categoryFacade.newInstance("Infusions", "", categoryList.get(0)), //3
                categoryFacade.newInstance("Décoctions", "", categoryList.get(0)), //4
                categoryFacade.newInstance("Macérations", "", categoryList.get(0)), //5
                categoryFacade.newInstance("Sirops", ""), //6
                categoryFacade.newInstance("Cataplasmes", ""), //7
                categoryFacade.newInstance("Onguents", ""), //8
                categoryFacade.newInstance("Teintures Mères", ""), //9
                categoryFacade.newInstance("Vins Médicinaux", ""), //10
                categoryFacade.newInstance("Comprimés", ""), //11
                categoryFacade.newInstance("Fumigations", ""), //12
                categoryFacade.newInstance("Huiles Végétales", ""), //13
                categoryFacade.newInstance("Plantes Fraîches", ""), //14
                categoryFacade.newInstance("Élixirs", ""), //15
                categoryFacade.newInstance("Macérats Huileux", ""), //16
                categoryFacade.newInstance("Poudres", ""), //17
                categoryFacade.newInstance("Gélules", ""), //18
                categoryFacade.newInstance("Bains de Plantes", ""), //19
                categoryFacade.newInstance("Bains de Bouche ou Gargarismes", ""), //20
                categoryFacade.newInstance("Bains d’Yeux", ""), //21
                categoryFacade.newInstance("Collyres", ""), //22
                categoryFacade.newInstance("Beaumes", ""), //23
                categoryFacade.newInstance("Gels", ""), //24
                categoryFacade.newInstance("Pommades", ""), //25
                categoryFacade.newInstance("Hydrolats", ""), //26
                categoryFacade.newInstance("Macérats de Bourgeons", ""), //27
                categoryFacade.newInstance("Élixirs Floraux ou Fleurs de Bach", ""))); //28

        // Plantes - 0

        categoryList.get(0).addParagraphType(
                paragraphTypeList.get(0),
                paragraphTypeList.get(1),
                paragraphTypeList.get(2),
                paragraphTypeList.get(3),
                paragraphTypeList.get(4),
                paragraphTypeList.get(5),
                paragraphTypeList.get(6),
                paragraphTypeList.get(7),
                paragraphTypeList.get(8));

        categoryList.get(0).addParatagType(
                paratagTypeList.get(0));

        categoryList.get(0).addTagType(
                tagTypeList.get(0),
                tagTypeList.get(1));

        // Huiles Essentielles - 1

    }

    public void initPage() {
        Vote vote = voteFacade.newInstance(0, userList.get(0));
        InnerPage i = innerPageFacade.newInstance("Lavande", "", userList.get(0));
        i.setEnumState(EnumState.VALIDATED);
        i.addVote(vote);


        Vote vote2 = voteFacade.newInstance(0, userList.get(0));
        InnerPage i2 = innerPageFacade.newInstance("Lavande 2", "", userList.get(0));
        i2.setEnumState(EnumState.VALIDATED);
        i2.addVote(vote2);

        Vote vote3 = voteFacade.newInstance(0, userList.get(0));
        InnerPage i3 = innerPageFacade.newInstance("Lavande 3", "", userList.get(0));
        i3.setEnumState(EnumState.DRAFT);
        i3.addVote(vote3);

        Page page = pageFacade.newInstance(i, userList.get(0),
                categoryList.get(0));

        page.addInnerPage(i2, i3);

        pageList.add(page
                ); //0
        pageList.get(0).addTag();
    }

    public void initTag() {
        tagList.add(tagFacade.newInstance(innerTagFacade.newInstance("Phénols", "", userList.get(0)), tagTypeList.get(2), userList.get(0))); //0
        tagList.add(tagFacade.newInstance(innerTagFacade.newInstance("Astéracées", "", userList.get(0)), tagTypeList.get(1), userList.get(0))); //1
    }

    public void initParagraph() {

    }

    @PostConstruct
    public void init() {
        initUser();
        initParagraphType();
        initTagType();
        initParatagType();
        initCategory();
        initPage();
        userList.forEach(user -> {
            userRepository.save(user);
        });
        paragraphTypeList.forEach(user -> {
            paragraphTypeRepository.save(user);
        });
        tagTypeList.forEach(user -> {
            tagTypeRepository.save(user);
        });
        paratagTypeList.forEach(paratagType -> {
            paratagTypeRepository.save(paratagType);
        });
        categoryList.forEach(user -> {
            categoryRepository.save(user);
        });
        paragraphList.forEach(i -> {
            i.getInnerParagraphList().forEach(j -> {
                innerParagraphRepository.save(j);
            });
            paragraphRepository.save(i);
        });
        tagList.forEach(i -> {
            i.getInnerTagList().forEach(j -> {
                innerTagRepository.save(j);
            });
            tagRepository.save(i);
        });
        parapageList.forEach(i -> {
            i.getInnerParapageList().forEach(j -> {
                innerParapageRepository.save(j);
            });
            parapageRepository.save(i);
        });
        paratagList.forEach(i -> {
            i.getInnerParatagList().forEach(j -> {
                innerParatagRepository.save(j);
            });
            paratagRepository.save(i);
        });
        imageList.forEach(i -> {
            i.getInnerImageList().forEach(j -> {
                innerImageRepository.save(j);
            });
            imageRepository.save(i);
        });
        pageList.forEach(i -> {
            i.getInnerPageList().forEach(j -> {
                j.getVoteList().forEach(k -> {
                    voteRepository.save(k);
                });
                innerPageRepository.save(j);
            });
            pageRepository.save(i);
        });
    }

}
