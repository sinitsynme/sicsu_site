package ru.sinitsynme.sicsu_site.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import ru.sinitsynme.sicsu_site.entity.UserEntity;
import ru.sinitsynme.sicsu_site.rest.dto.UserRequestDto;
import ru.sinitsynme.sicsu_site.rest.dto.UserResponseDto;

@Mapper(componentModel = "spring", uses = {PersonalDataMapper.class})
public interface UserMapper {

    UserResponseDto toResponseDto(UserEntity entity);

    @InheritInverseConfiguration
    UserEntity toEntity(UserResponseDto responseDto);

    UserRequestDto toRequestDto(UserEntity entity);

    @InheritInverseConfiguration
    UserEntity toEntity(UserRequestDto requestDto);


}
