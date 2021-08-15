package ru.sinitsynme.sicsu_site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.sinitsynme.sicsu_site.service.entityservice.UserEntityService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserEntityService userEntityService;

    @Autowired
    public UserDetailsServiceImpl(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userEntityService.findByUsername(s);
    }
}
