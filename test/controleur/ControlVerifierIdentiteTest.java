package controleur;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {

	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;

	@BeforeEach
	void setUp() {
		// Créer le village avec un chef
		village = new Village("Le village des irréductibles", 10, 5);

		// Créer et ajouter un chef
		Chef abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);

		// Ajouter des habitants Gaulois
		Gaulois asterix = new Gaulois("Asterix", 10);
		Gaulois obelix = new Gaulois("Obelix", 15);
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelix);

		// Initialiser le contrôleur
		controlVerifierIdentite = new ControlVerifierIdentite(village);
	}

	@Test
	void testVerifierIdentiteValide() {
		// Vérification des identités valides
		assertTrue(controlVerifierIdentite.verifierIdentite("Asterix"), "L'identité d'Asterix doit être valide.");
		assertTrue(controlVerifierIdentite.verifierIdentite("Obelix"), "L'identité d'Obelix doit être valide.");
		assertTrue(controlVerifierIdentite.verifierIdentite("Abraracourcix"), "L'identité du chef doit être valide.");
	}

	@Test
	void testVerifierIdentiteInvalide() {
		// Vérification des identités invalides
		assertFalse(controlVerifierIdentite.verifierIdentite("Panoramix"),
				"Panoramix n'est pas un habitant du village.");
		assertFalse(controlVerifierIdentite.verifierIdentite("Idefix"), "Idéfix n'est pas un habitant du village.");
	}
}
