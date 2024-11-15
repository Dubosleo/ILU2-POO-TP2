package personnages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GauloisTest {
	private Gaulois gaulois;

	@BeforeEach
	void setUp() {
		gaulois = new Gaulois("Asterix", 5);
	}

	@Test
	void testPrendreParole() {
		// Act
		String message = gaulois.prendreParole();

		// Assert
		assertEquals("Le gaulois Asterix : ", message,
				"Le message pris par le Gaulois devrait inclure son titre et son nom.");
	}

	@Test
	void testToString() {
		// Act
		String description = gaulois.toString();

		// Assert
		assertEquals("Gaulois [nom=Asterix, force=5, effetPotion=1]", description,
				"La méthode toString devrait afficher correctement les attributs du Gaulois.");
	}

	@Test
	void testBoirePotion() {
		// Capture de la sortie standard
		int forcePotion = 5;
		String expectedOutput = "Le gaulois Asterix : « Merci Druide, je sens que ma force est 5 fois décuplée. »\n";

		// Récupérer la sortie standard
		java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
		System.setOut(new java.io.PrintStream(outContent));

		// Act
		gaulois.boirePotion(forcePotion);

		// Assert
		assertEquals(expectedOutput, outContent.toString(),
				"La méthode boirePotion doit produire le bon message avec la force de la potion. ");
		assertEquals(5, gaulois.force, "L'effet de la potion devrait être mis à jour. ");
	}
}
