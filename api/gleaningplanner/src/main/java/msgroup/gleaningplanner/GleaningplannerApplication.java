package msgroup.gleaningplanner;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import msgroup.gleaningplanner.service.EventService;
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

	@Autowired
	private EventService eventService;

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
			makeEvents();
			makeComments();
		};
	}


	public void makeOrganization(){
		organizationService.createOrganization(
			"org1", 
			"org1",
			"Environment Matanie",
			"Page de la MRC de La Matanie dédiée à outiller sur la gestion des MR et l'environnement",
			"dédiée à l'environnement",
			null,
			"Bas-Saint-Laurent",
			"La Matanie", 
			null, 
			150.0, 
			"https://www.mrcdematane.qc.ca/accueil.html", 
			"4185626734"	
		);
		organizationService.createOrganization(
			"org2", 
			"org2",
			"Les Fruits Partagés",
			"Les Fruits Partagés ont pour but d'approvisionner Moisson Rimouski-Neigette en fruits et légumes tout en réduisant le gaspillage alimentaire sur le territoire de la MRC.",
			"",
			null,
			"99-A rue de l'eveche",
			"Rimouski", 
			"G5L1X7", 
			150.0, 
			"http://moissonrimouski.org/les-fruits-partages", 
			"4183186013"	
		);
		organizationService.createOrganization(
			"org3", 
			"org3",
			"Artha-Recolte",
			"",
			"",
			null,
			"747 Pierre-Roux Blv",
			"Victoriaville", 
			"G6T1S7", 
			200.0, 
			"https://www.artharecolte.com/", 
			"8193525001"	
		);
		organizationService.createOrganization(
			"org4", 
			"org4",
			"Meilleur Apres",
			"Entreprise d'économie sociale en sécurité alimentaire pour un système alimentaire viable et durable.",
			"",
			null,
			"350 Rie Notre Dame",
			"Notre-Dame-du-bon-conseil", 
			"J0C1A0", 
			200.0, 
			"https://meilleurapres.ca/", 
			"8194611303"	
		);
		organizationService.createOrganization(
			"org5", 
			"org5",
			"Les Butineurs",
			"La mission des Butineurs est de récolter et de partager les surplus de fruits et de légumes.",
			"",
			null,
			"255 Rue Collard",
			"Alma", 
			"G8B 1M8", 
			200.0, 
			"https://lesbutineurs.ca/",
			"4183196087"	
		);
		organizationService.createOrganization(
			"org6", 
			"org6",
			"Champ D'Action - Project collectif en securite alimentaire",
			"",
			"",
			null,
			"79, Rue Wellington Nord",
			"Sherbrooke", 
			"J1H589", 
			200.0, 
			"https://www.entreprendresherbrooke.com/",
			"8195631144"	
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
			"3532 Concorde E",
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

	public void makeEvents() {
		eventService.createEvent(
			"national Gleaning Event day ", 
			10, 
			15, 
			"Gleaning is everyone's passion in these dire times", 
			false, 
			1, 
			Date.from(Instant.now())
		);

		eventService.createEvent(
			"Gleaning for all", 
			11, 
			12, 
			"Come for a fun time of gleaning. All the food will be donated to a chirtable org.", 
			false, 
			1, 
			Date.from(Instant.now())
		);

		eventService.createEvent(
			"Gleaning today.", 
			11, 
			12, 
			"COme help us fetch food for the people who need it the most!! ", 
			false, 
			1, 
			Date.from(Instant.now())
		);

		eventService.createEvent(
			"Regional Gleaning Event", 
			11, 
			12, 
			"A regional gleaning event for all", 
			false, 
			1, 
			Date.from(Instant.now())
		);

		eventService.createEvent(
			"national Gleaning Event day ", 
			10, 
			15, 
			"Gleaning is everyone's passion in these dire times", 
			false, 
			2, 
			Date.from(Instant.now())
		);

		eventService.createEvent(
			"Gleaning for all", 
			11, 
			12, 
			"Come for a fun time of gleaning. All the food will be donated to a chirtable org.", 
			false, 
			2, 
			Date.from(Instant.now())
		);

		eventService.createEvent(
			"Gleaning today.", 
			11, 
			12, 
			"COme help us fetch food for the people who need it the most!! ", 
			false, 
			2, 
			Date.from(Instant.now())
		);

		eventService.createEvent(
			"Regional Gleaning Event", 
			11, 
			12, 
			"A regional gleaning event for all", 
			false, 
			2, 
			Date.from(Instant.now())
		);

		eventService.createEvent(
			"national Gleaning Event day ", 
			10, 
			15, 
			"Gleaning is everyone's passion in these dire times", 
			false, 
			3, 
			Date.from(Instant.now())
		);

		eventService.createEvent(
			"Gleaning for all", 
			11, 
			12, 
			"Come for a fun time of gleaning. All the food will be donated to a chirtable org.", 
			false, 
			3, 
			Date.from(Instant.now())
		);

		eventService.createEvent(
			"Gleaning today.", 
			11, 
			12, 
			"COme help us fetch food for the people who need it the most!! ", 
			false, 
			3, 
			Date.from(Instant.now())
		);

		eventService.createEvent(
			"Regional Gleaning Event", 
			11, 
			12, 
			"A regional gleaning event for all", 
			false, 
			3, 
			Date.from(Instant.now())
		);

		eventService.createEvent(
			"national Gleaning Event day ", 
			10, 
			15, 
			"Gleaning is everyone's passion in these dire times", 
			false, 
			4, 
			Date.from(Instant.now())
		);

		eventService.createEvent(
			"Gleaning for all", 
			11, 
			12, 
			"Come for a fun time of gleaning. All the food will be donated to a chirtable org.", 
			false, 
			4, 
			Date.from(Instant.now())
		);

		eventService.createEvent(
			"Gleaning today.", 
			11, 
			12, 
			"COme help us fetch food for the people who need it the most!! ", 
			false, 
			4, 
			Date.from(Instant.now())
		);

		eventService.createEvent(
			"Regional Gleaning Event", 
			11, 
			12, 
			"A regional gleaning event for all", 
			false, 
			4, 
			Date.from(Instant.now())
		);

		eventService.createEvent(
			"national Gleaning Event day ", 
			10, 
			15, 
			"Gleaning is everyone's passion in these dire times", 
			false, 
			5, 
			Date.from(Instant.now())
		);

		eventService.createEvent(
			"Gleaning for all", 
			11, 
			12, 
			"Come for a fun time of gleaning. All the food will be donated to a chirtable org.", 
			false, 
			5, 
			Date.from(Instant.now())
		);

		eventService.createEvent(
			"Gleaning today.", 
			11, 
			12, 
			"COme help us fetch food for the people who need it the most!! ", 
			true, 
			5, 
			Date.from(Instant.now())
		);

		eventService.createEvent(
			"Regional Gleaning Event", 
			11, 
			12, 
			"A regional gleaning event for all", 
			false, 
			5, 
			Date.from(Instant.now())
		);

		eventService.createEvent(
			"national Gleaning Event day ", 
			10, 
			15, 
			"Gleaning is everyone's passion in these dire times", 
			false, 
			6, 
			Date.from(Instant.now())
		);

		eventService.createEvent(
			"Gleaning for all", 
			11, 
			12, 
			"Come for a fun time of gleaning. All the food will be donated to a chirtable org.", 
			true, 
			6, 
			Date.from(Instant.now())
		);

		eventService.createEvent(
			"Gleaning today.", 
			11, 
			12, 
			"COme help us fetch food for the people who need it the most!! ", 
			false, 
			6, 
			Date.from(Instant.now())
		);

		eventService.createEvent(
			"Regional Gleaning Event", 
			11, 
			12, 
			"A regional gleaning event for all", 
			false, 
			6, 
			Date.from(Instant.now())
		);
	}

	public void makeComments() {
		producerService.postCommentEvent(
			1, 
			1, 
			"first comment",
			"PRODUCER"
		);
		producerService.postCommentEvent(
			2, 
			1, 
			"second comment",
			"PRODUCER"
		);
		producerService.postCommentEvent(
			2, 
			2, 
			"third comment",
			"VOLUNTEER"
		);
		producerService.postCommentEvent(
			2, 
			1, 
			"fourth comment",
			"VOLUNTEER"
		);
	}
	
	public void registerOrganizations(){
		organizationService.registerToEvent(
			1, 
			1
		);
		organizationService.registerToEvent(
			2, 
			2
		);
		organizationService.registerToEvent(
			3, 
			2
		);
		organizationService.registerToEvent(
			3, 
			3
		);
		organizationService.registerToEvent(
			4, 
			4
		);
		organizationService.registerToEvent(
			5,
			6
		);
		organizationService.registerToEvent(
			6,
			6
		);
		organizationService.registerToEvent(
			5,
			7
		);
		organizationService.registerToEvent(
			4,
			12
		);
		organizationService.registerToEvent(
			3,
			9
		);
	}
}
