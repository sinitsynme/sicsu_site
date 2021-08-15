package ru.sinitsynme.sicsu_site.service.entityservice;

import ru.sinitsynme.sicsu_site.entity.UserEntity;

import java.util.UUID;

public interface UserEntityService extends EntityService<UserEntity, UUID> {

    UserEntity findByUsername(String username);

}
