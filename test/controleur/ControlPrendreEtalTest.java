package controleur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {

	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlPrendreEtal controlPrendreEtal;

	@BeforeEach
	void setUp() {
		// Initialisation du village avec un nombre maximal d'habitants et de marchands
		village = new Village("Le village des irréductibles", 10, 5);

		// Ajout de quelques habitants pour tester les étals
		Gaulois asterix = new Gaulois("Asterix", 10);
		Gaulois obelix = new Gaulois("Obelix", 15);
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelix);

		// Ajout du Chef
		Chef chef = new Chef("Chef", 100, village);
		village.setChef(chef); // Assurez-vous d'ajouter le chef au village

		// Initialisation du contrôleur
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
	}

	@Test
	void testResteEtals() {
		// Test pour vérifier s'il reste des étals libres
		assertTrue(controlPrendreEtal.resteEtals(), "Il devrait y avoir des étals libres.");
		// Installer un vendeur et vérifier s'il reste des étals libres
		controlPrendreEtal.prendreEtal("Asterix", "potion", 10);
		assertTrue(controlPrendreEtal.resteEtals(), "Il devrait encore y avoir des étals libres.");
	}

	@Test
	void testPrendreEtal() {
		// Test pour vérifier si un vendeur peut prendre un étal
		int etalAsterix = controlPrendreEtal.prendreEtal("Asterix", "potion", 10);
		assertNotEquals(-1, etalAsterix, "Astérix devrait obtenir un étal valide.");

		// Vérifier que l'étal d'Asterix est bien occupé avec le bon produit
		assertEquals("potion", village.donnerEtatMarche()[etalAsterix * 3 + 2],
				"Astérix devrait vendre des potions sur son étal.");
	}

	@Test
	void testVerifierIdentite() {
		// Test de la vérification d'identité (méthode non utilisée ici mais testée pour
		// la complétude)
		assertTrue(controlPrendreEtal.verifierIdentite("Asterix"), "L'identité d'Asterix doit être validée.");
		assertFalse(controlPrendreEtal.verifierIdentite("Inconnu"), "Un vendeur inconnu ne doit pas être validé.");
	}

	@Test
	void testPrendreEtalQuandPlusDEtal() {
		// Remplir tous les étals
		for (int i = 0; i < 5; i++) {
			controlPrendreEtal.prendreEtal("Gaulois" + i, "produit" + i, 5);
		}

		// Tester qu'aucun étal supplémentaire ne peut être pris
		int etalInutile = controlPrendreEtal.prendreEtal("Obelix", "menhir", 5);
		assertEquals(-1, etalInutile, "Obélix ne doit pas obtenir d'étal car tous sont occupés.");
	}
}
