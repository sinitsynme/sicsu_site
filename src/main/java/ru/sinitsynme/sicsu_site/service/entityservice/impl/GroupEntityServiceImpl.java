package ru.sinitsynme.sicsu_site.service.entityservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.sinitsynme.sicsu_site.entity.GroupEntity;
import ru.sinitsynme.sicsu_site.exception.ResourceNotFoundException;
import ru.sinitsynme.sicsu_site.repository.GroupRepository;
import ru.sinitsynme.sicsu_site.service.entityservice.GroupEntityService;

import java.util.UUID;

@Service
public class GroupEntityServiceImpl implements GroupEntityService {

    private final GroupRepository groupRepository;

    @Autowired
    public GroupEntityServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public GroupEntity getEntity(UUID uuid) {
        return groupRepository.findById(uuid)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Group with ID = %s was not found", uuid)));
    }

    @Override
    public GroupEntity saveEntity(GroupEntity entity) {
        return groupRepository.save(entity);
    }

    @Override
    public void deleteEntityById(UUID entityId) {
        groupRepository.deleteById(entityId);
    }

    @Override
    public Page<GroupEntity> getAllEntities(Pageable pageable) {
        return groupRepository.findAll(pageable);
    }

    @Override
    public boolean existsById(UUID uuid) {
        return groupRepository.existsById(uuid);
    }

    @Override
    public GroupEntity findByGroupFullId(String groupFullId) {
        return groupRepository.findByGroupFullId(groupFullId).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Group with FULL_ID = %s was not found", groupFullId))
        );
    }

    @Override
    public Page<GroupEntity> filterGroups(String groupFullIdSymbols, Pageable pageable) {
        return groupRepository.filterGroups(groupFullIdSymbols, pageable);
    }
}
