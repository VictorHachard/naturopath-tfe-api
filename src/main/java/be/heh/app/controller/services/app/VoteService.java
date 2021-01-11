package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.VoteValidator;
import be.heh.app.model.entities.app.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class VoteService extends AbstractService {

    public List<Vote> getAllVote() {
        if (voteRepository.findAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Vote in the database");
        } else {
            return voteRepository.findAll();
        }
    }

    public Vote getVote(int id) {
        if (voteRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no Vote with this voteId");
        } else {
            return voteRepository.findById(id).get();
        }
    }

    public Vote insertVote(VoteValidator voteValidator) {
        if (userRepository.findById(voteValidator.getUserId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no User with this userId");
        }
        User user = userRepository.findById(voteValidator.getUserId()).get();
        Vote vote;
        if (voteValidator.getType().equals("InnerPage")) {
            if (innerPageRepository.findById(voteValidator.getTypeId()).isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no InnerPage with this typeId");
            }
            vote = voteMapper.map(voteValidator, userRepository.findById(voteValidator.getUserId()).get());
            InnerPage innerPage = innerPageRepository.findById(voteValidator.getTypeId()).get();
            if (innerPage.userAlreadyVote(user)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no InnerPage with this typeId"); //dejavoter
            } else {
                if (!innerPage.getState().equals("PROGRESS")) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no InnerPage with this typeId"); //pus vote
                } else {
                    voteRepository.save(vote);
                    boolean voteResult = innerPage.addVote(vote);
                    if (!voteResult) {
                        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no InnerPage with this typeId"); //les 5 pote on voter
                    }
                    innerPageRepository.save(innerPage);
                }
            }
        } else if (voteValidator.getType().equals("InnerParagraph")) {
            if (innerParagraphRepository.findById(voteValidator.getTypeId()).isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no InnerParagraph with this typeId");
            }
            vote = voteMapper.map(voteValidator, userRepository.findById(voteValidator.getUserId()).get());
            InnerParagraph innerParagraph = innerParagraphRepository.findById(voteValidator.getTypeId()).get();
            if (innerParagraph.userAlreadyVote(user)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no InnerPage with this typeId"); //dejavoter
            } else {
                if (!innerParagraph.getState().equals("PROGRESS")) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no InnerPage with this typeId"); //pus vote
                } else {
                    voteRepository.save(vote);
                    boolean voteResult = innerParagraph.addVote(vote);
                    if (!voteResult) {
                        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no InnerPage with this typeId"); //les 5 pote on voter
                    }
                    innerParagraphRepository.save(innerParagraph);
                }
            }
        } else if (voteValidator.getType().equals("InnerTag")) {
            if (innerTagRepository.findById(voteValidator.getTypeId()).isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no InnerTag with this typeId");
            }
            vote = voteMapper.map(voteValidator, userRepository.findById(voteValidator.getUserId()).get());
            InnerTag innerTag = innerTagRepository.findById(voteValidator.getTypeId()).get();
            if (innerTag.userAlreadyVote(user)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no InnerPage with this typeId"); //dejavoter
            } else {
                if (!innerTag.getState().equals("PROGRESS")) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no InnerPage with this typeId"); //pus vote
                } else {
                    voteRepository.save(vote);
                    boolean voteResult = innerTag.addVote(vote);
                    if (!voteResult) {
                        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no InnerPage with this typeId"); //les 5 pote on voter
                    }
                    innerTagRepository.save(innerTag);
                }
            }
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "logique  getType est pas bon");
        }
        return vote;
    }

}
