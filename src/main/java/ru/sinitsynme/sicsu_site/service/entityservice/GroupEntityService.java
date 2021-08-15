package ru.sinitsynme.sicsu_site.service.entityservice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.sinitsynme.sicsu_site.entity.GroupEntity;

import java.util.UUID;

public interface GroupEntityService extends EntityService<GroupEntity, UUID> {

    GroupEntity findByGroupFullId(String groupFullId);

    Page<GroupEntity> filterGroups(String groupFullIdSymbols, Pageable pageable);
}
