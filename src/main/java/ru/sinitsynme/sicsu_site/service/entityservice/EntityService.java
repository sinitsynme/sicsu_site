package ru.sinitsynme.sicsu_site.service.entityservice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface EntityService<T, ID> {

    T getEntity(ID id);

    T saveEntity(T entity);

    void deleteEntityById(UUID entityId);

    Page<T> getAllEntities(Pageable pageable);

    boolean existsById(ID id);

}
