package ru.sinitsynme.sicsu_site.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import ru.sinitsynme.sicsu_site.entity.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentDataRepository extends JpaRepository<Student, Long> {

    //TEMPORARY!!! Soon add DTOs for transferring only needed data
    @Query(nativeQuery = true, value = "select * from\n"
            + "    (select * from students_groups where group_id=?1) as tb left outer join student_data sd on tb.student_data_id = sd.id")
    List<Student> findStudentsByGroup(Long id);

    //find by last name
    Student findByLastName(String lastName);

    @Override
    @NonNull
    Optional<Student> findById(@NonNull Long id);


}
