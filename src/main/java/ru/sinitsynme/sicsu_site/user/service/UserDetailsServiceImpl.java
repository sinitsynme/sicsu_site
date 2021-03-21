package ru.sinitsynme.sicsu_site.user.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.sinitsynme.sicsu_site.user.repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;


  public UserDetailsServiceImpl(
      UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    return userRepository.findByUsername(s);
  }


}
