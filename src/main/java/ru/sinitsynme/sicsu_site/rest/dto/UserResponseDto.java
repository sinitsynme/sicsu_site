package ru.sinitsynme.sicsu_site.rest.dto;

import ru.sinitsynme.sicsu_site.enums.UserRole;

import java.util.Set;

public class UserResponseDto {

    private String username;

    private String email;

    private boolean isActive;

    private Set<UserRole> userRoleSet;

    private boolean credentialsNonExpired;

    public UserResponseDto() {
    }

    public UserResponseDto(String username, String email, boolean isActive, Set<UserRole> userRoleSet, boolean credentialsNonExpired) {
        this.username = username;
        this.email = email;
        this.isActive = isActive;
        this.userRoleSet = userRoleSet;
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Set<UserRole> getUserRoleSet() {
        return userRoleSet;
    }

    public void setUserRoleSet(Set<UserRole> userRoleSet) {
        this.userRoleSet = userRoleSet;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }
}
