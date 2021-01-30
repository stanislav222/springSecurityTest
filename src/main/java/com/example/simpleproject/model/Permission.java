package com.example.simpleproject.model;

public enum Permission {


    DEVELOPER_READ("developers:read"),
    DEVELOPERS_WRITE("developers:write");

    private final String permissionName;

    public String getPermissionName() {
        return permissionName;
    }

     Permission(String permissionName) {
        this.permissionName = permissionName;
    }
}
