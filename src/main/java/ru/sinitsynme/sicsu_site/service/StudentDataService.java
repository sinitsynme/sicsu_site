package ru.sinitsynme.sicsu_site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.sinitsynme.sicsu_site.entity.StudentData;
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

    public Optional<StudentData> getStudentDataById(Long id) {
        return repository.findById(id);
    }

    public List<StudentData> getAllStudents() {
        return repository.findAll(Sort.by("lastName"));
    }

    public List<StudentData> getStudentsByGroup(Long id) {
        return repository.findStudentsByGroup(id);
    }

    public void saveStudentData(StudentData studentData) {
        repository.save(studentData);
    }


}
