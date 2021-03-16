package ru.sinitsynme.sicsu_site.teacherData.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import ru.sinitsynme.sicsu_site.teacherData.entity.TeacherData;
import ru.sinitsynme.sicsu_site.teacherData.repository.TeacherDataRepository;


@Service
public class TeacherDataService {

  private final TeacherDataRepository teacherDataRepository;

  public TeacherDataService(
      TeacherDataRepository teacherDataRepository) {
    this.teacherDataRepository = teacherDataRepository;
  }

  public Optional<TeacherData> getTeacherById(Long id){
    return teacherDataRepository.findById(id);
  }
}
