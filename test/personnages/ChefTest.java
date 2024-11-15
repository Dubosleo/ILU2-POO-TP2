package personnages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;

class ChefTest {
	private Chef chef;
	private Village village;

	@BeforeEach
	void setUp() {
		village = new Village("Le village des irréductibles", 10, 5);
		chef = new Chef("Abraracourcix", 10, village);
	}

	@Test
	void testPrendreParole() {
		// Act
		String message = chef.prendreParole();

		// Assert
		assertEquals("Le chef Abraracourcix du village Le village des irréductibles : ", message,
				"Le message pris par le chef devrait inclure son titre, son nom et celui du village.");
	}

	@Test
	void testParler() {
		// Capture de la sortie standard
		String texte = "À l'attaque!";
		String expectedOutput = "Le chef Abraracourcix du village Le village des irréductibles : « " + texte + "»\n";

		// Récupérer la sortie standard
		java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
		System.setOut(new java.io.PrintStream(outContent));

		// Act
		chef.parler(texte);

		// Assert
		assertEquals(expectedOutput, outContent.toString(), "La méthode parler doit produire le texte attendu.");
	}
}
