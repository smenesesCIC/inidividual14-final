package es.cic.bootcamp.individual14_final;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Individual14FinalApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Individual14FinalApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Individual14FinalApplication.class, args);
	}

}
