package ru.sinitsynme.sicsu_site.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import ru.sinitsynme.sicsu_site.entity.GroupEntity;
import ru.sinitsynme.sicsu_site.rest.dto.GroupRequestDto;
import ru.sinitsynme.sicsu_site.rest.dto.GroupResponseDto;

@Mapper(componentModel = "spring", uses = {FacultyMapper.class})
public interface GroupMapper {

    GroupResponseDto toResponseDto(GroupEntity entity);

    @InheritInverseConfiguration
    GroupEntity toEntity(GroupResponseDto responseDto);

    GroupRequestDto toRequestDto(GroupEntity entity);

    @InheritInverseConfiguration
    GroupEntity toEntity(GroupRequestDto requestDto);

}
