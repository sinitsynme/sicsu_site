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
  //find all by group

  //find by last name
  StudentData findByLastName(String lastName);

  @Override
  @NonNull
  Optional<StudentData> findById(@NonNull Long id);

  @Query(nativeQuery = true, value = "select * from student_data where student_id = ?1")
  Optional<StudentData> findByStudentId(Long studentId);

}
