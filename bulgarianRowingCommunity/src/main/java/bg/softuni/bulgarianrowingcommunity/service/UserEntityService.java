package bg.softuni.bulgarianrowingcommunity.service;

import bg.softuni.bulgarianrowingcommunity.model.entity.BaseUserEntity;
import bg.softuni.bulgarianrowingcommunity.model.entity.RoleEntity;
import bg.softuni.bulgarianrowingcommunity.model.enums.RoleEnums;
import bg.softuni.bulgarianrowingcommunity.repository.RoleEntityRepository;
import bg.softuni.bulgarianrowingcommunity.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserEntityService {
    private final UserEntityRepository userEntityRepository;
    private final RoleEntityRepository roleEntityRepository;

    public UserEntityService(UserEntityRepository userEntityRepository, RoleEntityRepository roleEntityRepository) {
        this.userEntityRepository = userEntityRepository;
        this.roleEntityRepository = roleEntityRepository;
    }

    public List<BaseUserEntity> findAll() {
       return userEntityRepository.findAll();
    }

    public void seed() {
        if(userEntityRepository.count()==0){
            createAdmin();
            createModerator();
        }
    }

    private void createModerator() {
        BaseUserEntity moderator=new BaseUserEntity();
        moderator.setEmail("moderator@rowing.com")
                .setPassword("111")
                .setFullName("MOderator Moderatov")
                .setUsername("moderator")
                .addRole(roleEntityRepository.findRoleEntitiesByRole(RoleEnums.MODERATOR).orElseThrow());
        userEntityRepository.save(moderator);
    }

    private void createAdmin() {
        BaseUserEntity admin=new BaseUserEntity();
        admin.setEmail("admin@rowing.com")
                .setPassword("111")
                .setFullName("Admin Adminov")
                .setUsername("admin")
                .setRoles(new HashSet<RoleEntity>(roleEntityRepository.findAll()));
        userEntityRepository.save(admin);
    }
}
