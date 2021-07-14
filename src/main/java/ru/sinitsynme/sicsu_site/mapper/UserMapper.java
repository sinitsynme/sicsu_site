package ru.sinitsynme.sicsu_site.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import ru.sinitsynme.sicsu_site.entity.UserEntity;
import ru.sinitsynme.sicsu_site.rest.dto.UserRegistrationDto;
import ru.sinitsynme.sicsu_site.rest.dto.UserResponseDto;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDto toResponseDto(UserEntity entity);

    @InheritInverseConfiguration
    UserEntity toEntity(UserResponseDto responseDto);

    UserRegistrationDto toRequestDto(UserEntity entity);

    @InheritInverseConfiguration
    UserEntity toEntity(UserRegistrationDto requestDto);

}
