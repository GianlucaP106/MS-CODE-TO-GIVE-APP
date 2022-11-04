package msgroup.gleaningplanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.CommandLinePropertySource;

@SpringBootApplication
public class GleaningplannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GleaningplannerApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("before app");

		};
	}

}
