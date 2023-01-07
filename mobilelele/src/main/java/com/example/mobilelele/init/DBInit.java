package com.example.mobilelele.init;

import com.example.mobilelele.model.entity.UserEntity;
import com.example.mobilelele.model.enums.CategoryEnum;
import com.example.mobilelele.model.entity.BrandEntity;
import com.example.mobilelele.model.entity.ModelEntity;
import com.example.mobilelele.repository.BrandRepository;
import com.example.mobilelele.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBInit implements CommandLineRunner {
    private final BrandRepository brandRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public DBInit(BrandRepository brandRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.brandRepository = brandRepository;

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        initializeBrandAndModels();
        initializeUsers();



    }

    private void initializeUsers() {
        if(userRepository.count()==0){
            UserEntity admin=new UserEntity();
            admin.setUsername("admin")
                    .setFirstName("Admin")
                    .setLastName("Adminov")
                    .setPassword(passwordEncoder.encode("test"))
                    .setActive(true);
            userRepository.save(admin);
        }
    }

    private void initializeBrandAndModels(){

        if(brandRepository.count()==0){

            BrandEntity ford=new BrandEntity();
            ford.setName("Ford");
            ModelEntity fiesta=new ModelEntity();
            fiesta.setName("fiesta");
            fiesta.setBrand(ford);
            fiesta.setCategory(CategoryEnum.CAR);
            fiesta.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/a/ac/1996_Ford_Fiesta_1.3_LX_%2813163971835%29.jpg?download");
            fiesta.setStartYear(1976);

            ModelEntity escort=new ModelEntity();
            escort.setName("escort");
            escort.setBrand(ford);
            escort.setCategory(CategoryEnum.CAR);
            escort.setImageUrl("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.supergumi.bg%2Fgumi%2Fza%2Fford%2Fescort&psig=AOvVaw12aD9WZ66wa-q2GsT-SyCZ&ust=1673097602699000&source=images&cd=vfe&ved=0CA8QjRxqFwoTCNjitbSEs_wCFQAAAAAdAAAAABAE");
            escort.setStartYear(1968);
            escort.setEndYear(2002);
            ford.setModels(List.of(fiesta,escort));

            brandRepository.save(ford);
    }
    }
}
