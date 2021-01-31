package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.VoteValidator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/vote/")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class VoteController extends AbstractController {

    @PostMapping("")
    public void add(@Valid @RequestBody VoteValidator voteValidator) {
        voteService.add(voteValidator);
    }

}
