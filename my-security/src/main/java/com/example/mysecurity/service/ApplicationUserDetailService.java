package com.example.mysecurity.service;

import com.example.mysecurity.model.entity.UserEntity;
import com.example.mysecurity.model.entity.UserRoleEntity;
import com.example.mysecurity.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class ApplicationUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public ApplicationUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserEntitiesByEmail(username)
                .map(this::map)
                .orElseThrow(()->new UsernameNotFoundException("User with " + username + " not found!"));
    }
    public UserDetails map(UserEntity userEntity){
        return new User(
                userEntity.getEmail(),
                userEntity.getPassword(),
                extractedAuthority(userEntity));

    }
    public List<GrantedAuthority> extractedAuthority(UserEntity userEntity){
       return userEntity.getRoles().stream().map(this::mapRole).toList();
    }

    private GrantedAuthority mapRole(UserRoleEntity userRoleEntity){
        return new SimpleGrantedAuthority("ROLE_"+ userRoleEntity.getRole().toString());
    }
}
