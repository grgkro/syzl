package de.stuttgart.syzl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class SyzlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SyzlApplication.class, args);
	}

}
