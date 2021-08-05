package ru.sinitsynme.sicsu_site.rest.dto;

import ru.sinitsynme.sicsu_site.enums.UserRole;

import java.util.Set;
import java.util.UUID;

public class UserResponseDto {

    private UUID id;

    private PersonalDataResponseDto responseDto;

    private String username;

    private boolean isActive;

    private Set<UserRole> userRoleSet;

    private boolean credentialsNonExpired;

    public UserResponseDto() {
    }

    public UserResponseDto(UUID id, PersonalDataResponseDto responseDto, String username, boolean isActive, Set<UserRole> userRoleSet, boolean credentialsNonExpired) {
        this.id = id;
        this.responseDto = responseDto;
        this.username = username;
        this.isActive = isActive;
        this.userRoleSet = userRoleSet;
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public PersonalDataResponseDto getResponseDto() {
        return responseDto;
    }

    public void setResponseDto(PersonalDataResponseDto responseDto) {
        this.responseDto = responseDto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
