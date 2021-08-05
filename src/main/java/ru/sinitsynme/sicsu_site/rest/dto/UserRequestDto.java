package ru.sinitsynme.sicsu_site.rest.dto;

public class UserRequestDto {

    private String username;

    public UserRequestDto() {
    }

    public UserRequestDto(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
