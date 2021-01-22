package be.heh.app.mappers.app;

import be.heh.app.dto.view.PageByCategoryViewDto;
import be.heh.app.dto.view.PageViewDto;
import be.heh.app.mappers.app.commons.AbstractMapper;
import be.heh.app.model.entities.app.Category;
import be.heh.app.model.entities.app.InnerPage;
import be.heh.app.model.entities.app.Page;
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

    public PageViewDto getDto(Page page) {
        InnerPage innerPage = pageRepository.findInnerPage(page, EnumState.VALIDATED).get(0);

        return new PageViewDto(
                page.getId(),
                page.getCreatedAt(),
                categoryMapper.getView(page.getCategory()),
                userMapper.getView(page.getUser()),
                innerPage.getTitle(),
                innerPage.getDescription(),
                paragraphMapper.getAllView(page.getParagraphList()),
                parapageMapper.getAllView(page.getParapageList()),
                paratagMapper.getAllView(page.getParatagList()),
                imageMapper.getAllView(page.getImageList())
        );
    }

    public List<PageByCategoryViewDto> getAllPageByCategoryDto(List<Page> pageList) {
        List<PageByCategoryViewDto> res = new ArrayList<>();
        pageList.forEach(page -> {
            InnerPage innerPage = pageRepository.findInnerPage(page, EnumState.VALIDATED).get(0);

            res.add(new PageByCategoryViewDto(
                    page.getId(),
                    page.getCreatedAt(),
                    innerPage.getTitle(),
                    innerPage.getDescription(),
                    page.getImageList().size() == 0 ? null : imageMapper.getImageForPageByCategoryView(page.getImageList().get(0))
            ));
        });
        return res;
    }
}
