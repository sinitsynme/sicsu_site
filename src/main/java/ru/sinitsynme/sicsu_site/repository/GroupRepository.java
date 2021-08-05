package ru.sinitsynme.sicsu_site.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.sinitsynme.sicsu_site.entity.GroupEntity;

import java.util.UUID;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, UUID> {

    GroupEntity findByGroupFullId(String groupFullId);

    @Query(value = "from GroupEntity where groupFullId like concat('%', :groupFullIdSymbols, '%') " +
                   "order by groupFullId")
    Page<GroupEntity> filterGroups(String groupFullIdSymbols);

}
