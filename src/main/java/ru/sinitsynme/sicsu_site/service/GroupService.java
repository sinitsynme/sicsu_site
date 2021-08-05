package ru.sinitsynme.sicsu_site.service;

import org.springframework.data.domain.Page;
import ru.sinitsynme.sicsu_site.rest.dto.GroupRequestDto;
import ru.sinitsynme.sicsu_site.rest.dto.GroupResponseDto;

import java.util.UUID;

public interface GroupService {

    GroupResponseDto createGroup(GroupRequestDto requestDto);

    GroupResponseDto editGroup(GroupRequestDto requestDto, UUID groupId);

    GroupResponseDto deleteGroup(UUID groupId);

    GroupResponseDto getGroup(UUID groupId);

    Page<GroupResponseDto> filterAllGroups(String groupFullIdSymbols);

    GroupResponseDto addGroupToProgram(UUID groupId, UUID programId);

    GroupResponseDto removeGroupFromProgram(UUID groupId);

    Page<GroupResponseDto> getAllGroupsFromProgram(UUID programId);

    Page<GroupResponseDto> getAllGroupsFromFaculty(UUID facultyId);

    GroupResponseDto moveAllStudentsFromGroupToOtherGroup(UUID currentGroupId, UUID otherGroupId);

}
