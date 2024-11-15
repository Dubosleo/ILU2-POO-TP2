package controleur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlLibererEtalTest {

	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlLibererEtal controlLibererEtal;

	@BeforeEach
	void setUp() {
		// Crée le village
		village = new Village("Le village des irréductibles", 10, 5);

		// Crée les Gaulois
		Gaulois asterix = new Gaulois("Asterix", 10);
		Gaulois obelix = new Gaulois("Obelix", 15);

		// Ajoute les Gaulois au village
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelix);

		// Crée le Chef et l'ajoute au village
		Chef chef = new Chef("Chef", 100, village);
		village.setChef(chef); // Assurez-vous que le chef est bien ajouté
		village.ajouterHabitant(chef); // Ajoutez le chef explicitement à la liste des villageois

		// Installe les vendeurs
		village.installerVendeur(asterix, "potion", 20);
		village.installerVendeur(obelix, "menhir", 5);

		// Initialisation des contrôleurs
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
	}

	@Test
	void testChefPresent() {
		Gaulois chef = village.trouverHabitant("Chef");
		assertNotNull(chef, "Le chef doit être présent dans le village.");
		assertEquals("Chef", chef.getNom(), "Le nom du chef doit être 'Chef'.");
	}

	@Test
	void testIsVendeur() {
		// Vérifie que le vendeur Asterix a bien un étal
		Etal etalAsterix = controlLibererEtal.isVendeur("Asterix");
		assertNotNull(etalAsterix, "L'étal d'Astérix doit être trouvé.");
		assertEquals("potion", etalAsterix.getProduit(), "Astérix doit vendre des potions.");

		// Vérifie qu'un vendeur inconnu n'a pas d'étal
		Etal etalInconnu = controlLibererEtal.isVendeur("Inconnu");
		assertNull(etalInconnu, "Un vendeur inconnu ne doit pas avoir d'étal.");
	}

	@Test
	void testLibererEtal() {
		// Libération de l'étal de Asterix
		String[] etatAvantLiberation = controlLibererEtal.libererEtal("Asterix");
		assertNotNull(etatAvantLiberation, "Les informations de l'étal doivent être retournées avant libération.");
		assertEquals("Asterix", etatAvantLiberation[1], "Le vendeur doit être Astérix.");
		assertEquals("potion", etatAvantLiberation[2], "Astérix doit vendre des potions.");
		assertEquals("20", etatAvantLiberation[3], "La quantité initiale de potions doit être 20.");

		// Vérifie qu'Asterix n'a plus d'étal après la libération
		Etal etalApresLiberation = controlTrouverEtalVendeur.trouverEtalVendeur("Asterix");
		assertNull(etalApresLiberation, "Astérix ne doit plus avoir d'étal après libération.");

		// Essaye de libérer un vendeur inexistant
		String[] etatVendeurInconnu = controlLibererEtal.libererEtal("Inconnu");
		assertNull(etatVendeurInconnu, "Un vendeur inexistant ne doit pas avoir d'étal à libérer.");
	}
}
