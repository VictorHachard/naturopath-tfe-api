package be.heh.app.controller.rest.app;

import be.heh.app.controller.rest.commons.AbstractController;
import be.heh.app.controller.validators.app.VoteValidator;
import be.heh.app.model.entities.app.Vote;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class VoteController extends AbstractController {

    @GetMapping("/vote")
    public List<Vote> getAllVote() {
        return voteService.getAll();
    }

    @GetMapping("/vote/{id}")
    public Vote getVote(@PathVariable("id") int id) {
        return voteService.get(id);
    }

    @PostMapping("/vote")
    public Vote insertVote(@Valid @RequestBody VoteValidator voteValidator) {
        return voteService.insertVote(voteValidator);
    }

}
