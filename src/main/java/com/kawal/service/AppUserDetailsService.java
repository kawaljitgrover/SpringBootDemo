package com.kawal.service;

import com.kawal.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.kawal.repo.UserRepository;

import java.util.Arrays;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(s);
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                Arrays.asList(new SimpleGrantedAuthority(user.getRole())));
    }
}
