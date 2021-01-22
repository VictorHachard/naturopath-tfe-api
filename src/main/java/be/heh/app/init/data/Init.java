package be.heh.app.init.data;

import be.heh.app.init.AbstractAutowire;
import be.heh.app.model.entities.app.*;
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
        userList.add(userFacade.init("Paulin"));
    }

    public void initTagType() {
        tagTypeList.add(tagTypeFacade.newInstance("Nom latin", "")); //0
        tagTypeList.add(tagTypeFacade.newInstance("Famille", "")); //1

        tagTypeList.add(tagTypeFacade.newInstance("Principes actifs", "")); //2
    }

    public void initParatagType() {
        paratagTypeList.add(paratagTypeFacade.newInstance("Principes actifs" , "", tagTypeList.get(2))); //0
    }

    public void initParapageType() {
        parapageTypeList.add(parapageTypeFacade.newInstance("" , "")); //0
    }

    public void initParagraphType() {
        paragraphTypeList.addAll(Arrays.asList(
                paragraphTypeFacade.newInstance("Habitat et culture", ""), //0
                paragraphTypeFacade.newInstance("Espèces voisines", ""), //1
                paragraphTypeFacade.newInstance("Usages traditionnels et courants", ""), //2
                paragraphTypeFacade.newInstance("Recherches en cours", ""), //3
                paragraphTypeFacade.newInstance("Parties utilisées", ""), //4
                paragraphTypeFacade.newInstance("Préparations et usages", ""), //5
                paragraphTypeFacade.newInstance("Toxicité et contre-indication", ""), //6
                paragraphTypeFacade.newInstance("Risques de confusions", ""))); //7
    }

    public void initCategory() {
        categoryList.addAll(Arrays.asList(
                categoryFacade.init("Tisanes", "") //0
                ));
        categoryList.addAll(Arrays.asList(
                categoryFacade.init("Plantes", ""), //1
                categoryFacade.init("Huiles Essentielles", ""), //2
                categoryFacade.init("Infusions", "", categoryList.get(0)), //3
                categoryFacade.init("Décoctions", "", categoryList.get(0)), //4
                categoryFacade.init("Macérations", "", categoryList.get(0)), //5
                categoryFacade.init("Sirops", ""), //6
                categoryFacade.init("Cataplasmes", ""), //7
                categoryFacade.init("Onguents", ""), //8
                categoryFacade.init("Teintures Mères", ""), //9
                categoryFacade.init("Vins Médicinaux", ""), //10
                categoryFacade.init("Comprimés", ""), //11
                categoryFacade.init("Fumigations", ""), //12
                categoryFacade.init("Huiles Végétales", ""), //13
                categoryFacade.init("Plantes Fraîches", ""), //14
                categoryFacade.init("Élixirs", ""), //15
                categoryFacade.init("Macérats Huileux", ""), //16
                categoryFacade.init("Poudres", ""), //17
                categoryFacade.init("Gélules", ""), //18
                categoryFacade.init("Bains de Plantes", ""), //19
                categoryFacade.init("init de Bouche ou Gargarismes", ""), //20
                categoryFacade.init("Bains d’Yeux", ""), //21
                categoryFacade.init("Collyres", ""), //22
                categoryFacade.init("Beaumes", ""), //23
                categoryFacade.init("Gels", ""), //24
                categoryFacade.init("Pommades", ""), //25
                categoryFacade.init("Hydrolats", ""), //26
                categoryFacade.init("Macérats de Bourgeons", ""), //27
                categoryFacade.init("Élixirs Floraux ou Fleurs de Bach", ""))); //28

        // Plantes - 0

        categoryList.get(0).addParagraphType(
                paragraphTypeList.get(0),
                paragraphTypeList.get(1),
                paragraphTypeList.get(2),
                paragraphTypeList.get(3),
                paragraphTypeList.get(4),
                paragraphTypeList.get(5),
                paragraphTypeList.get(6),
                paragraphTypeList.get(7));

        categoryList.get(0).addParatagType(
                paratagTypeList.get(0));

        categoryList.get(0).addTagType(
                tagTypeList.get(0),
                tagTypeList.get(1));

        // Huiles Essentielles - 1

    }

    public void initTag() {
        tagList.add(tagFacade.newInstance(innerTagFacade.init("Acides-phénols", "acide rosmarinique, dérivés de l’acide caféique"), tagTypeList.get(2), userList.get(0))); //0
        tagList.add(tagFacade.newInstance(innerTagFacade.init("Huile essentielle", "alcools (menthol), cétones (menthone, pulégone), esters, oxydes, monoterpènes, sesquiterpènes"), tagTypeList.get(2), userList.get(0))); //1
        tagList.add(tagFacade.newInstance(innerTagFacade.init("Triterpènes", ""), tagTypeList.get(2), userList.get(0))); //2
        tagList.add(tagFacade.newInstance(innerTagFacade.init("Cires", ""), tagTypeList.get(2), userList.get(0))); //3
        tagList.add(tagFacade.newInstance(innerTagFacade.init("Flavonoïdes ", ""), tagTypeList.get(2), userList.get(0))); //4

        tagList.add(tagFacade.newInstance(innerTagFacade.init("Lamiacées", ""), tagTypeList.get(1), userList.get(0))); //5

        tagList.add(tagFacade.newInstance(innerTagFacade.init("Mentha x piperita L", ""), tagTypeList.get(0), userList.get(0))); //6
    }

    public void initParatag() {
        InnerParatag i = innerParatagFacade.init("tr", "");
        i.addTag(tagList.get(0), tagList.get(1),tagList.get(2),tagList.get(3), tagList.get(4));
        paratagList.add(paratagFacade.newInstance(i, paratagTypeList.get(0), userList.get(0)));
    }

    public void initParagraph() {
        paragraphList.add(paragraphFacade.newInstance(innerParagraphFacade.init("Super para", "C’est une plante herbacée aromatique, vivace, à stolons traçants, pouvant atteindre 0,60 cm a 1m de hauteur. C’est un hybride entre la menthe aquatique (Mentha aquatica) et la menthe verte (Mentha spicata). La Menthe est originaire d’Angleterre.  Généralement cultivée, on la trouve maintenant en Europe en Asie et en Amérique du Nord. La menthe poivrée se plaire sur une terre aérée et pas trop humide, dans un endroit a moitié ombragé. Nous pouvons récolter la plante en été, avant la floraison. Il est possible de rabattre la plante en été afin de la forcer à produire une autre mise à fleur."), paragraphTypeList.get(0), userList.get(0))); //0
        paragraphList.add(paragraphFacade.newInstance(innerParagraphFacade.init("Super para", "La menthe aquatique (Mentha aquatica) et la menthe verte (Mentha spicata) ont des vertus médicinales plus ou moins identiques bien que moins prononcées."), paragraphTypeList.get(1), userList.get(0))); //1
        paragraphList.add(paragraphFacade.newInstance(innerParagraphFacade.init("Super para", "att"), paragraphTypeList.get(2), userList.get(0))); //2
        paragraphList.add(paragraphFacade.newInstance(innerParagraphFacade.init("Super para", "L’huile essentielle est très antibactérienne. Le menthol est l’un de ces principaux constituants. Il est antiseptique, fongicide, et anesthésiante pour la peau. Elle peut être sur certaines personnes irritante.\n" +
                "Lorsque la menthe poivrée est entière, elle a un effet antispasmodique sur l’appareil digestif. Des etudes ont prouvés son efficacité pour lutter contre les inflammations du colon."), paragraphTypeList.get(3), userList.get(0))); //3
        paragraphList.add(paragraphFacade.newInstance(innerParagraphFacade.init("Super para", "La partie aérienne, idéalement les feuilles."), paragraphTypeList.get(4), userList.get(0))); //4
        paragraphList.add(paragraphFacade.newInstance(innerParagraphFacade.init("Super para", "L’infusion, boire 150ml après chaque repas pour une meilleure digestion.\n" +
                "Remarque :\n" +
                "En infusion courte (2-3 minutes) la plante aura des vertus stimulantes et excitantes.\n" +
                "En infusion longue (5-10 minutes) la plante aura des vertus calmantes et sédatives\n" +
                "La lotion, faite à partir de l’infusion s’utilisera sur les peaux irritées.\n" +
                "L’Huile essentielle, la diluer et se masser les tempes avec, en cas de maux de têtes."), paragraphTypeList.get(5), userList.get(0))); //4
        paragraphList.add(paragraphFacade.newInstance(innerParagraphFacade.init("Super para", "Ne pas utiliser la menthe poivrée chez les enfants de moins de 7 ans.\n" +
                "Ne pas utiliser l’huile essentielle de menthe poivrée chez les enfants de moins de 12 ans.\n" +
                "Elle ne possède pas vraiment de toxicité chez les plus âgés, mais il reste conseillé de l’utiliser en doses modérées, car à haute dose, elle peut mener a des états d’agitation nocturne et/ou a des phases de cauchemars.\n" +
                "De plus, la plante ne doit pas être utilisée simultanément avec des plantes contenant du camphre ou du thymol ni lors d’un traitement a base de résine végétales."), paragraphTypeList.get(6), userList.get(0))); //4
        paragraphList.add(paragraphFacade.newInstance(innerParagraphFacade.init("Super para", "Aucune."), paragraphTypeList.get(7), userList.get(0))); //4
    }

    public void initPage() {
        Vote vote = voteFacade.newInstance(0, userList.get(0));
        InnerPage i = innerPageFacade.init("Menthe poivrée", "");
        i.addVote(vote);

        Page page = pageFacade.newInstance(i, userList.get(0),
                categoryList.get(1));

        page.addTag(tagList.get(6), tagList.get(5));

        page.addParagraph(paragraphList.get(0), paragraphList.get(1), paragraphList.get(2), paragraphList.get(3), paragraphList.get(4), paragraphList.get(5), paragraphList.get(6), paragraphList.get(7));

        page.addParatag(paratagList.get(0));

        pageList.add(page
        ); //0
    }

    @PostConstruct
    public void init() {
        initUser();
        userList.forEach(user -> {
            userRepository.save(user);
        });

        initParagraphType();
        initTagType();
        initParapageType();
        initParatagType();

        initCategory();

        initTag();
        initParatag();
        initParagraph();

        initPage();

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
