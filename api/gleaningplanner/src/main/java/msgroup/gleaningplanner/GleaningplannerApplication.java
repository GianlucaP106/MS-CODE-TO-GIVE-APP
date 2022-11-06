package msgroup.gleaningplanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

	public void makeProducers(){
			Producer prod1 =	producerService.createProducer(
				"nabil",
				"amimer",
				"nabil.amimer@mail.mcgill.ca",
				"izelhl",
				"someGoodPass", 
				"5148335350",
				"7749 George st",
				"H8P1C6",
				"Montreal"
			);

			Producer prod2 = producerService.createProducer(
				"Parsa",
				"Langari",
				"parsaLangari@mail.mcgill.ca",
				"PLangari",
				"Parsa", 
				"5147072222",
				"635 rue du souchet",
				"H7A 4G5",
				"Laval"
			);

			Producer prod3 =	producerService.createProducer(
				"Gianluca",
				"Piccirilo",
				"gianluca.piccirilo@mail.mcgill.ca",
				"gtpc",
				"gianluca", 
				"4384368797",
				"680 Sherbrooke st",
				"H3A 0B8",
				"Montreal"
			);
			Producer prod4 =	producerService.createProducer(
				"Aditya",
				"Negi",
				"Aditya.Negi@mail.mcgill.ca",
				"NAditya",
				"aditya", 
				"4389267075",
				"5118 Westmore Ave",
				"H4V1Z5",
				"Montreal"
			);
			Producer prod5 =	producerService.createProducer(
				"Jared",
				"Matthews",
				"Jared.Matthew@mail.mcgill.ca",
				"Jared",
				"Matthews", 
				"",
				"635 rue du souchet",
				"H7A 4G5",
				"Laval"
			);
			Producer prod6 =	producerService.createProducer(
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
			Producer prod7 =	producerService.createProducer(
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
	}
}
