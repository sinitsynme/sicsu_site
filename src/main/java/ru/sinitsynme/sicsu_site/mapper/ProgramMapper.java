package ru.sinitsynme.sicsu_site.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import ru.sinitsynme.sicsu_site.entity.ProgramEntity;
import ru.sinitsynme.sicsu_site.rest.dto.ProgramRequestDto;
import ru.sinitsynme.sicsu_site.rest.dto.ProgramResponseDto;

@Mapper(componentModel = "spring", uses = {FacultyMapper.class})
public interface ProgramMapper {

    ProgramResponseDto toResponseDto(ProgramEntity entity);

    @InheritInverseConfiguration
    ProgramEntity toEntity(ProgramResponseDto responseDto);

    ProgramRequestDto toRequestDto(ProgramEntity entity);

    @InheritInverseConfiguration
    ProgramEntity toEntity(ProgramRequestDto requestDto);


}
