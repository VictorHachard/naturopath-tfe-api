package be.heh.app.model.facades.security;

import be.heh.app.model.entities.security.Permission;
import be.heh.app.model.entities.security.UserSecurity;
import be.heh.app.model.entities.security.enumeration.EnumPermission;
import be.heh.app.model.facades.commons.AbstractFacade;
import be.heh.app.model.repositories.security.PermissionRepository;
import be.heh.app.utils.Utils;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Cannot use super for new instance
 */
@Component
//Lombok
@Log
public class UserSecurityFacade extends AbstractFacade<UserSecurity> {

    @Autowired
    PermissionFacade permissionFacade;

    @Autowired
    PermissionRepository permissionRepository;

    public UserSecurity newInstance(String username, String email, String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserSecurity res = new UserSecurity();
        res.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        res.setUsername(username);
        res.setEmail(email);
        res.setPassword(passwordEncoder.encode(password));
        res.setAllEmails(1);
        Permission p = permissionFacade.newInstance(EnumPermission.USER);
        permissionRepository.save(p);
        res.addPermission(p);
        res.setProfilePrivacy(0);
        this.setConfirm(res);
        return res;
    }

    public static UserSecurity build(UserSecurity u) {
        List<GrantedAuthority> authorities = u.getEnumPermissionList().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getEnumPermission().toString()))
                .collect(Collectors.toList());

        UserSecurity res = new UserSecurity();
        res.setId(u.getId());
        res.setUsername(u.getUsername());
        res.setEmail(u.getEmail());
        res.setPassword(u.getPassword());
        res.setEnumPermissionList(u.getEnumPermissionList());
        res.setAuthorities(authorities);
        return res;
    }

    public void setConfirm(UserSecurity userSecurity) {
        userSecurity.setConfirmToken(Utils.generateNewToken(42));//TODO unique
        userSecurity.setConfirmSet(new Timestamp(System.currentTimeMillis()));
        userSecurity.setConfirmedAt(null);
        log.info("Validation token for " + userSecurity.getUsername() + " user : " + userSecurity.getConfirmToken());
    }

    public void confirm(UserSecurity userSecurity) {
        userSecurity.setConfirmedAt(new Timestamp(System.currentTimeMillis()));
        userSecurity.setConfirmToken(null);
        userSecurity.setConfirmSet(null);
    }

    public void setReset(UserSecurity userSecurity) {
        userSecurity.setResetToken(Utils.generateNewToken(42));//TODO unique
        userSecurity.setResetSet(new Timestamp(System.currentTimeMillis()));
        userSecurity.setResetToken(null);
        log.info("Reset token for " + userSecurity.getUsername() + " user : " + userSecurity.getResetToken());
    }

    public void reset(UserSecurity userSecurity, String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userSecurity.setPassword(passwordEncoder.encode(password));
        userSecurity.setResetAt(new Timestamp(System.currentTimeMillis()));
        userSecurity.setResetSet(null);
        userSecurity.setResetToken(null);
    }

    public void setDelete(UserSecurity userSecurity) {
        userSecurity.setDeleteToken(Utils.generateNewToken(42));//TODO unique
        userSecurity.setDeleteSet(new Timestamp(System.currentTimeMillis()));
        log.info("Delete token for " + userSecurity.getUsername() + " user : " + userSecurity.getResetToken());
    }

}
