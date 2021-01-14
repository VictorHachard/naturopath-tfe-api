package be.heh.app.mappers.app;

import be.heh.app.dto.*;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.*;
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
public final class PageMapper extends AbstractMapper {

    public Page map(InnerPage innerPage, Category category, User user) {
        return pageFacade.newInstance(innerPage, user, category);
    }

    public List<PageDto> getAll(List<Page> pageList) {
        List<PageDto> pageDtoList = new ArrayList<>();
        pageList.forEach(page -> {
            pageDtoList.add(this.get(page));
        });
        return pageDtoList;
    }

    public PageDto get(Page page) {
        List<ParagraphDto> paragraphDtoList = new ArrayList<>();
        page.getParagraphList().forEach(paragraph -> {
            InnerParagraph innerParagraph = paragraphFacade.getLastNonDraft(paragraph);
            paragraphDtoList.add(new ParagraphDto(innerParagraph.getTitle(), innerParagraph.getContent()));
        });

        List<TagDto> tagDtoList = new ArrayList<>();
        page.getTagList().forEach(tag -> {
            InnerTag innerTag = tagFacade.getLastNonDraft(tag);
            tagDtoList.add(new TagDto(innerTag.getName(), innerTag.getContent()));
        });

        List<ParapageDto> parapageDtoList = new ArrayList<>();
        page.getParapageList().forEach(parapage -> {
            InnerParapage innerParapage = parapageFacade.getLastNonDraft(parapage);
            List<PageForPageDto> pageForPageDtos = new ArrayList<>();
            innerParapage.getPageList().forEach(page1 -> {
                InnerPage page2 = pageFacade.getLastNonDraft(page1);
                pageForPageDtos.add(new PageForPageDto(page2.getTitle(), page2.getDescription()));
            });
            parapageDtoList.add(new ParapageDto(innerParapage.getTitle(), pageForPageDtos
            ));
        });

        List<ParatagDto> paratagDtoList = new ArrayList<>(); //TODO
        /*page.getParatagList().forEach(paratag -> {
            InnerTag innerTag = paratag.getInnerParatagList().get();
            tagDtoList.add(new TagDto(innerTag.getName(), innerTag.getContent()));
        });*/

        List<ImageDto> imageDtos = new ArrayList<>();
        page.getImageList().forEach(image -> {
            InnerImage innerImage = imageFacade.getLastNonDraft(image);
            imageDtos.add(new ImageDto(innerImage.getTitle(),
                    innerImage.getDescription(),
                    innerImage.getUrl()));
        });

        InnerPage innerPage = pageFacade.getLastNonDraft(page);

        return new PageDto(page.getId(),
                page.getCreatedAt(),
                page.getCategory(),
                page.getUser(),
                innerPage.getTitle(),
                innerPage.getDescription(),
                paragraphDtoList,
                tagDtoList,
                parapageDtoList,
                paratagDtoList,
                imageDtos
        );
    }
}
