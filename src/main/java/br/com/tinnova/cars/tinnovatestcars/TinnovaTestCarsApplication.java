package br.com.tinnova.cars.tinnovatestcars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class TinnovaTestCarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TinnovaTestCarsApplication.class, args);
	}

}
