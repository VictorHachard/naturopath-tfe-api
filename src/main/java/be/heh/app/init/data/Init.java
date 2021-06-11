package be.heh.app.init.data;

import be.heh.app.init.AbstractSecurityAutowire;
import be.heh.app.model.entities.app.*;
import be.heh.app.model.entities.app.enumeration.EnumSize;
import be.heh.app.model.entities.security.UserSecurity;
import be.heh.app.model.entities.security.enumeration.EnumRole;
import be.heh.app.utils.Utils;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
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
public class Init extends AbstractSecurityAutowire {

    Lorem lorem = LoremIpsum.getInstance();

    static List<User> userList = new ArrayList<>();
    static List<UserSecurity> userSecurityList = new ArrayList<>();
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

    List<String> namePlanteList = List.of("Menthe Poivrée", "Melisse", "Rose", "Sauge", "Verveine Citronnée", "Houblon", "Etoile de Badiane", "Estragon", "Hysope", "Lierre Terrestre", "Lavande", "Sauge", "Sapin", "Laurier", "Citron", "Violette", "Gingembre");
    List<String> nameHuileList = List.of("Lavande", "Citron", "Sauge", "Tea Tree", "Menthe Poivrée", "Pamplemousse", "Eucalyptus", "Ravintsara", "Géranium Bourbon", "Thym", "Basilic", "Ylang-ylang", "Rose", "Cèdre", "Palmarosa", "Cannelle");
    List<String> imageHelp = List.of("i", "d", "m", "s", "c", "o", "tm" , "vm", "co", "f", "hv", "pf", "e", "mh", "po", "g", "bdp", "bdb", "bo", "col", "b", "ge", "pom", "hy", "mdb", "ef"); //p et h
    List<List<String>> nameAllList = List.of(
            List.of("Thym", "Menthe", "Laurier", "Sauge", "Gingembre"), // Infusions
            List.of("Laurier"), // Décoctions
            List.of("Sapin"), // Macérations
            List.of("Sureau", "Melisse"), // Sirop
            List.of("Rose Trémière"), //Cataplasmes
            List.of("Aux Herbes", "Consoude", "Violette"), // Onguents
            List.of("Ginkgo Biloba", "Calendula", "Nénupha", "Romarin", "Thym" ), // Teintures Mères
            List.of("Hypocras", "Romarin et Citron"), // Vins Médicinaux
            List.of("Citron"), // Comprimés
            List.of("Rose Pâle", "Sauge", "Sapin"), // Fumigations
            List.of("Olive", "Noisette", "Millepertuis", "Noix de Coco", "Blé", "Avocat", "Amande"), // Huiles Végétales
            List.of("Echinacéa angustifolia", "Passiflore "), // Plantes Fraîches
            List.of("Citron, Gingembre et Miel", "Aloe Vera"), // Élixirs
            List.of("Pâquerette", "Pissenlit"), // Macérats Huileux
            List.of("Menthe", "Piment"), // Poudres
            List.of("Kudzu"), // Gélules
            List.of("Sarinette", "Assam"), // Bains de Plantes
            List.of("Noix de Coco", "Peppermint"), // Bains de Bouche ou Gargarismes
            List.of("Menthe Poivrée", "Lavande"), // Bains Oculaire
            List.of("Pissenlit"), //  Collyres
            List.of("Plantain", "Menthe", "Pissenlit", "Rose", "Calendula", "Romarin"), // Baumes
            List.of("Citron", "Citron Vert"), // Gels
            List.of("Calendula, Guimauve, Camomille, Karité et Beure de Cacao","Miel"), // Pommades
            List.of("Rose", "Canneberge"), // Hydrolats Macérats de Bourgeons
            List.of("Sureau", "Tilleul", "Rosier Sauvage"), // Macérats de Bourgeons
            List.of("Lavande", "Violette") // Élixirs Floraux ou Fleurs de Bach
    );
    List<String> messageList = List.of("Super !", "J'aime cette page !", "Merci pour l'aide", "Merci d'avoir mis que certaines choses étaient dangereuses", "Merci pour les renseignements", "Les paragraphes sont très bien écrits !", "Je cherchais exactement cette page");
    
    private String getLittleWord() {
        String str = lorem.getWords(12, 16) + ".";
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public void initUser() {
        User u = userFacade.init("Paulin");
        UserSecurity us = userSecurityFacade.newInstance("Paulin", "test@test.test", "Test123*");
        us.setIsDark(true);
        us.addPermission(permissionFacade.newInstance(EnumRole.ROLE_USER));
        us.addPermission(permissionFacade.newInstance(EnumRole.ROLE_MODERATOR));
        us.addPermission(permissionFacade.newInstance(EnumRole.ROLE_ADMINISTRATOR));
        us.addPermission(permissionFacade.newInstance(EnumRole.ROLE_OWNER));
        us.setUser(u);
        userSecurityList.add(us);
        userList.add(u);
    }

    public void initTagType() {
        tagTypeList.add(tagTypeFacade.newInstance("Nom latin", this.getLittleWord())); //0
        tagTypeList.add(tagTypeFacade.newInstance("Famille", this.getLittleWord())); //1
        tagTypeList.add(tagTypeFacade.newInstance("Principes Actifs", this.getLittleWord())); //2
        tagTypeList.add(tagTypeFacade.newInstance("Propriétés", this.getLittleWord())); //3
        tagTypeList.add(tagTypeFacade.newInstance("Indications", this.getLittleWord())); //4
        tagTypeList.add(tagTypeFacade.newInstance("Contre-indications", this.getLittleWord())); //5
    }

    public void initParatagType() {
        paratagTypeList.add(paratagTypeFacade.newInstance("Nom latin", this.getLittleWord(), tagTypeList.get(0), EnumSize.SMALL, false)); //0
        paratagTypeList.add(paratagTypeFacade.newInstance("Famille", this.getLittleWord(), tagTypeList.get(1), EnumSize.SMALL, false)); //1
        paratagTypeList.add(paratagTypeFacade.newInstance("Principes Actifs", this.getLittleWord(), tagTypeList.get(2), EnumSize.LARGE, false)); //2
        paratagTypeList.add(paratagTypeFacade.newInstance("Propriétés", this.getLittleWord(), tagTypeList.get(3), EnumSize.LARGE, false)); //3
        paratagTypeList.add(paratagTypeFacade.newInstance("Indications", this.getLittleWord(), tagTypeList.get(4), EnumSize.LARGE, false)); //4
        paratagTypeList.add(paratagTypeFacade.newInstance("Contre-indications", this.getLittleWord(), tagTypeList.get(5), EnumSize.LARGE, true)); //5
    }

    public void initParapageType() {
        parapageTypeList.add(parapageTypeFacade.newInstance("Ingredients" , this.getLittleWord(), false)); //0
    }

    public void initParagraphType() {
        paragraphTypeList.addAll(Arrays.asList(
                paragraphTypeFacade.newInstance("Habitat et Culture", this.getLittleWord(), false), //0
                paragraphTypeFacade.newInstance("Espèces Voisines", this.getLittleWord(), false), //1
                paragraphTypeFacade.newInstance("Usages Traditionnels et Courants", this.getLittleWord(), false), //2
                paragraphTypeFacade.newInstance("Recherches en Cours", this.getLittleWord(), false), //3
                paragraphTypeFacade.newInstance("Parties Utilisées", this.getLittleWord(), false), //4
                paragraphTypeFacade.newInstance("Préparations et Usages", this.getLittleWord(), false), //5
                paragraphTypeFacade.newInstance("Toxicité et Contre-indication", this.getLittleWord(), false), //6
                paragraphTypeFacade.newInstance("Risques de Confusions", this.getLittleWord(), false), //7

                paragraphTypeFacade.newInstance("Utilisations", this.getLittleWord(), false), //8
                paragraphTypeFacade.newInstance("Précautions", this.getLittleWord(), true), //9
                paragraphTypeFacade.newInstance("Conservation", this.getLittleWord(), false), //10
                paragraphTypeFacade.newInstance("Préparation", this.getLittleWord(), false) //11
                ));
    }

    public void initCategory() {
        categoryList.addAll(Arrays.asList(
                categoryFacade.init("Plantes", this.getLittleWord()), //0
                categoryFacade.init("Tisanes", this.getLittleWord(), true) //1
        ));
        categoryList.addAll(Arrays.asList(
                categoryFacade.init("Huiles Essentielles", this.getLittleWord()), //2
                categoryFacade.init("Infusions", this.getLittleWord(), categoryList.get(1)), //3
                categoryFacade.init("Décoctions", this.getLittleWord(), categoryList.get(1)), //4
                categoryFacade.init("Macérations", this.getLittleWord(), categoryList.get(1)), //5
                categoryFacade.init("Sirops", this.getLittleWord()), //6
                categoryFacade.init("Cataplasmes", this.getLittleWord()), //7
                categoryFacade.init("Onguents", this.getLittleWord()), //8
                categoryFacade.init("Teintures Mères", this.getLittleWord()), //9
                categoryFacade.init("Vins Médicinaux", this.getLittleWord()), //10
                categoryFacade.init("Comprimés", this.getLittleWord()), //11
                categoryFacade.init("Fumigations", this.getLittleWord()), //12
                categoryFacade.init("Huiles Végétales", this.getLittleWord()), //13
                categoryFacade.init("Plantes Fraîches", this.getLittleWord()), //14
                categoryFacade.init("Élixirs", this.getLittleWord()), //15
                categoryFacade.init("Macérats Huileux", this.getLittleWord()), //16
                categoryFacade.init("Poudres", this.getLittleWord()), //17
                categoryFacade.init("Gélules", this.getLittleWord()), //18
                categoryFacade.init("Bains de Plantes", this.getLittleWord()), //19
                categoryFacade.init("Bains de Bouche ou Gargarismes", this.getLittleWord()), //20
                categoryFacade.init("Bains Oculaire", this.getLittleWord()), //21
                categoryFacade.init("Collyres", this.getLittleWord()), //22
                categoryFacade.init("Baumes", this.getLittleWord()), //23
                categoryFacade.init("Gels", this.getLittleWord()), //24
                categoryFacade.init("Pommades", this.getLittleWord()), //25
                categoryFacade.init("Hydrolats", this.getLittleWord()), //26
                categoryFacade.init("Macérats de Bourgeons", this.getLittleWord()), //27
                categoryFacade.init("Élixirs Floraux ou Fleurs de Bach", this.getLittleWord()))); //28

        // Plantes - 0

        /*for (Category c : categoryList) {
            if (c.isParent()) {
                continue;
            }
            int index = 1;
            for (int i : Utils.getRandomIdListUnique((paragraphTypeList.size() -1) / 2, paragraphTypeList.size() -1, paragraphTypeList.size() -1)) { //TOOD pas random le numbre avec la liste size
                c.addType(sortedTypeFacade.newInstance(paragraphTypeList.get(i), index));
                index++;
            }
            for (int i : Utils.getRandomIdListUnique((paratagTypeList.size() -1) / 2, paratagTypeList.size() -1, paratagTypeList.size() -1)) {
                c.addType(sortedTypeFacade.newInstance(paratagTypeList.get(i), index));
                index++;
            }
        }*/

        categoryList.get(0).addType(
            sortedTypeFacade.newInstance(paragraphTypeList.get(0), 3),
            sortedTypeFacade.newInstance(paragraphTypeList.get(1), 4),
            sortedTypeFacade.newInstance(paragraphTypeList.get(2), 5),
            sortedTypeFacade.newInstance(paragraphTypeList.get(3), 6),
            sortedTypeFacade.newInstance(paragraphTypeList.get(4), 7),
            sortedTypeFacade.newInstance(paragraphTypeList.get(5), 8),
            sortedTypeFacade.newInstance(paragraphTypeList.get(6), 9),
            sortedTypeFacade.newInstance(paragraphTypeList.get(7), 10),

            sortedTypeFacade.newInstance(paratagTypeList.get(0), 1),
            sortedTypeFacade.newInstance(paratagTypeList.get(1), 2),
            sortedTypeFacade.newInstance(paratagTypeList.get(2), 11)
        );

        categoryList.get(2).addType(
                sortedTypeFacade.newInstance(paragraphTypeList.get(8), 1),
                sortedTypeFacade.newInstance(paragraphTypeList.get(9), 2),

                sortedTypeFacade.newInstance(paratagTypeList.get(3), 3),
                sortedTypeFacade.newInstance(paratagTypeList.get(4), 4),

                sortedTypeFacade.newInstance(parapageTypeList.get(0), 5)
        );

        for (int i = 3; i < 29; i++) {
            categoryList.get(i).addType(
                    sortedTypeFacade.newInstance(paragraphTypeList.get(8), 1),
                    sortedTypeFacade.newInstance(paragraphTypeList.get(9), 7),
                    sortedTypeFacade.newInstance(paragraphTypeList.get(10), 2),
                    sortedTypeFacade.newInstance(paragraphTypeList.get(11), 3),

                    sortedTypeFacade.newInstance(paratagTypeList.get(3), 4),
                    sortedTypeFacade.newInstance(paratagTypeList.get(4), 5),
                    sortedTypeFacade.newInstance(paratagTypeList.get(5), 6),

                    sortedTypeFacade.newInstance(parapageTypeList.get(0), 8)
            );
        }

    }

    public void initTag() {
        //principe actif
        tagList.add(tagFacade.init(innerTagFacade.init("Acides-phénols", this.getLittleWord()), tagTypeList.get(2))); //0
        tagList.add(tagFacade.init(innerTagFacade.init("Sesquiterpènes", this.getLittleWord()), tagTypeList.get(2))); //1
        tagList.add(tagFacade.init(innerTagFacade.init("Triterpènes", this.getLittleWord()), tagTypeList.get(2))); //2
        tagList.add(tagFacade.init(innerTagFacade.init("Cires", this.getLittleWord()), tagTypeList.get(2))); //3
        tagList.add(tagFacade.init(innerTagFacade.init("Flavonoïdes", this.getLittleWord()), tagTypeList.get(2))); //4
        tagList.add(tagFacade.init(innerTagFacade.init("Esters", this.getLittleWord()), tagTypeList.get(2))); //5
        tagList.add(tagFacade.init(innerTagFacade.init("Tanins", this.getLittleWord()), tagTypeList.get(2))); //6
        tagList.add(tagFacade.init(innerTagFacade.init("Monoterpènes", this.getLittleWord()), tagTypeList.get(2))); //7
        tagList.add(tagFacade.init(innerTagFacade.init("Alcaloïdes", this.getLittleWord()), tagTypeList.get(2))); //8
        tagList.add(tagFacade.init(innerTagFacade.init("Saponosides", this.getLittleWord()), tagTypeList.get(2))); //9
        tagList.add(tagFacade.init(innerTagFacade.init("Diterpènes", this.getLittleWord()), tagTypeList.get(2))); //10

        //proprieter
        tagList.add(tagFacade.init(innerTagFacade.init("Amaigrisant", this.getLittleWord()), tagTypeList.get(3))); //11
        tagList.add(tagFacade.init(innerTagFacade.init("Analgesiques", this.getLittleWord()), tagTypeList.get(3))); //12
        tagList.add(tagFacade.init(innerTagFacade.init("Anticancers", this.getLittleWord()), tagTypeList.get(3))); //13
        tagList.add(tagFacade.init(innerTagFacade.init("Antiseptiques", this.getLittleWord()), tagTypeList.get(3))); //14
        tagList.add(tagFacade.init(innerTagFacade.init("Aperitifs", this.getLittleWord()), tagTypeList.get(3))); //15
        tagList.add(tagFacade.init(innerTagFacade.init("Aphordisiaques", this.getLittleWord()), tagTypeList.get(3))); //16
        tagList.add(tagFacade.init(innerTagFacade.init("Bechiques", this.getLittleWord()), tagTypeList.get(3))); //17
        tagList.add(tagFacade.init(innerTagFacade.init("Calmants", this.getLittleWord()), tagTypeList.get(3))); //18
        tagList.add(tagFacade.init(innerTagFacade.init("Carminatifs", this.getLittleWord()), tagTypeList.get(3))); //19
        tagList.add(tagFacade.init(innerTagFacade.init("Tonique", this.getLittleWord()), tagTypeList.get(3))); //20
        tagList.add(tagFacade.init(innerTagFacade.init("Astringent", this.getLittleWord()), tagTypeList.get(3))); //21
        tagList.add(tagFacade.init(innerTagFacade.init("Diurétique", this.getLittleWord()), tagTypeList.get(3))); //22
        tagList.add(tagFacade.init(innerTagFacade.init("Carminative", this.getLittleWord()), tagTypeList.get(3))); //23
        tagList.add(tagFacade.init(innerTagFacade.init("Adoucissant", this.getLittleWord()), tagTypeList.get(3))); //24
        tagList.add(tagFacade.init(innerTagFacade.init("Sudorifique", this.getLittleWord()), tagTypeList.get(3))); //25
        tagList.add(tagFacade.init(innerTagFacade.init("Hypotenseur", this.getLittleWord()), tagTypeList.get(3))); //26
        tagList.add(tagFacade.init(innerTagFacade.init("Antiseptique et Cicatrisant", this.getLittleWord()), tagTypeList.get(3))); //27

        //famille
        tagList.add(tagFacade.init(innerTagFacade.init("Cannabacées", this.getLittleWord()), tagTypeList.get(1))); //28
        tagList.add(tagFacade.init(innerTagFacade.init("Lamiacées", this.getLittleWord()), tagTypeList.get(1))); //29
        tagList.add(tagFacade.init(innerTagFacade.init("Caprifoliacées", this.getLittleWord()), tagTypeList.get(1))); //30
        tagList.add(tagFacade.init(innerTagFacade.init("Malvacées", this.getLittleWord()), tagTypeList.get(1))); //31
        tagList.add(tagFacade.init(innerTagFacade.init("Vitacées", this.getLittleWord()), tagTypeList.get(1))); //32
        tagList.add(tagFacade.init(innerTagFacade.init("Fabacées", this.getLittleWord()), tagTypeList.get(1))); //33

        //indication
        tagList.add(tagFacade.init(innerTagFacade.init("Nervosité", this.getLittleWord()), tagTypeList.get(4))); //34
        tagList.add(tagFacade.init(innerTagFacade.init("Anxiété", this.getLittleWord()), tagTypeList.get(4))); //35
        tagList.add(tagFacade.init(innerTagFacade.init("Angoisse", this.getLittleWord()), tagTypeList.get(4))); //36
        tagList.add(tagFacade.init(innerTagFacade.init("Agitation", this.getLittleWord()), tagTypeList.get(4))); //37
        tagList.add(tagFacade.init(innerTagFacade.init("Stress", this.getLittleWord()), tagTypeList.get(4))); //38
        tagList.add(tagFacade.init(innerTagFacade.init("Irritabilité", this.getLittleWord()), tagTypeList.get(4))); //39
        tagList.add(tagFacade.init(innerTagFacade.init("Insomnie", this.getLittleWord()), tagTypeList.get(4))); //40
        tagList.add(tagFacade.init(innerTagFacade.init("Séphalées", this.getLittleWord()), tagTypeList.get(4))); //41
        tagList.add(tagFacade.init(innerTagFacade.init("Migraine", this.getLittleWord()), tagTypeList.get(4))); //42
        tagList.add(tagFacade.init(innerTagFacade.init("Fatigue Nerveuse", this.getLittleWord()), tagTypeList.get(4))); //43
        tagList.add(tagFacade.init(innerTagFacade.init("Crampes Musculaires", this.getLittleWord()), tagTypeList.get(4))); //44
        tagList.add(tagFacade.init(innerTagFacade.init("Spasmes Digestifs", this.getLittleWord()), tagTypeList.get(4))); //45
        tagList.add(tagFacade.init(innerTagFacade.init("Éréthisme Cardiaque", this.getLittleWord()), tagTypeList.get(4))); //46
        tagList.add(tagFacade.init(innerTagFacade.init("Palpitations Cardiaques", this.getLittleWord()), tagTypeList.get(4))); //47
        tagList.add(tagFacade.init(innerTagFacade.init("Hypertension Artérielle", this.getLittleWord()), tagTypeList.get(4))); //48

        //conte-indication
        tagList.add(tagFacade.init(innerTagFacade.init("Enfants de moins de 3 ans", this.getLittleWord()), tagTypeList.get(5))); //49
        tagList.add(tagFacade.init(innerTagFacade.init("Femme enceinte", this.getLittleWord()), tagTypeList.get(5))); //50
        tagList.add(tagFacade.init(innerTagFacade.init("Femme allaitante", this.getLittleWord()), tagTypeList.get(5))); //51
        tagList.add(tagFacade.init(innerTagFacade.init("Inflammation du tractus gastro-intestinal ou des voies biliaires", this.getLittleWord()), tagTypeList.get(5))); //52
        tagList.add(tagFacade.init(innerTagFacade.init("Effet laxative/purgatif important", this.getLittleWord()), tagTypeList.get(5))); //53
        tagList.add(tagFacade.init(innerTagFacade.init("Nausées", this.getLittleWord()), tagTypeList.get(5))); //54
        tagList.add(tagFacade.init(innerTagFacade.init("Vomissement", this.getLittleWord()), tagTypeList.get(5))); //55
        tagList.add(tagFacade.init(innerTagFacade.init("Prudence car l’oxalate de calcium est responsable de la toxicité", this.getLittleWord()), tagTypeList.get(5))); //56

        //nom latin
        tagList.add(tagFacade.init(innerTagFacade.init("Mentha x pPiperita", this.getLittleWord()), tagTypeList.get(0))); //57
        tagList.add(tagFacade.init(innerTagFacade.init("Melissa Officinalis", this.getLittleWord()), tagTypeList.get(0))); //35
        tagList.add(tagFacade.init(innerTagFacade.init("Rosa Gallica", this.getLittleWord()), tagTypeList.get(0))); //36
        tagList.add(tagFacade.init(innerTagFacade.init("Salvia Officinalis", this.getLittleWord()), tagTypeList.get(0))); //37
        tagList.add(tagFacade.init(innerTagFacade.init("Verbena Officinalis", this.getLittleWord()), tagTypeList.get(0))); //38
        tagList.add(tagFacade.init(innerTagFacade.init("Humulus Lupulus", this.getLittleWord()), tagTypeList.get(0))); //39
        tagList.add(tagFacade.init(innerTagFacade.init("Articum Lappa", this.getLittleWord()), tagTypeList.get(0))); //40
        tagList.add(tagFacade.init(innerTagFacade.init("Artemisia Dracunculus", this.getLittleWord()), tagTypeList.get(0))); //41
        tagList.add(tagFacade.init(innerTagFacade.init("Hyssopus Officinalis", this.getLittleWord()), tagTypeList.get(0))); //42
        tagList.add(tagFacade.init(innerTagFacade.init("Glechoma Hederacea", this.getLittleWord()), tagTypeList.get(0))); //43
        tagList.add(tagFacade.init(innerTagFacade.init("Lavandula angustifolia Mill", this.getLittleWord()), tagTypeList.get(0))); //37
        tagList.add(tagFacade.init(innerTagFacade.init("Salvia", this.getLittleWord()), tagTypeList.get(0))); //38
        tagList.add(tagFacade.init(innerTagFacade.init("Abies", this.getLittleWord()), tagTypeList.get(0))); //39
        tagList.add(tagFacade.init(innerTagFacade.init("Laurus Nobilis", this.getLittleWord()), tagTypeList.get(0))); //40
        tagList.add(tagFacade.init(innerTagFacade.init("Citrus", this.getLittleWord()), tagTypeList.get(0))); //41
        tagList.add(tagFacade.init(innerTagFacade.init("Viola", this.getLittleWord()), tagTypeList.get(0))); //42
        tagList.add(tagFacade.init(innerTagFacade.init("Zingiber officinale", this.getLittleWord()), tagTypeList.get(0))); //43
    }

    public void initParatag() {
        for (int j = 0; j < namePlanteList.size(); j++) {
            InnerParatag i = innerParatagFacade.init(lorem.getTitle(2, 4), lorem.getParagraphs(1, 4));
            for (int k : Utils.getRandomIdListUnique(2, 8, 0, 10)) {
                i.addTag(tagList.get(k));
            }
            paratagList.add(paratagFacade.init(i, paratagTypeList.get(2)));

            i = innerParatagFacade.init(lorem.getTitle(2, 4), lorem.getParagraphs(1, 4));
            i.addTag(tagList.get(Utils.getRandom(28, 33)));
            paratagList.add(paratagFacade.init(i, paratagTypeList.get(1)));

            i = innerParatagFacade.init(lorem.getTitle(2, 4), lorem.getParagraphs(1, 4));
            i.addTag(tagList.get(57 + j));
            paratagList.add(paratagFacade.init(i, paratagTypeList.get(0)));
        }

        for (int j = 0; j < nameHuileList.size(); j++) {
            InnerParatag i = innerParatagFacade.init(lorem.getTitle(2, 4), lorem.getParagraphs(1, 4));
            for (int k : Utils.getRandomIdListUnique(2, 8, 11, 27)) {
                i.addTag(tagList.get(k));
            }
            paratagList.add(paratagFacade.init(i, paratagTypeList.get(3)));

            i = innerParatagFacade.init(lorem.getTitle(2, 4), lorem.getParagraphs(1, 4));
            for (int k : Utils.getRandomIdListUnique(2, 8, 34, 48)) {
                i.addTag(tagList.get(k));
            }
            paratagList.add(paratagFacade.init(i, paratagTypeList.get(4)));
        }

        for (int w = 0; w < nameAllList.size(); w++) {
            for (int j = 0; j < nameAllList.get(w).size(); j++) {
                InnerParatag i = innerParatagFacade.init(lorem.getTitle(2, 4), lorem.getParagraphs(1, 4));
                for (int k : Utils.getRandomIdListUnique(2, 8, 11, 27)) {
                    i.addTag(tagList.get(k));
                }
                paratagList.add(paratagFacade.init(i, paratagTypeList.get(3)));

                i = innerParatagFacade.init(lorem.getTitle(2, 4), lorem.getParagraphs(1, 4));
                for (int k : Utils.getRandomIdListUnique(2, 8, 34, 48)) {
                    i.addTag(tagList.get(k));
                }
                paratagList.add(paratagFacade.init(i, paratagTypeList.get(4)));

                i = innerParatagFacade.init(lorem.getTitle(2, 4), lorem.getParagraphs(1, 4));
                for (int k : Utils.getRandomIdListUnique(2, 4, 49, 56)) {
                    i.addTag(tagList.get(k));
                }
                paratagList.add(paratagFacade.init(i, paratagTypeList.get(5)));
            }
        }
    }

    public void initParagraph() {
        for (int i = 0; i < namePlanteList.size(); i++) {
            for (int j = 0; j < 8; j++) {
                paragraphList.add(paragraphFacade.init(innerParagraphFacade.init(lorem.getTitle(2, 4), lorem.getParagraphs(1, 4)), paragraphTypeList.get(j)));
            }
        }
        for (int i = 0; i < nameHuileList.size(); i++) {
            paragraphList.add(paragraphFacade.init(innerParagraphFacade.init(lorem.getTitle(2, 4), lorem.getParagraphs(1, 4)), paragraphTypeList.get(8)));
            paragraphList.add(paragraphFacade.init(innerParagraphFacade.init(lorem.getTitle(2, 4), lorem.getParagraphs(1, 4)), paragraphTypeList.get(9)));
        }
        for (int w = 0; w < nameAllList.size(); w++) {
            for (int j = 0; j < nameAllList.get(w).size(); j++) {
                paragraphList.add(paragraphFacade.init(innerParagraphFacade.init(lorem.getTitle(2, 4), lorem.getParagraphs(1, 4)), paragraphTypeList.get(8)));
                paragraphList.add(paragraphFacade.init(innerParagraphFacade.init(lorem.getTitle(2, 4), lorem.getParagraphs(1, 4)), paragraphTypeList.get(10)));
                paragraphList.add(paragraphFacade.init(innerParagraphFacade.init(lorem.getTitle(2, 4), lorem.getParagraphs(1, 4)), paragraphTypeList.get(9)));
                paragraphList.add(paragraphFacade.init(innerParagraphFacade.init(lorem.getTitle(2, 4), lorem.getParagraphs(1, 4)), paragraphTypeList.get(11)));
            }
        }
    }

    public void initImage() {
        int index = 1;
        for (String s: namePlanteList) {
            imageList.add(imageFacade.init(innerImageFacade.init(s, this.getLittleWord(), "init-p-" + index + ".jpg")));
            index++;
        }
        index = 1;
        for (String s: nameHuileList) {
            imageList.add(imageFacade.init(innerImageFacade.init(s, this.getLittleWord(), "init-h-" + index + ".jpg")));
            index++;
        }
        int indexImageHelp = 0;
        for (List<String> n: nameAllList) {
            index = 1;
            for (String s: n) {
                imageList.add(imageFacade.init(innerImageFacade.init(s, this.getLittleWord(), "init-" + imageHelp.get(indexImageHelp) + "-" + index + ".jpg")));
                index++;
            }
            indexImageHelp++;
        }
    }

    public void initPage() {
        int indexImage = 0;
        int index = 0;
        for (String s: namePlanteList) {
            Page page = pageFacade.init(innerPageFacade.init(s, this.getLittleWord(), imageList.get(indexImage)),
                    categoryList.get(0));
            page.addParagraph(paragraphList.get((index * 8)), paragraphList.get(1 + (index * 8)), paragraphList.get(2 + (index * 8)), paragraphList.get(3 + (index * 8)), paragraphList.get(4 + (index * 8)), paragraphList.get(5 + (index * 8)), paragraphList.get(6 + (index * 8)), paragraphList.get(7 + (index * 8)));
            page.addParatag(paratagList.get(index * 3), paratagList.get(1 + (index * 3)), paratagList.get(2 + (index * 3)));

            for (int k : Utils.getRandomIdListUnique(2, 6, 0, messageList.size() - 1)) {
                page.addMessage(messageFacade.init(messageList.get(k)));
            }

            pageList.add(page);
            index++;
            indexImage++;
        }
        index = 0;
        for (String s: nameHuileList) {
            int offsetParag = (8 * namePlanteList.size());
            int offsetParat = (3 * namePlanteList.size());
            Page page = pageFacade.init(innerPageFacade.init(s, this.getLittleWord(), imageList.get(indexImage)),
                    categoryList.get(2));
            page.addParagraph(paragraphList.get((index * 2) + offsetParag), paragraphList.get(1 + (index * 2) + offsetParag));
            page.addParatag(paratagList.get(index * 2 + offsetParat), paratagList.get(1 + (index * 2) + offsetParat));

            for (int k : Utils.getRandomIdListUnique(2, 6, 0, messageList.size() - 1)) {
                page.addMessage(messageFacade.init(messageList.get(k)));
            }

            parapageList.add(parapageFacade.init(innerParapageFacade.init(lorem.getTitle(2, 4), lorem.getParagraphs(1, 4)), parapageTypeList.get(0)));
            String[] pageTitle = s.toLowerCase().replace(",", "").split(" ");
            int indexS = 0;
            for (String pageS : this.namePlanteList) {
                String[] pagePlanteTitle = pageS.toLowerCase().replace(",", "").split(" ");
                for (String t : pagePlanteTitle) {
                    for (String s1 : pageTitle) {
                        if (t.equals(s1) && !t.equals("le") && !t.equals("la") && !t.equals("de") && !t.equals("et") && !t.equals("du") && !t.equals(",") && !t.equals("ou") && !parapageList.get(parapageList.size() -1).getInnerParapageList().get(0).getPageList().contains(pageList.get(indexS))) {
                            parapageList.get(parapageList.size() -1).getInnerParapageList().get(0).addPage(pageList.get(indexS));
                        }
                    }
                }
                indexS++;
            }
            page.addParapage(parapageList.get(parapageList.size() -1));

            pageList.add(page);
            index++;
            indexImage++;
        }
        int offsetParag = (8 * namePlanteList.size()) + (2 * nameHuileList.size());
        int offsetParat = (3 * namePlanteList.size()) + (2 * nameHuileList.size());
        int indexCategory = 3;
        for (List<String> n: nameAllList) {
            index = 0;
            for (String s : n) {
                Page page = pageFacade.init(innerPageFacade.init(s, this.getLittleWord(), imageList.get(indexImage)),
                        categoryList.get(indexCategory));
                page.addParagraph(paragraphList.get(index * 3 + offsetParag), paragraphList.get(1 + (index * 3) + offsetParag), paragraphList.get(2 + (index * 3) + offsetParag));
                page.addParatag(paratagList.get(index * 3 + offsetParat), paratagList.get(1 + (index * 3) + offsetParat), paratagList.get(2 + (index * 3) + offsetParat));

                for (int k : Utils.getRandomIdListUnique(2, 6, 0, messageList.size() - 1)) {
                    page.addMessage(messageFacade.init(messageList.get(k)));
                }

                parapageList.add(parapageFacade.init(innerParapageFacade.init(lorem.getTitle(2, 4), lorem.getParagraphs(1, 4)), parapageTypeList.get(0)));
                String[] pageTitle = s.toLowerCase().replace(",", "").split(" ");
                int indexS = 0;
                for (String pageS : this.namePlanteList) {
                    String[] pagePlanteTitle = pageS.toLowerCase().replace(",", "").split(" ");
                    for (String t : pagePlanteTitle) {
                        for (String s1 : pageTitle) {
                            if (t.equals(s1) && !t.equals("le") && !t.equals("la") && !t.equals("de") && !t.equals("et") && !t.equals("du") && !t.equals(",") && !t.equals("ou") && !parapageList.get(parapageList.size() -1).getInnerParapageList().get(0).getPageList().contains(pageList.get(indexS))) {
                                parapageList.get(parapageList.size() -1).getInnerParapageList().get(0).addPage(pageList.get(indexS));
                            }
                        }
                    }
                    indexS++;
                }
                page.addParapage(parapageList.get(parapageList.size() -1));

                pageList.add(page);
                index++;
                indexImage++;
            }
            indexCategory++;
            offsetParag += 3 * n.size();
            offsetParat += 3 * n.size();
        }
    }

    @PostConstruct
    public void init() {
        initUser();
        userSecurityList.forEach(user -> {
            user.getEnumPermissionList().forEach(p -> {
                permissionRepository.save(p);
            });
            userRepository.save(user.getUser());
            userSecurityRepository.save(user);
        });

        initParagraphType();
        initTagType();
        initParapageType();
        initParatagType();

        initCategory();

        initTag();
        initParatag();
        initParagraph();

        initImage();
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
        parapageTypeList.forEach(parapageType -> {
            parapageTypeRepository.save(parapageType);
        });
        categoryList.forEach(i -> {
            if (i.getSortedTypeList() != null)
                i.getSortedTypeList().forEach(j -> {
                    sortedTypeRepository.save(j);
                });
            categoryRepository.save(i);
        });
        paragraphList.forEach(i -> {
            i.getInnerParagraphList().forEach(j -> {
                if (j.getVoteList() != null)
                    j.getVoteList().forEach(k -> {
                        voteRepository.save(k);
                    });
                innerParagraphRepository.save(j);
            });
            paragraphRepository.save(i);
        });
        tagList.forEach(i -> {
            i.getInnerTagList().forEach(j -> {
                if (j.getVoteList() != null)
                    j.getVoteList().forEach(k -> {
                        voteRepository.save(k);
                    });
                innerTagRepository.save(j);
            });
            tagRepository.save(i);
        });
        paratagList.forEach(i -> {
            i.getInnerParatagList().forEach(j -> {
                if (j.getVoteList() != null)
                    j.getVoteList().forEach(k -> {
                        voteRepository.save(k);
                    });
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

        int stopIndex = 0;
        for (Page i : pageList) {
            i.getInnerPageList().forEach(j -> {
                if (j.getVoteList() != null)
                    j.getVoteList().forEach(k -> {
                        voteRepository.save(k);
                    });
                innerPageRepository.save(j);
            });
            i.getMessageList().forEach(m -> {
                messageRepository.save(m);
            });
            pageRepository.save(i);
            if (namePlanteList.size() - 1 <= stopIndex) {
                break;
            }
            stopIndex++;
        }

        parapageList.forEach(i -> {
            i.getInnerParapageList().forEach(j -> {
                if (j.getVoteList() != null)
                    j.getVoteList().forEach(k -> {
                        voteRepository.save(k);
                    });
                innerParapageRepository.save(j);
            });
            parapageRepository.save(i);
        });


        pageList.forEach(i -> {
            i.getInnerPageList().forEach(j -> {
                if (j.getVoteList() != null)
                    j.getVoteList().forEach(k -> {
                        voteRepository.save(k);
                    });
                innerPageRepository.save(j);
            });
            i.getMessageList().forEach(m -> {
                messageRepository.save(m);
            });
            pageRepository.save(i);
        });
    }

}
