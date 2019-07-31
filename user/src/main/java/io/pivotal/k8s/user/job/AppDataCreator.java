package io.pivotal.k8s.user.job;

import com.github.javafaker.Faker;
import io.pivotal.k8s.user.domain.User;
import io.pivotal.k8s.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class AppDataCreator implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        log.debug("Came inside AppDataCreator @", new Date());

        try {
            userRepository.deleteAll();
            log.debug("Cleared old records from Database");

            for (int i = 100; i < 110; i++) {
                Faker faker = new Faker();
                User user = User.builder()
                        .userId(i)
                        .firstName(faker.name().firstName())
                        .lastName(faker.name().lastName())
                        .email(faker.internet().emailAddress())
                        .build();
                userRepository.save(user);
                log.info("Saved : " + user.toString());
            }

        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }
}
