package com.example.simpleproject.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Roles {
    User(Set.of(Permission.DEVELOPER_READ)),
    Admin(Set.of(Permission.DEVELOPER_READ, Permission.DEVELOPERS_WRITE));

    private final Set<Permission> permissions;

    Roles(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> grantedAuthoritySet(){
      return getPermissions().stream()
              .map(permission -> new SimpleGrantedAuthority(permission.getPermissionName()))
              .collect(Collectors.toSet());
    }
}
