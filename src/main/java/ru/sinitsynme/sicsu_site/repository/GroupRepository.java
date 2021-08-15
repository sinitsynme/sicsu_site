package ru.sinitsynme.sicsu_site.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import ru.sinitsynme.sicsu_site.entity.GroupEntity;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, UUID> {

    @Override
    @NonNull
    Optional<GroupEntity> findById(@NonNull UUID uuid);

    Optional<GroupEntity> findByGroupFullId(String groupFullId);

    @Query(value = "select g from GroupEntity g where g.groupFullId like concat('%', :groupFullIdSymbols, '%')")
    Page<GroupEntity> filterGroups(String groupFullIdSymbols, Pageable pageable);

}
