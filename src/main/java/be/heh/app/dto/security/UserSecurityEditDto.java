package be.heh.app.dto.security;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
public class UserSecurityEditDto {

    String username;

    String email;

    String firstName;

    String lastName;

    Date birth;

    Boolean confirmed;

    Boolean isPrivate;

    Boolean dark;

    List<String> roleList;

    List<String> emailList;

}
