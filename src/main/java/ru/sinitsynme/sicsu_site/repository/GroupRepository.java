package ru.sinitsynme.sicsu_site.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sinitsynme.sicsu_site.entity.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    Group findByGroupFullId(String groupFullId);

}
