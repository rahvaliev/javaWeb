package bg.softuni.bulgarianrowingcommunity.service;

import bg.softuni.bulgarianrowingcommunity.model.entity.BaseUserEntity;
import bg.softuni.bulgarianrowingcommunity.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEntityService {
    private final UserEntityRepository userEntityRepository;

    public UserEntityService(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    public List<BaseUserEntity> findAll() {
       return userEntityRepository.findAll();
    }
}
