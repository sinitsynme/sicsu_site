package ru.sinitsynme.sicsu_site.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sinitsynme.sicsu_site.entity.ProgramEntity;

import java.util.UUID;

@Repository
public interface ProgramRepository extends JpaRepository<ProgramEntity, UUID> {
}
