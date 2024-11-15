package personnages;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonnageTest {
	private Personnage personnage;

	@BeforeEach
	void setUp() {
		personnage = new Personnage("Testeur", 5);
	}

	@Test
	void testConstructeurValide() {
		assertEquals("Testeur", personnage.getNom(), "Le nom devrait être correctement assigné.");
		assertEquals(5, personnage.getForce(), "La force devrait être correctement assignée.");
	}

	@Test
	void testConstructeurForceInvalide() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			new Personnage("Invalide", 0);
		});
		assertEquals("La force doit être strictement positive.", exception.getMessage(),
				"Le constructeur doit rejeter une force non positive.");
	}

	@Test
	void testParler() {
		// Capture de la sortie standard
		java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
		System.setOut(new java.io.PrintStream(outContent));

		personnage.parler("Bonjour ! ");

		String expectedOutput = "Testeur : « Bonjour ! »\n";
		assertEquals(expectedOutput, outContent.toString(), "La méthode parler doit produire le bon message.");
	}

	@Test
	void testToString() {
		assertEquals("[nom=Testeur, force=5]", personnage.toString(),
				"La méthode toString doit produire une description correcte du personnage.");
	}
}
