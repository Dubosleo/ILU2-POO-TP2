package controleur;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {

	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlAcheterProduit controlAcheterProduit;

	@BeforeEach
	void setUp() {
		village = new Village("Le village des irréductibles", 10, 5);

		Gaulois asterix = new Gaulois("Asterix", 10);
		Gaulois obelix = new Gaulois("Obelix", 15);
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelix);
		village.installerVendeur(asterix, "potion", 20);
		village.installerVendeur(obelix, "menhir", 5);

		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
	}

	@Test
	void testConstructeur() {
		assertEquals(controlVerifierIdentite, controlAcheterProduit.getControlVerifierIdentite(),
				"Le contrôleur d'identité devrait être initialisé correctement.");
		assertEquals(controlTrouverEtalVendeur, controlAcheterProduit.getControlTrouverEtalVendeur(),
				"Le contrôleur d'étals devrait être initialisé correctement.");
		assertEquals(village, controlAcheterProduit.getVillage(), "Le village devrait être initialisé correctement.");
	}
}
