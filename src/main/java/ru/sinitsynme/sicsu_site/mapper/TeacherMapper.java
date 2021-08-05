package ru.sinitsynme.sicsu_site.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import ru.sinitsynme.sicsu_site.entity.TeacherEntity;
import ru.sinitsynme.sicsu_site.rest.dto.TeacherRequestDto;
import ru.sinitsynme.sicsu_site.rest.dto.TeacherResponseDto;

@Mapper(componentModel = "spring", uses = {DepartmentMapper.class, PersonalDataMapper.class})
public interface TeacherMapper {

    TeacherResponseDto toResponseDto(TeacherEntity entity);

    @InheritInverseConfiguration
    TeacherEntity toEntity(TeacherResponseDto responseDto);

    TeacherRequestDto toRequestDto(TeacherEntity entity);

    @InheritInverseConfiguration
    TeacherEntity toEntity(TeacherRequestDto requestDto);

}
