package ru.sinitsynme.sicsu_site.service;

import org.springframework.data.domain.Page;
import ru.sinitsynme.sicsu_site.enums.UserRole;
import ru.sinitsynme.sicsu_site.rest.dto.PersonalDataRequestDto;
import ru.sinitsynme.sicsu_site.rest.dto.UserResponseDto;

import javax.mail.MessagingException;
import java.util.UUID;

/**
 * Merged with PersonalDataRepository
 */
public interface UserService {

    UserResponseDto registerUser(PersonalDataRequestDto dto, UserRole role) throws MessagingException;

    UserResponseDto getUser(UUID userId);

    UserResponseDto editUser(PersonalDataRequestDto dto, UUID userId);

    void deleteUser(UUID userId);

    boolean tryToChangePassword(UUID userId, String oldPassword, String newPassword);

    void changePassword(UUID userId, String newPassword);

}
