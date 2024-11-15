package personnages;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DruideTest {
	private Druide panoramix;
	private Gaulois asterix;
	private Gaulois obelix;

	@BeforeEach
	void setUp() {
		panoramix = new Druide("Panoramix", 5, 3, 10);
		asterix = new Gaulois("Asterix", 5);
		obelix = new Gaulois("Obélix", 10);
	}

	@Test
	void testPreparerPotion() {
		// Capture de la sortie standard
		java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
		System.setOut(new java.io.PrintStream(outContent));

		// Act
		panoramix.preparerPotion();

		// Assert : vérification de la sortie standard
		String output = outContent.toString();
		assertTrue(
				output.contains("J'ai préparé une super potion")
						|| output.contains("Je n'ai pas trouvé tous les ingrédients"),
				"Le druide doit annoncer le résultat de la préparation de la potion.");
		assertTrue(panoramix.force >= 3 && panoramix.force <= 10,
				"La force de la potion doit être dans les limites définies.");
	}

	@Test
	void testBooster() {
		// Act & Assert : Booster Asterix
		panoramix.preparerPotion();
		int forcePotion = panoramix.force; // Sauvegarde pour validation
		panoramix.booster(asterix);

		assertEquals(forcePotion, asterix.force, "La force d'Asterix doit être égale à la force de la potion.");

		// Act & Assert : Essayer de booster Obélix
		java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
		System.setOut(new java.io.PrintStream(outContent));
		panoramix.booster(obelix);

		String output = outContent.toString();
		assertTrue(output.contains("Non, Obélix !... Tu n'auras pas de potion magique !"),
				"Le druide doit refuser de booster Obélix.");
	}
}
