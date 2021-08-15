package ru.sinitsynme.sicsu_site.service.entityservice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.sinitsynme.sicsu_site.entity.TeacherEntity;

import java.util.UUID;

public interface TeacherEntityService extends EntityService<TeacherEntity, UUID> {

    Page<TeacherEntity> filterTeachers(String firstNameSymbols, String lastNameSymbols,
                                       String departmentNameSymbols, Pageable pageable);

}
