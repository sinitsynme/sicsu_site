package ru.sinitsynme.sicsu_site.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import ru.sinitsynme.sicsu_site.entity.GroupEntity;
import ru.sinitsynme.sicsu_site.entity.StudentEntity;
import ru.sinitsynme.sicsu_site.rest.dto.GroupRequestDto;
import ru.sinitsynme.sicsu_site.rest.dto.GroupResponseDto;
import ru.sinitsynme.sicsu_site.rest.dto.StudentRequestDto;
import ru.sinitsynme.sicsu_site.rest.dto.StudentResponseDto;

@Mapper(uses = {GroupMapper.class, PersonalDataMapper.class}, componentModel = "spring")
public interface StudentMapper {

    StudentResponseDto toResponseDto(StudentEntity entity);

    @InheritInverseConfiguration
    StudentEntity toEntity(StudentResponseDto responseDto);

    StudentRequestDto toRequestDto(StudentEntity entity);

    @InheritInverseConfiguration
    StudentEntity toEntity(StudentRequestDto requestDto);

}
