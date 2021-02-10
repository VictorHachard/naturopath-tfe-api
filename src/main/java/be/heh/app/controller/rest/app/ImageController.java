package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.ImageValidator;
import be.heh.app.dto.edit.ImageEditDto;
import be.heh.app.dto.view.ImageViewDto;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/image/")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class ImageController extends AbstractController {

    @GetMapping("dto")
    public List<ImageViewDto> getAllDto() {
        return imageService.getAllDto();
    }

    @GetMapping("dto/{id}")
    public ImageViewDto getDto(@PathVariable("id") int id) {
        return imageService.getDto(id);
    }

    /*@GetMapping("dto/edit")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public List<ImageViewDto> getAllEditDto() {
        return imageService.getAllEditDto();
    }*/

    @GetMapping("dto/edit/{id}")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public ImageEditDto getEditDto(@PathVariable("id") int id) {
        return imageService.getEditDto(id);
    }

    @PostMapping("")
    @PreAuthorize("hasRole('OWNER') or hasRole('ADMINISTRATOR') or hasRole('MODERATOR') or hasRole('USER')")
    public int add(@Valid @RequestBody ImageValidator validator) {
        return imageService.addC(validator);
    }

}
