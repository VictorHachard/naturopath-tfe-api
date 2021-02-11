package be.heh.app.dto.view;

import be.heh.app.dto.security.UserSecuritySimplifiedViewDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
public class TicketContentViewDto {

    int id;

    Date createdAt;

    UserSecuritySimplifiedViewDto userSecurity;

    String content;

}
