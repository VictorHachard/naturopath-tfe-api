package be.heh.app.mappers.app;

import be.heh.app.dto.edit.PageEditDto;
import be.heh.app.dto.view.*;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.*;
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
public final class PageMapper extends AbstractMapper {

    public Page set(InnerPage innerPage, Category category, User user) {
        return pageFacade.newInstance(
                innerPage,
                user,
                category);
    }

    public List<PageViewDto> getAllDto(List<Page> pageList) {
        List<PageViewDto> pageDtoList = new ArrayList<>();
        pageList.forEach(page -> {
            pageDtoList.add(this.getDto(page));
        });
        return pageDtoList;
    }

    public List<PageEditDto> getAllEditDto(List<Page> pageList) {
        List<PageEditDto> pageDtoList = new ArrayList<>();
        pageList.forEach(page -> {
            pageDtoList.add(this.getEditDto(page));
        });
        return pageDtoList;
    }

    public PageViewDto getDto(Page page) {
        List<InnerPage> innerPageList = pageRepository.findInnerPage(page, EnumState.VALIDATED);
        InnerPage innerPage;

        if (innerPageList.isEmpty()) { //TODO remove
            return null;
        } else {
            innerPage = innerPageList.get(0);
        }

        return new PageViewDto(
                page.getId(),
                page.getEnumState().toString(),
                page.getCreatedAt(),
                categoryMapper.getView(page.getCategory()),
                userMapper.getView(page.getUser()),
                innerPage.getTitle(),
                innerPage.getDescription(),
                paragraphMapper.getAllView(page.getParagraphList()),
                parapageMapper.getAllView(page.getParapageList()),
                paratagMapper.getAllView(page.getParatagList()),
                imageMapper.getView(innerPage.getImage()),
                sortedTypeMapper.getAllView(page.getCategory().getSortedTypeList())
        );
    }

    public PageByCategoryViewDto getAllPageByCategoryDto(List<Page> pageList) {
        return this.getAllPageByCategoryDto(pageList, pageList.size());
    }

    public PageByCategoryViewDto getAllPageByCategoryDto(List<Page> pageList, int size) {
        List<PageSimplifiedViewDto> res = new ArrayList<>();
        pageList.forEach(i -> {
            InnerPage innerPage = pageRepository.findInnerPage(i, EnumState.VALIDATED).get(0);

            List<TagViewDto> tagViewDtoList = new ArrayList<>();

            i.getParatagList().forEach(paratag -> {
                tagViewDtoList.addAll(tagMapper.getAllView(paratagRepository.findInnerParatag(paratag, EnumState.VALIDATED).get(0).getTagList()));
            });

            res.add(new PageSimplifiedViewDto(
                    i.getId(),
                    i.getCreatedAt(),
                    innerPage.getTitle(),
                    innerPage.getDescription(),
                    imageMapper.getImageForPageByCategoryView(innerPage.getImage()),
                    tagViewDtoList
            ));
        });
        return new PageByCategoryViewDto(size, res);
    }

    public List<PageSearchDto> getAllSearchDto(List<Page> pages) {
        List<PageSearchDto> res = new ArrayList<>();
        for (Page page : pages) {
            boolean cat = false;
            int index = 0;
            for (PageSearchDto psd : res) {
                if (page.getCategory().getId() == psd.getCategoryViewDto().getId()) {
                    cat = true;
                    break;
                }
                index++;
            }
            if (!cat) {
                res.add(new PageSearchDto(
                        categoryMapper.getView(page.getCategory()),
                        new ArrayList<>()
                ));
            }
            InnerPage innerPage = pageRepository.findInnerPage(page, EnumState.VALIDATED).get(0);
            PageSimplifiedRecommendedViewDto p2 = new PageSimplifiedRecommendedViewDto(
                    page.getId(),
                    page.getCreatedAt(),
                    innerPage.getTitle(),
                    innerPage.getDescription(),
                    imageMapper.getImageForPageByCategoryView(innerPage.getImage())
            );
            if (!cat) {
                res.get(res.size() -1).getPageSimplifiedRecommendedViewDtoList().add(p2);
            } else {
                res.get(index).getPageSimplifiedRecommendedViewDtoList().add(p2);
            }
        }
        return res;
    }

    public PageEditDto getEditDto(Page page) {
        return new PageEditDto(
                page.getId(),
                page.getEnumState().toString(),
                categoryMapper.getView(page.getCategory()),
                userMapper.getView(page.getUser()),
                innerPageMapper.getAllEditDto(page.getInnerPageList()),
                paragraphMapper.getAllEditDto(page.getParagraphList()),
                paratagMapper.getAllEditDto(page.getParatagList()),
                parapageMapper.getAllEditDto(page.getParapageList())
        );
    }

}
