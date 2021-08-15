package ru.sinitsynme.sicsu_site.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sinitsynme.sicsu_site.entity.FacultyEntity;
import ru.sinitsynme.sicsu_site.entity.GroupEntity;
import ru.sinitsynme.sicsu_site.entity.ProgramEntity;
import ru.sinitsynme.sicsu_site.exception.ResourceNotFoundException;
import ru.sinitsynme.sicsu_site.mapper.GroupMapper;
import ru.sinitsynme.sicsu_site.rest.dto.GroupRequestDto;
import ru.sinitsynme.sicsu_site.rest.dto.GroupResponseDto;
import ru.sinitsynme.sicsu_site.service.GroupService;
import ru.sinitsynme.sicsu_site.service.entityservice.FacultyEntityService;
import ru.sinitsynme.sicsu_site.service.entityservice.GroupEntityService;
import ru.sinitsynme.sicsu_site.service.entityservice.ProgramEntityService;
import ru.sinitsynme.sicsu_site.util.UtilHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {

    private final GroupMapper groupMapper;
    private final GroupEntityService groupEntityService;
    private final ProgramEntityService programEntityService;
    private final FacultyEntityService facultyEntityService;

    public GroupServiceImpl(GroupMapper groupMapper, GroupEntityService groupEntityService, ProgramEntityService programEntityService, FacultyEntityService facultyEntityService) {
        this.groupMapper = groupMapper;
        this.groupEntityService = groupEntityService;
        this.programEntityService = programEntityService;
        this.facultyEntityService = facultyEntityService;
    }

    @Override
    public GroupResponseDto createGroup(GroupRequestDto requestDto) {
        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setGroupFullId(requestDto.getGroupFullId());
        return groupMapper.toResponseDto(groupEntityService.saveEntity(groupEntity));
    }

    @Override
    public GroupResponseDto editGroup(GroupRequestDto requestDto, UUID groupId) {
        GroupEntity groupFromDb = groupEntityService.getEntity(groupId);
        groupFromDb.setGroupFullId(requestDto.getGroupFullId());
        return groupMapper.toResponseDto(groupEntityService.saveEntity(groupFromDb));
    }

    @Override
    public void deleteGroup(UUID groupId) {
        if(!groupEntityService.existsById(groupId)){
            throw new ResourceNotFoundException(String.format("Group with ID = %s was not found", groupId));
        }
        groupEntityService.deleteEntityById(groupId);
    }


    @Override
    public GroupResponseDto getGroup(UUID groupId) {
        return groupMapper.toResponseDto(groupEntityService.getEntity(groupId));
    }

    @Override
    public GroupResponseDto getGroupByGroupFullId(String groupFullId) {
        return groupMapper.toResponseDto(groupEntityService.findByGroupFullId(groupFullId));
    }

    @Override
    public Page<GroupResponseDto> filterAllGroups(String groupFullIdSymbols) {
        return groupEntityService.filterGroups(groupFullIdSymbols, PageRequest.of(0, 25, Sort.by("groupFullId"))).map(groupMapper::toResponseDto);
    }

    @Override
    public GroupResponseDto addGroupToProgram(UUID groupId, UUID programId) {
        GroupEntity groupEntity = groupEntityService.getEntity(groupId);
        ProgramEntity programEntity = programEntityService.getEntity(programId);
        groupEntity.setProgram(programEntity);
        return groupMapper.toResponseDto(groupEntityService.saveEntity(groupEntity));

    }

    @Override
    public GroupResponseDto removeGroupFromProgram(UUID groupId) {
        GroupEntity groupEntity = groupEntityService.getEntity(groupId);
        groupEntity.setProgram(null);
        return groupMapper.toResponseDto(groupEntityService.saveEntity(groupEntity));
    }


    @Override
    public Page<GroupResponseDto> getAllGroupsFromProgram(UUID programId) {
        ProgramEntity programEntity = programEntityService.getEntity(programId);
        List<GroupEntity> groupEntityList = programEntity.getGroupList();

        return UtilHelper.convertListToPage(groupEntityList, 15, "groupFullId")
                .map(it -> (GroupEntity) it)
                .map(groupMapper::toResponseDto);
    }

    @Override
    public Page<GroupResponseDto> getAllGroupsFromFaculty(UUID facultyId) {
        FacultyEntity facultyEntity = facultyEntityService.getEntity(facultyId);
        List<GroupEntity> groupList = new ArrayList<>();

        facultyEntity.getProgramList().forEach(program -> groupList.addAll(program.getGroupList()));

        return UtilHelper.convertListToPage(groupList, 15, "groupFullId")
                .map(it -> (GroupEntity) it)
                .map(groupMapper::toResponseDto);
    }

    @Override
    public GroupResponseDto moveAllStudentsFromGroupToOtherGroup(UUID currentGroupId, UUID otherGroupId) {
        GroupEntity currentGroup = groupEntityService.getEntity(currentGroupId);
        GroupEntity otherGroup = groupEntityService.getEntity(otherGroupId);

        otherGroup.setStudents(currentGroup.getStudents());
        currentGroup.setStudents(new ArrayList<>());
        groupEntityService.saveEntity(currentGroup);

        return groupMapper.toResponseDto(groupEntityService.saveEntity(otherGroup));
    }

}
