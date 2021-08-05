package ru.sinitsynme.sicsu_site.service;

import ru.sinitsynme.sicsu_site.enums.UserRole;
import ru.sinitsynme.sicsu_site.rest.dto.PersonalDataRequestDto;
import ru.sinitsynme.sicsu_site.rest.dto.UserResponseDto;

import java.util.UUID;

/**
 * Merged with PersonalDataRepository
 */
public interface UserService {

    UserResponseDto saveUser(PersonalDataRequestDto dto, UserRole role);

    UserResponseDto editUser(PersonalDataRequestDto dto, UUID userId);

    UserResponseDto deleteUser(UUID userId);

    boolean tryToChangePassword(UUID userId, String oldPassword, String newPassword);

    void changePassword(UUID userId, String newPassword);

}
