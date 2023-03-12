package bg.softuni.bulgarianrowingcommunity.service;

import bg.softuni.bulgarianrowingcommunity.model.entity.RoleEntity;
import bg.softuni.bulgarianrowingcommunity.model.enums.RoleEnums;
import bg.softuni.bulgarianrowingcommunity.repository.RoleEntityRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RoleEntityService {
    private final RoleEntityRepository roleEntityRepository;

    public RoleEntityService(RoleEntityRepository roleEntityRepository) {
        this.roleEntityRepository = roleEntityRepository;
    }

    public void seedRole() {
        if(roleEntityRepository.count()==0){
            Arrays.stream(RoleEnums.values())
                    .forEach(roleEnums-> {
                        RoleEntity roleEntity=new RoleEntity();
                        roleEntity.setRole(roleEnums);
                        roleEntityRepository.save(roleEntity);

            });
        }
    }
}
