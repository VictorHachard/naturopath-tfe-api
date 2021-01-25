package be.heh.app.dto.edit;

import be.heh.app.dto.view.MessageViewDto;
import be.heh.app.dto.view.UserViewDto;
import be.heh.app.dto.view.VoteViewDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
public class InnerParagraphEditDto {

    int id;

    int version;

    int favour;

    int against;

    List<VoteViewDto> voteList;

    List<MessageViewDto> messageList;

    String state;

    UserViewDto user;

    String title;

    String content;

}
