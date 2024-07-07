package bg.softuni.mobilelele.init;

import bg.softuni.mobilelele.model.entity.Role;
import bg.softuni.mobilelele.model.enums.RoleEnum;
import bg.softuni.mobilelele.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class RoleInit implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public RoleInit(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) {
        if (roleRepository.count() == 0) {
            Arrays.stream(RoleEnum.values())
                    .forEach(role -> roleRepository.saveAndFlush(new Role(role)));
        }
    }
}
