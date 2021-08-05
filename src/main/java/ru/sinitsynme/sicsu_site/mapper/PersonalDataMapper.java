package ru.sinitsynme.sicsu_site.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import ru.sinitsynme.sicsu_site.entity.PersonalDataEntity;
import ru.sinitsynme.sicsu_site.rest.dto.PersonalDataRequestDto;
import ru.sinitsynme.sicsu_site.rest.dto.PersonalDataResponseDto;

@Mapper(componentModel = "spring")
public interface PersonalDataMapper {

    PersonalDataResponseDto toResponseDto(PersonalDataEntity entity);

    @InheritInverseConfiguration
    PersonalDataEntity toEntity(PersonalDataResponseDto responseDto);

    PersonalDataRequestDto toRequestDto(PersonalDataEntity entity);

    @InheritInverseConfiguration
    PersonalDataEntity toEntity(PersonalDataRequestDto requestDto);

}
