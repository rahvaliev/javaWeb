package bg.softuni.bulgarianrowingcommunity;

import bg.softuni.bulgarianrowingcommunity.service.UserEntityService;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CLR implements CommandLineRunner {
    private final UserEntityService userEntityService;

    public CLR(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("hello rowing community!");
        userEntityService.findAll().stream()
                .forEach(baseUserEntity -> {
                    System.out.println(baseUserEntity.getUsername()+" "+baseUserEntity.getEmail());
                });
        StringBuilder sb=new StringBuilder();
        userEntityService.findAll().stream()
                .forEach(baseUserEntity -> {

                    sb
                            .append(baseUserEntity.getUsername()).append("\n")
                            .append(baseUserEntity.getFullName())
                            .append(System.lineSeparator())
                            .append("-------------------")
                            .append(System.lineSeparator());

                    baseUserEntity.getRoles().forEach(roleEntity -> {
                        sb.append(roleEntity.getRole().name()+" ");
                    });
                    sb.append(System.lineSeparator()).append("**********************");
                    sb.append(System.lineSeparator());

                });
        System.out.println(sb.toString());

    }
}
