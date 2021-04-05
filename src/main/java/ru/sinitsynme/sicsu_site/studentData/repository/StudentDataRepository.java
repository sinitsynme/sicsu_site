package ru.sinitsynme.sicsu_site.studentData.repository;

import java.util.List;
import java.util.Optional;
import javax.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;
import ru.sinitsynme.sicsu_site.studentData.entity.StudentData;

@Repository
public interface StudentDataRepository extends JpaRepository<StudentData, Long> {

  //TEMPORARY!!! Soon add DTOs for transferring only needed data
  @Query(nativeQuery = true, value = "select * from\n"
      + "    (select * from students_groups where group_id=?1) as tb left outer join student_data sd on tb.student_data_id = sd.id")
  List<StudentData> findStudentsByGroup(Long id);

  //find by last name
  StudentData findByLastName(String lastName);

  @Override
  @NonNull
  Optional<StudentData> findById(@NonNull Long id);


}
