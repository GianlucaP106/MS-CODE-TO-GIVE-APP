package msgroup.gleaningplanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.CommandLinePropertySource;

import msgroup.gleaningplanner.model.Farm;
import msgroup.gleaningplanner.model.Organization;
import msgroup.gleaningplanner.model.Producer;
import msgroup.gleaningplanner.service.FarmService;
import msgroup.gleaningplanner.service.OrganizationService;
import msgroup.gleaningplanner.service.ProducerService;

@SpringBootApplication
public class GleaningplannerApplication {

	@Autowired
	private ProducerService producerService;

	@Autowired
	private OrganizationService organizationService;

	@Autowired
	private FarmService farmService;

	public static void main(String[] args) {
		SpringApplication.run(GleaningplannerApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			Producer prod =	producerService.createProducer(
			"name",
			"lastName",
			"email",
			"producer",
			"password", 
			"123",
			"635 rue du souchet",
			"H7A 4G5",
			"Laval"
			);
			Organization newOrganization = organizationService.createOrganization(
			"org1",
			"password", 
			"orgname", 
			"description", 
			"mission", 
			"image", 
			"7749 George street", 
			"Montreal", 
			"H8P 1C6", 
			10.0, 
			"weblink"
			);
			Farm newFarm = farmService.createFarm(
				prod.getID(),
				"myfarm",
				100.0,
				"Laval",
				"635 rue du souchet",
				"H7A 4G5"
			);
		};
	}

}
