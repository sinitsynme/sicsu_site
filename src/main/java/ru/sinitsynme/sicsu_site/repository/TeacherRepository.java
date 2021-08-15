package ru.sinitsynme.sicsu_site.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import ru.sinitsynme.sicsu_site.entity.TeacherEntity;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, UUID> {

    @Query(value = "select t from TeacherEntity t where t.personalData.firstName like concat(:firstNameSymbols, '%') and " +
            "t.personalData.lastName like concat(:lastNameSymbols, '%') and t.department.name like concat(:departmentNameSymbols, '%')")
    Page<TeacherEntity> filterTeachers(String firstNameSymbols, String lastNameSymbols,
                                       String departmentNameSymbols, Pageable pageable);

    @NonNull
    Optional<TeacherEntity> findById(@NonNull UUID id);


}
