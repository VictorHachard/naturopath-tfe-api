package be.heh.app.controller.services.app;

import be.heh.app.controller.services.commons.AbstractService;
import be.heh.app.controller.validators.app.VoteValidator;
import be.heh.app.controller.validators.commons.AbstractValidator;
import be.heh.app.model.entities.app.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class VoteService extends AbstractService<Vote> {

    @Override
    public void add(AbstractValidator abstractValidator) {
        VoteValidator validator = (VoteValidator) abstractValidator;

        if (userRepository.findById(validator.getUserId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no User with this userId");
        }
        User user = userRepository.findById(validator.getUserId()).get();

        if (validator.getType().equals("InnerParagraph")) {
            InnerParagraph innerParagraph = innerParagraphRepository.findById(validator.getTypeId()).get();
            Vote vote = voteMapper.set(validator, user);
            voteRepository.save(vote);
            innerParagraph.addVote(vote);
            innerParagraphRepository.save(innerParagraph);

        } else if (validator.getType().equals("InnerPage")) {
            InnerPage innerPage = innerPageRepository.findById(validator.getTypeId()).get();
            Vote vote = voteMapper.set(validator, user);
            voteRepository.save(vote);
            innerPage.addVote(vote);
            innerPageRepository.save(innerPage);

        } else if (validator.getType().equals("InnerTag")) {
            InnerTag innerTag = innerTagRepository.findById(validator.getTypeId()).get();
            Vote vote = voteMapper.set(validator, user);
            voteRepository.save(vote);
            innerTag.addVote(vote);
            innerTagRepository.save(innerTag);
        }

        /*
        if (validator.getType().equals("InnerPage")) {
            if (innerPageRepository.findById(validator.getTypeId()).isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no InnerPage with this typeId");
            }
            vote = voteMapper.set(validator, userRepository.findById(validator.getUserId()).get());
            InnerPage innerPage = innerPageRepository.findById(validator.getTypeId()).get();
            if (!innerPageRepository.hasVoted(validator.getTypeId(), user)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no InnerPage with this typeId"); //dejavoter
            } else {
                if (!innerPage.isFinalState()) {
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
        } else if (validator.getType().equals("InnerParagraph")) {
            if (innerParagraphRepository.findById(validator.getTypeId()).isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no InnerParagraph with this typeId");
            }
            vote = voteMapper.set(validator, userRepository.findById(validator.getUserId()).get());
            InnerParagraph innerParagraph = innerParagraphRepository.findById(validator.getTypeId()).get();
            if (!innerParagraphRepository.hasVoted(validator.getTypeId(), user)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no InnerPage with this typeId"); //dejavoter
            } else {
                if (!innerParagraph.isFinalState()) {
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
        } else if (validator.getType().equals("InnerTag")) {
            if (innerTagRepository.findById(validator.getTypeId()).isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no InnerTag with this typeId");
            }
            vote = voteMapper.set(validator, userRepository.findById(validator.getUserId()).get());
            InnerTag innerTag = innerTagRepository.findById(validator.getTypeId()).get();
            if (!innerTagRepository.hasVoted(validator.getTypeId(), user)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no InnerPage with this typeId"); //dejavoter
            } else {
                if (!innerTag.isFinalState()) {
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
        } else { // TODO 2 nouveau inner a ajouter
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "logique  getType est pas bon");
        }*/
    }

}
