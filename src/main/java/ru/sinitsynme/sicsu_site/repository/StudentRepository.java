package ru.sinitsynme.sicsu_site.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import ru.sinitsynme.sicsu_site.entity.GroupEntity;
import ru.sinitsynme.sicsu_site.entity.StudentEntity;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, UUID> {

    @NonNull
    Optional<StudentEntity> findById(@NonNull UUID id);

    @Query(value = "select s from StudentEntity s where s.personalData.firstName like concat(:firstNameSymbols, '%')" +
            "and s.personalData.lastName like concat(:lastNameSymbols, '%') and s.group.groupFullId like " +
            "concat(:groupFullIdSymbols, '%')")
    Page<StudentEntity> filterStudents(String firstNameSymbols, String lastNameSymbols,
                                       String groupFullIdSymbols, Pageable pageable);

    Page<StudentEntity> findAllByGroup(GroupEntity groupEntity, Pageable pageable);

}
