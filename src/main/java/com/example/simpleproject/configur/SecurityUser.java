package com.example.simpleproject.configur;

import com.example.simpleproject.model.UsersTwo;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
public class SecurityUser implements UserDetails {

    private final String username;
    private final String password;
    private final List<GrantedAuthority> grantedAuthorityList ;
    private final boolean isActive;



    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorityList;
    }

    public static UserDetails fromUser(UsersTwo usersTwo) {
        return new User(usersTwo.getEmail(), usersTwo.getPassword(),
                usersTwo.getStatus().equals("ACTIVE"),
                usersTwo.getStatus().equals("ACTIVE"),
                usersTwo.getStatus().equals("ACTIVE"),
                usersTwo.getStatus().equals("ACTIVE"),
                usersTwo.getRole().grantedAuthoritySet()
        );
    }

}
