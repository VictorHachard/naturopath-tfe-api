package be.heh.app.mappers.app;

import be.heh.app.dto.edit.TagEditDto;
import be.heh.app.dto.view.TagByTagTypeViewDto;
import be.heh.app.dto.view.TagViewDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.InnerTag;
import be.heh.app.model.entities.app.Tag;
import be.heh.app.model.entities.app.TagType;
import be.heh.app.model.entities.app.User;
import be.heh.app.model.entities.app.enumeration.EnumState;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public final class TagMapper extends AbstractMapper {

    public Tag set(InnerTag innerTag, TagType tagType, User user) {
        return tagFacade.newInstance(innerTag, tagType, user);
    }

    public List<TagViewDto> getAllView(List<Tag> j) {
        List<TagViewDto> res = new ArrayList<>();
        j.forEach(i -> {
            TagViewDto d = this.getView(i);
            if (d != null) {
                res.add(d);
            }
        });
        return res;
    }

    public TagViewDto getView(Tag j) {
        List<InnerTag> i = tagRepository.findInnerTag(j, EnumState.VALIDATED);
        if (i == null || i.isEmpty()) {
            return null;
        } else {
            InnerTag k = i.get(0);
            return new TagViewDto(
                    k.getId(),
                    tagTypeMapper.getView(j.getTagType()),
                    k.getName(),
                    k.getContent());
        }
    }

    public List<TagEditDto> getAllEditDto(List<Tag> list) {
        List<TagEditDto> res = new ArrayList<>();
        list.forEach(i -> {
            res.add(this.getEditDto(i));
        });
        return res;
    }

    public TagEditDto getEditDto(Tag j) {
        return new TagEditDto(
                j.getId(),
                tagTypeMapper.getView(j.getTagType()),
                innerTagMapper.getAllEditDto(j.getInnerTagList())
        );
    }

    public List<TagByTagTypeViewDto> getAllTagByTagTypeDto(List<Tag> tagList) {
        List<TagByTagTypeViewDto> res = new ArrayList<>();
        tagList.forEach(i -> {
            InnerTag innerTag = tagRepository.findInnerTag(i, EnumState.VALIDATED).get(0);

            res.add(new TagByTagTypeViewDto(
                    i.getId(),
                    i.getCreatedAt(),
                    innerTag.getName(),
                    innerTag.getContent()
            ));
        });
        return res;
    }

}
