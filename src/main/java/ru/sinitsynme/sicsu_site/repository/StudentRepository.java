package ru.sinitsynme.sicsu_site.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import ru.sinitsynme.sicsu_site.entity.StudentEntity;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, UUID> {

    @NonNull
    Optional<StudentEntity> findById(@NonNull UUID id);

    @Query(value = "from StudentEntity where personalData.firstName like concat(:firstNameSymbols, '%')" +
            "and personalData.lastName like concat(:lastNameSymbols, '%') and group.groupFullId like " +
            "concat(:groupFullIdSymbols, '%') order by personalData.lastName")
    Page<StudentEntity> filterStudents(String firstNameSymbols,
                                       String lastNameSymbols, String groupFullIdSymbols);


}
