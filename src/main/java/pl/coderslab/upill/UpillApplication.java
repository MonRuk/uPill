package pl.coderslab.upill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories//czy to na pewno jest potrzebne?
public class UpillApplication {

    public static void main(String[] args) {
        SpringApplication.run(UpillApplication.class, args);
    }

}
