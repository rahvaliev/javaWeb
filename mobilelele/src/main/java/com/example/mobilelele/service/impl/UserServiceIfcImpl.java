package com.example.mobilelele.service.impl;

import com.example.mobilelele.model.entity.UserEntity;
import com.example.mobilelele.model.entity.UserRoleEntity;
import com.example.mobilelele.model.enums.UserRoleEnum;
import com.example.mobilelele.model.service.UserLoginServiceModel;
import com.example.mobilelele.model.service.UserRegistrationServiceModel;
import com.example.mobilelele.repository.UserRepository;
import com.example.mobilelele.repository.UserRoleRepository;
import com.example.mobilelele.service.UserServiceIfc;
import com.example.mobilelele.userSession.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceIfcImpl implements UserServiceIfc {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final UserRoleRepository userRoleRepository;


    public UserServiceIfcImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, CurrentUser currentUser, UserRoleRepository userRoleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;

        this.userRoleRepository = userRoleRepository;
    }




    @Override
    public boolean login(UserLoginServiceModel userLoginServiceModel) {
        Optional<UserEntity> userEntityOpt = userRepository.findByUsername(userLoginServiceModel.getUsername());
        if(userEntityOpt.isEmpty()){
            logout();
            return false;
        }else {
           boolean success= passwordEncoder.matches(userLoginServiceModel.getPassword(), userEntityOpt.get().getPassword());
           if(success){
               UserEntity loggedInUser=userEntityOpt.get();
             login(loggedInUser);
           }
           return success;
        }

    }

    @Override
    public void logout() {
        currentUser.clear();
    }

    @Override
    public void registerAndLoginUser(UserRegistrationServiceModel userRegistrationServiceModel) {
        UserRoleEntity userRole= userRoleRepository.findByRole(UserRoleEnum.USER);

        UserEntity newUser=new UserEntity();
        newUser.setUsername(userRegistrationServiceModel.getUsername())
                .setFirstName(userRegistrationServiceModel.getFirstName())
                .setLastName(userRegistrationServiceModel.getLastName())
                .setPassword(passwordEncoder.encode(userRegistrationServiceModel.getPassword()))
                .setActive(true)
                .setRoles(List.of(userRole));
       newUser= userRepository.save(newUser);
       login(newUser);


    }

    private void login(UserEntity user){
        currentUser
                .setLoggedIn(true)
                .setUsername(user.getUsername())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName());

        user.getRoles().forEach(r->currentUser.addRole(r.getRole()));

    }

    @Override
    public boolean isUsernameFree(String username) {

     return    userRepository.findByUsernameIgnoreCase(username).isEmpty();

    }
}
