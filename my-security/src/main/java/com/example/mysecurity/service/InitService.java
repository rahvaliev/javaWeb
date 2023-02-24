package com.example.mysecurity.service;

import com.example.mysecurity.model.entity.UserRoleEntity;
import com.example.mysecurity.model.enums.RoleEnum;
import com.example.mysecurity.repository.UserRepository;
import com.example.mysecurity.repository.UserRoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class InitService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    public InitService(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @PostConstruct
    public void init(){
        initRoles();
    };
    private void initRoles(){
        if(userRoleRepository.count()==0){
            var adminRole=new UserRoleEntity().setRole(RoleEnum.ADMIN);
            var moderatorRole=new UserRoleEntity().setRole(RoleEnum.MODERATOR);
            userRoleRepository.save(adminRole);
            userRoleRepository.save(moderatorRole);
        }
    }
}
