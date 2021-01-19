package be.heh.app.model.entities.app;

import be.heh.app.model.entities.commons.AbstractLang;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
// Lombok
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Category extends AbstractLang {

    @Column(name = "name")
    String name;

    @Column(name = "description", length = 2500)
    String description;

    @Column(name = "order_f")
    int order;

    @JoinColumn(name = "category_id")
    @ManyToOne
    Category parentCategory;

    @OneToMany
    List<ParagraphType> paragraphTypeList;

    @OneToMany
    List<TagType> tagTypeList;

    @OneToMany
    List<ParapageType> parapageTypeList;

    @OneToMany
    List<ParatagType> paratagTypeList;

    public void addParagraphType(ParagraphType... paragraphType) {
        if (paragraphTypeList == null) {
            paragraphTypeList = new ArrayList<>();
        }
        paragraphTypeList.addAll(Arrays.asList(paragraphType));
    }

    public void addAllParagraphType(List<ParagraphType> paragraphType) {
        if (paragraphTypeList == null) {
            paragraphTypeList = new ArrayList<>();
        }
        paragraphTypeList.addAll(paragraphType);
    }

    public void addTagType(TagType... tagType) {
        if (tagTypeList == null) {
            tagTypeList = new ArrayList<>();
        }
        tagTypeList.addAll(Arrays.asList(tagType));
    }

    public void addAllTagType(List<TagType> tagType) {
        if (tagTypeList == null) {
            tagTypeList = new ArrayList<>();
        }
        tagTypeList.addAll(tagType);
    }

    public void addParapageType(ParapageType... parapageType) {
        if (parapageTypeList == null) {
            parapageTypeList = new ArrayList<>();
        }
        parapageTypeList.addAll(Arrays.asList(parapageType));
    }

    public void addAllParapageType(List<ParapageType> parapageType) {
        if (parapageTypeList == null) {
            parapageTypeList = new ArrayList<>();
        }
        parapageTypeList.addAll(parapageType);
    }

    public void addParatagType(ParatagType... paratagType) {
        if (paratagTypeList == null) {
            paratagTypeList = new ArrayList<>();
        }
        paratagTypeList.addAll(Arrays.asList(paratagType));
    }

    public void addAllParatagType(List<ParatagType> paratagType) {
        if (paratagTypeList == null) {
            paratagTypeList = new ArrayList<>();
        }
        paratagTypeList.addAll(paratagType);
    }

}
