package com.example.mysecurity.service;

import com.example.mysecurity.model.entity.UserEntity;
import com.example.mysecurity.model.entity.UserRoleEntity;
import com.example.mysecurity.model.enums.RoleEnum;
import com.example.mysecurity.repository.UserRepository;
import com.example.mysecurity.repository.UserRoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.stream.Collectors;

@Service
public class InitService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public InitService(UserRepository userRepository, UserRoleRepository userRoleRepository,
                       PasswordEncoder passwordEncoder,
                       @Value("${app.default.password}") String defaultPassword) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init(){
        initRoles();
        initUsers();
    };
    private void initRoles(){
        if(userRoleRepository.count()==0){
            var adminRole=new UserRoleEntity().setRole(RoleEnum.ADMIN);
            var moderatorRole=new UserRoleEntity().setRole(RoleEnum.MODERATOR);
            userRoleRepository.save(adminRole);
            userRoleRepository.save(moderatorRole);
        }
    }
    private void initUsers(){
        if(userRepository.count()==0){
            initAdmin();
            initModerator();
            initNormalUser();
        }
    }
    private void initAdmin(){
        var adminUser=new UserEntity().
                setEmail("admin@example.com").
                setFirstName("Admin")
                .setLastName("Adminov")
                .setPassword(passwordEncoder.encode("topsecret"))
                .setRoles(new HashSet<>(userRoleRepository.findAll()));
        userRepository.save(adminUser);

    }
    private void initModerator(){
        var moderatorUser=new UserEntity().
                setEmail("moderator@example.com").
                setFirstName("Moderator")
                .setLastName("Moderatov")
                .setPassword(passwordEncoder.encode("topsecret"))
                .addRole(userRoleRepository.findUserRoleEntitiesByRole(RoleEnum.MODERATOR).orElseThrow());
        userRepository.save(moderatorUser);
    }
    private void initNormalUser(){
        var user=new UserEntity().
                setEmail("user@example.com").
                setFirstName("User")
                .setLastName("Userov")
                .setPassword(passwordEncoder.encode("topsecret"));
        userRepository.save(user);

    }
}
