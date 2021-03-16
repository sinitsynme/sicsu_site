package ru.sinitsynme.sicsu_site.studentData.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.sinitsynme.sicsu_site.studentData.entity.StudentData;
import ru.sinitsynme.sicsu_site.studentData.repository.StudentDataRepository;

@Service
public class StudentDataService {

  private final StudentDataRepository repository;

  @Autowired
  public StudentDataService(
      StudentDataRepository repository) {
    this.repository = repository;
  }

  public Optional<StudentData> getStudentDataById(Long id){
    return repository.findByStudentId(id);
  }

  public List<StudentData> getAllStudents(){
    return repository.findAll(Sort.by("lastName"));
  }

}
