package it.cgmconsulting.myblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication
 * prende informazioni dall' app properties
 * si auto configura (in assenza di determinate proprietà nell app properties prende quelle di default)
 */
@SpringBootApplication
public class MyblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyblogApplication.class, args);
	}

}
