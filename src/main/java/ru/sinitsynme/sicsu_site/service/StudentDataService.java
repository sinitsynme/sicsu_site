package ru.sinitsynme.sicsu_site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.sinitsynme.sicsu_site.entity.Student;
import ru.sinitsynme.sicsu_site.repository.StudentDataRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentDataService {

    private final StudentDataRepository repository;

    @Autowired
    public StudentDataService(
            StudentDataRepository repository) {
        this.repository = repository;
    }

    public Optional<Student> getStudentDataById(Long id) {
        return repository.findById(id);
    }

    public List<Student> getAllStudents() {
        return repository.findAll(Sort.by("lastName"));
    }

    public List<Student> getStudentsByGroup(Long id) {
        return repository.findStudentsByGroup(id);
    }

    public void saveStudentData(Student student) {
        repository.save(student);
    }


}
