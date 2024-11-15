package villagegaulois;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Gaulois;

class VillageTest {
	private Village village;
	private Gaulois asterix;

	@BeforeEach
	void setUp() {
		village = new Village("Le village des irréductibles", 10, 5);
		asterix = new Gaulois("Asterix", 10);
	}

	@Test
	void testPartirVendeur() {
		// Arrange
		village.installerVendeur(asterix, "potion", 5);
		assertNotNull(village.rechercherEtal(asterix), "Asterix devrait avoir un étal avant son départ.");

		// Act
		village.partirVendeur(asterix);

		// Assert
		assertNull(village.rechercherEtal(asterix), "Asterix ne devrait plus avoir d'étal après son départ.");
	}

	@Test
	void testRechercherVendeursProduit() {
		// Arrange: Installer des vendeurs
		village.installerVendeur(asterix, "potion", 5);

		// Act: Rechercher des vendeurs pour le produit "potion"
		Gaulois[] vendeursPotion = village.rechercherVendeursProduit("potion");

		// Assert: Vérifier que le vendeur est bien trouvé
		assertEquals(1, vendeursPotion.length);
		assertEquals("Asterix", vendeursPotion[0].getNom());
	}

}
