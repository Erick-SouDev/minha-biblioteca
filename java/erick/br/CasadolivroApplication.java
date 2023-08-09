package erick.br;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"erick.br.repository"})
@EntityScan(basePackages = {"erick.br.model"})
public class CasadolivroApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasadolivroApplication.class, args);
	}

}
