package msgroup.gleaningplanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import msgroup.gleaningplanner.service.FarmService;
import msgroup.gleaningplanner.service.OrganizationService;
import msgroup.gleaningplanner.service.ProducerService;
import msgroup.gleaningplanner.service.VolunteerService;

@SpringBootApplication
public class GleaningplannerApplication {

	@Autowired
	private VolunteerService volunteerService;

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
			makeVolunteers();
			makeProducers();
			makeFarms();
			makeOrganization();
		};
	}

	public void makeOrganization(){
		organizationService.createOrganization(
			"org1",
			"org1", 
			"Fruit et Rangs a partager", 
			"Page de la MRC de La Matanie dédiée à outiller sur la gestion des MR et l'environnement", 
			"dédiée à l'environnement", 
			"image", 
			"", 
			"Sherbrooke", 
			"", 
			100,
			"", 
			"4185626734"
		);
	}

	public void makeVolunteers(){
		volunteerService.createVolunteer(
			"Matthew",
			"Carbal",
			"Matthew.Carbal@mail.mcgill.ca",
			"Matt",
			"Carbal", 
			"5341654789",
			"2595 Rue Fleury E",
			"H2B1L7",
			"Montreal"
		);
		volunteerService.createVolunteer(
			"Sadek",
			"Mahmood",
			"Sadek.Mahmood@mail.mcgill.ca",
			"Sadek",
			"Mahmood", 
			"7894561231",
			"1425 Boul Henri-Bourassa E",
			"H2C1H1",
			"Montreal"
		);
		volunteerService.createVolunteer(
			"Jasmine",
			"Taggat",
			"Jasmine.Taggat@mail.mcgill.ca",
			"Jasmine",
			"Taggat", 
			"5147831456",
			"123 Boul des Prairies",
			"H7N2T6",
			"Laval"
		);
		volunteerService.createVolunteer(
			"Sadia",
			"Boudjelal",
			"Sadia.Boudjelal@mail.mcgill.ca",
			"Sadia",
			"Boudjelal", 
			"5149363855",
			"7749 George st",
			"H8P1C6",
			"Montreal"
		);
		volunteerService.createVolunteer(
			"Mohammed",
			"Amimer",
			"Mohammed.Amimer@mail.mcgill.ca",
			"Mohammed",
			"Amimer", 
			"5141597534",
			"3532 Bd de la Concorde E",
			"H7E2C4",
			"Laval"
		);
	}

	public void makeProducers(){
		producerService.createProducer(
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

		producerService.createProducer(
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

		producerService.createProducer(
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
		producerService.createProducer(
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
		producerService.createProducer(
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
		producerService.createProducer(
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
		producerService.createProducer(
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
		farmService.createFarm(
			1,
			"Quinn Farm",
			2500.0,
			"ile-perrot",
			"2495 Bd Perrot",
			"J7V8P4"
		);	
		farmService.createFarm(
			2,
			"Dassonnion",
			3780.0,
			"Longueuil",
			"555 Boulevard Roland-Therrien",
			"J4H3V6"
		);	
		farmService.createFarm(
			3,
			"Ferme EcoLoko",
			4591.0,
			"Brebeuf",
			"197 Rang des collines",
			"J0T 1B0"
		);	
		farmService.createFarm(
			4,
			"Ferme des Arpents roses",
			2571.0,
			"Sainte-Melanie",
			"1200 Rang St Albert",
			"J0K3A0"
		);	
		farmService.createFarm(
			5,
			"Angelic Poultry farm",
			2571.0,
			"Saint-Cuthbert",
			"2320 Rue Principale",
			"J0K2C0"
		);	
		farmService.createFarm(
			6,
			"Farme Ste-Sophie Inc",
			1250.0,
			"Sainte-Sophie-de-levrard",
			"115 Rang St-Antoine",
			"G0X3C0"
		);		
	}

	
}
