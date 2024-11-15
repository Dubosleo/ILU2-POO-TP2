package controleur;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private ControlAfficherVillage controlAfficherVillage;

	@BeforeEach
	void setUp() {
		village = new Village("Le village des irréductibles", 10, 5);
		Chef abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlAfficherVillage = new ControlAfficherVillage(village);
	}

	@Test
	void testDonnerNomVillage() {
		assertEquals("Le village des irréductibles", controlAfficherVillage.donnerNomVillage(),
				"Le nom du village devrait être retourné correctement.");
	}

	@Test
	void testDonnerNbEtals() {
		assertEquals(5, controlAfficherVillage.donnerNbEtals(),
				"Le nombre d'étals devrait être retourné correctement.");
	}

	@Test
	void testDonnerNomsVillageois() {
		village.ajouterHabitant(new Druide("Panoramix", 10, 5, 10));
		village.ajouterHabitant(new Gaulois("Asterix", 15));
		village.ajouterHabitant(new Gaulois("Obelix", 20));

		// Vérification que le nombre d'habitants est bien 4 (y compris le chef)
		String[] nomsAttendus = { "Abraracourcix", "le druide Panoramix", "Asterix", "Obelix" };
		assertArrayEquals(nomsAttendus, controlAfficherVillage.donnerNomsVillageois(),
				"Les noms des habitants devraient être correctement retournés.");
	}

}
