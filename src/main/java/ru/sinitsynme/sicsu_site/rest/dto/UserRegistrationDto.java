package ru.sinitsynme.sicsu_site.rest.dto;

import ru.sinitsynme.sicsu_site.enums.UserRole;

import java.util.Set;

public class UserRegistrationDto {

    private String username;

    private String password;

    private String confirmPassword;

    private String email;

    private Set<UserRole> userRoleSet;

    public UserRegistrationDto() {
    }

    public UserRegistrationDto(String username, String password, String email, Set<UserRole> userRoleSet) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.userRoleSet = userRoleSet;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<UserRole> getUserRoleSet() {
        return userRoleSet;
    }

    public void setUserRoleSet(Set<UserRole> userRoleSet) {
        this.userRoleSet = userRoleSet;
    }
}
