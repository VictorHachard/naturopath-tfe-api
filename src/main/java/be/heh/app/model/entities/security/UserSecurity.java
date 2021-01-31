package be.heh.app.model.entities.security;

import be.heh.app.model.entities.app.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
// Lombok
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class UserSecurity implements Serializable, UserDetails {

    @Id
    @GeneratedValue
    int id;

    @OneToOne
    User user;

    @Column(name = "username", unique = true, nullable = false)
    String username;

    @Column(name = "email", unique = true, nullable = false)
    String email;

    @Column(name = "password", nullable = false)
    String password;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "birth")
    @Temporal(TemporalType.DATE)
    Date birth;

    @Column(name = "confirm_token", unique = true)
    String confirmToken;

    @Column(name = "confirm_set")
    @Temporal(TemporalType.TIMESTAMP)
    Date confirmSet;

    @Column(name = "confirmed_at")
    @Temporal(TemporalType.TIMESTAMP)
    Date confirmedAt;

    @Column(name = "reset_token", unique = true)
    String resetToken;

    @Column(name = "reset_set")
    @Temporal(TemporalType.TIMESTAMP)
    Date resetSet;

    @Column(name = "reset_at")
    @Temporal(TemporalType.TIMESTAMP)
    Date resetAt;

    @Column(name = "delete_token", unique = true)
    String deleteToken;

    @Column(name = "delete_set")
    @Temporal(TemporalType.TIMESTAMP)
    Date deleteSet;

    @ManyToMany(fetch = FetchType.EAGER)
    Set<Role> enumPermissionList = new HashSet<>();

    @Column(name = "all_emails")
    int allEmails; // 0 - no, 1 - yes

    @Column(name = "accept_terms")
    int acceptTerms;

    @Column(name = "last_connection")
    @Temporal(TemporalType.TIMESTAMP)
    Date lastConnection;

    @Column(name = "profile_privacy")
    int profilePrivacy; // 0 - private, 1 - public

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    Date createdAt;

    public void addPermission(Role... p) {
        enumPermissionList.addAll(Arrays.asList(p));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();
        enumPermissionList.forEach(permission -> {
            list.add(new SimpleGrantedAuthority(permission.getName().name()));
        });
        return list;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
