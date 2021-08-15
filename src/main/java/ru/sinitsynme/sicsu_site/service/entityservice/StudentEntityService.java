package ru.sinitsynme.sicsu_site.service.entityservice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.sinitsynme.sicsu_site.entity.GroupEntity;
import ru.sinitsynme.sicsu_site.entity.StudentEntity;

import java.util.UUID;

public interface StudentEntityService extends EntityService<StudentEntity, UUID> {

    Page<StudentEntity> findAllByGroup(GroupEntity groupEntity, Pageable pageable);

    Page<StudentEntity> filterAllStudents(String firstNameSymbols, String lastNameSymbols, String groupFullIdSymbols, Pageable pageable);
}
