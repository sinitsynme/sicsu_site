package ru.sinitsynme.sicsu_site.service.entityservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.sinitsynme.sicsu_site.entity.UserEntity;
import ru.sinitsynme.sicsu_site.exception.ResourceNotFoundException;
import ru.sinitsynme.sicsu_site.repository.UserRepository;
import ru.sinitsynme.sicsu_site.service.entityservice.UserEntityService;

import java.util.UUID;

@Service
public class UserEntityServiceImpl implements UserEntityService {

    private final UserRepository userRepository;

    @Autowired
    public UserEntityServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity getEntity(UUID uuid) {
        return userRepository
                .findById(uuid)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("User with ID = %s was not found", uuid)));
    }

    @Override
    public UserEntity saveEntity(UserEntity entity) {
        return userRepository.save(entity);
    }

    @Override
    public void deleteEntityById(UUID entityId) {
        userRepository.deleteById(entityId);
    }

    @Override
    public Page<UserEntity> getAllEntities(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public boolean existsById(UUID uuid) {
        return userRepository.existsById(uuid);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(String.format("User with USERNAME = %s wasn't found", username)));
    }
}
