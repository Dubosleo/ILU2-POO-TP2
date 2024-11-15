package controleur;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {

	private Village village;
	private ControlAfficherMarche controlAfficherMarche;

	@BeforeEach
	void setUp() {
		village = new Village("Le village des irréductibles", 10, 5);

		Gaulois asterix = new Gaulois("Asterix", 10);
		Gaulois obelix = new Gaulois("Obelix", 15);
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelix);

		village.installerVendeur(asterix, "potion", 20);
		village.installerVendeur(obelix, "menhir", 5);

		controlAfficherMarche = new ControlAfficherMarche(village);
	}

	@Test
	void testConstructeur() {

		assertNotNull(controlAfficherMarche, "Le contrôleur devrait être initialisé.");
	}

	@Test
	void testDonnerInfosMarche() {

		String[] infosAttendues = { "Asterix", "20", "potion", "Obelix", "5", "menhir" };
		String[] infosMarche = controlAfficherMarche.donnerinfosmarche();

		assertArrayEquals(infosAttendues, infosMarche, "Les informations du marché doivent correspondre.");
	}
}
