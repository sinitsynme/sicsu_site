package ru.sinitsynme.sicsu_site.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import ru.sinitsynme.sicsu_site.entity.FacultyEntity;
import ru.sinitsynme.sicsu_site.rest.dto.FacultyRequestDto;
import ru.sinitsynme.sicsu_site.rest.dto.FacultyResponseDto;

@Mapper(componentModel = "spring")
public interface FacultyMapper {

    FacultyResponseDto toResponseDto(FacultyEntity entity);

    @InheritInverseConfiguration
    FacultyEntity toEntity(FacultyResponseDto responseDto);

    FacultyRequestDto toRequestDto(FacultyEntity entity);

    @InheritInverseConfiguration
    FacultyEntity toEntity(FacultyRequestDto requestDto);



}
