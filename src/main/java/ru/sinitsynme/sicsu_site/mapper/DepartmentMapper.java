package ru.sinitsynme.sicsu_site.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import ru.sinitsynme.sicsu_site.entity.DepartmentEntity;
import ru.sinitsynme.sicsu_site.rest.dto.DepartmentRequestDto;
import ru.sinitsynme.sicsu_site.rest.dto.DepartmentResponseDto;

@Mapper(componentModel = "spring", uses = {FacultyMapper.class})
public interface DepartmentMapper {

    DepartmentResponseDto toResponseDto(DepartmentEntity department);

    @InheritInverseConfiguration
    DepartmentEntity toEntity(DepartmentResponseDto responseDto);

    DepartmentRequestDto toRequestDto(DepartmentEntity departmentEntity);

    @InheritInverseConfiguration
    DepartmentEntity toEntity(DepartmentRequestDto departmentRequestDto);
}
