package ru.sinitsynme.sicsu_site.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import ru.sinitsynme.sicsu_site.entity.TeacherData;

import java.util.Optional;

@Repository
public interface TeacherDataRepository extends JpaRepository<TeacherData, Long> {

    //find all by groupId

    //find by discipline (later)

    //find by last name

    @NonNull
    Optional<TeacherData> findById(@NonNull Long id);


}
