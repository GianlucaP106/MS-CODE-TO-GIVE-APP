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
			makeProducers();
			makeFarms();
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
				"5149456781",
				"1400 Maisonneuve Blvd",
				"H3G1M8",
				"Montreal"
			);
			Producer prod6 =	producerService.createProducer(
				"Abderrezak",
				"Amimer",
				"Abderrezak.Amimer@HEC.ca",
				"Abder",
				"Amimer", 
				"5144045350",
				"1070 Shevchenko Blvd",
				"H8N 1N6",
				"Montreal"
			);
			Producer prod7 =	producerService.createProducer(
				"Mohammed",
				"Achik",
				"mohamed.achik@gmail.com",
				"momo",
				"achik", 
				"5147891234",
				"4425 Rue de Bellechasse",
				"H1T3S1",
				"Montreal"
			);
	}

	public void makeFarms(){
		Farm newFarm = farmService.createFarm(
			1,
			"Quinn Farm",
			2500.0,
			"ile-perrot",
			"2495 Bd Perrot",
			"J7V8P4"
		);	
		Farm newFarm1 = farmService.createFarm(
			1,
			"Dassonnion",
			3780.0,
			"Longueuil",
			"555 Boulevard Roland-Therrien",
			"J4H3V6"
		);	
		Farm newFarm2 = farmService.createFarm(
			2,
			"Ferme EcoLoko",
			4591.0,
			"Brebeuf",
			"197 Rang des collines",
			"J0T 1B0"
		);	
		Farm newFarm3 = farmService.createFarm(
			2,
			"Ferme des Arpents roses",
			2571.0,
			"Sainte-Melanie",
			"1200 Rang St Albert",
			"J0K3A0"
		);	
		Farm newFarm4 = farmService.createFarm(
			3,
			"Angelic Poultry farm",
			2571.0,
			"Sainte-Melanie",
			"1200 Rang St Albert",
			"J0K3A0"
		);	
		Farm newFarm5 = farmService.createFarm(
			3,
			"Ferme des Arpents roses",
			2571.0,
			"Sainte-Melanie",
			"1200 Rang St Albert",
			"J0K3A0"
		);		
	}
}
