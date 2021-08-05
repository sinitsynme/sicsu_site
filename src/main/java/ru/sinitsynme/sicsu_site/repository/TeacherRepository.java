package ru.sinitsynme.sicsu_site.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import ru.sinitsynme.sicsu_site.entity.TeacherEntity;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, UUID> {

    @Query(value = "from TeacherEntity where personalData.firstName like concat(:firstNameSymbols, '%') and " +
            "personalData.lastName like concat(:lastNameSymbols, '%') and department.name like concat(:departmentNameSymbols, '%')" +
            "order by personalData.lastName")
    Page<TeacherEntity> filterTeachers(String firstNameSymbols, String lastNameSymbols,
                                       String departmentNameSymbols);

    @NonNull
    Optional<TeacherEntity> findById(@NonNull UUID id);


}
