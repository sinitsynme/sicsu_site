package ru.sinitsynme.sicsu_site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sinitsynme.sicsu_site.mapper.GroupMapper;
import ru.sinitsynme.sicsu_site.repository.GroupRepository;
import ru.sinitsynme.sicsu_site.rest.dto.GroupRequestDto;
import ru.sinitsynme.sicsu_site.rest.dto.GroupResponseDto;
import ru.sinitsynme.sicsu_site.service.GroupService;

import java.util.UUID;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {

    private final GroupMapper groupMapper;
    private final GroupRepository groupRepository;

    @Autowired
    public GroupServiceImpl(GroupMapper groupMapper, GroupRepository groupRepository) {
        this.groupMapper = groupMapper;
        this.groupRepository = groupRepository;
    }

    @Override
    public GroupResponseDto createGroup(GroupRequestDto requestDto) {
        return null;
    }

    @Override
    public GroupResponseDto editGroup(GroupRequestDto requestDto, UUID groupId) {
        return null;
    }

    @Override
    public GroupResponseDto deleteGroup(UUID groupId) {
        return null;
    }

    @Override
    public GroupResponseDto getGroup(UUID groupId) {
        return null;
    }

    @Override
    public Page<GroupResponseDto> filterAllGroups(String groupFullIdSymbols) {
        return null;
    }

    @Override
    public GroupResponseDto addGroupToProgram(UUID groupId, UUID programId) {
        return null;
    }

    @Override
    public GroupResponseDto removeGroupFromProgram(UUID groupId) {
        return null;
    }

    @Override
    public Page<GroupResponseDto> getAllGroupsFromProgram(UUID programId) {
        return null;
    }

    @Override
    public Page<GroupResponseDto> getAllGroupsFromFaculty(UUID facultyId) {
        return null;
    }

    @Override
    public GroupResponseDto moveAllStudentsFromGroupToOtherGroup(UUID currentGroupId, UUID otherGroupId) {
        return null;
    }
}
