package controleur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {

	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	@BeforeEach
	void setUp() {
		// Création du village avec une capacité de 10 habitants et 5 étals
		village = new Village("Le village des irréductibles", 10, 5);

		// Création du Chef et ajout au village
		Chef chef = new Chef("Chef", 100, village);
		village.setChef(chef); // Assurez-vous que le chef est ajouté correctement au village

		// Ajout d'habitants Gaulois
		Gaulois asterix = new Gaulois("Asterix", 10);
		Gaulois obelix = new Gaulois("Obelix", 15);
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelix);

		// Initialisation du contrôleur
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
	}

	@Test
	void testTrouverEtalVendeurValide() {
		// Ajouter un vendeur et un produit
		Gaulois asterix = village.trouverHabitant("Asterix");

		// Assurez-vous qu'Astérix est installé sur un étal
		int etalIndex = village.installerVendeur(asterix, "Potion Magique", 10);
		assertNotEquals(-1, etalIndex, "L'étal pour Astérix devrait être trouvé.");

		// Vérifier si l'étal de "Asterix" est bien trouvé
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur("Asterix");
		assertNotNull(etal, "L'étal de Astérix devrait être trouvé.");
		assertEquals(asterix, etal.getVendeur(), "L'étal doit appartenir à Astérix.");
	}

	@Test
	void testTrouverEtalVendeurInvalide() {
		// Assurez-vous qu'il n'y a pas d'étal pour un vendeur inexistant
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur("Panoramix");
		assertNull(etal, "Panoramix n'a pas d'étal, il devrait être null.");
	}

	@Test
	void testVendeurSansEtal() {
		// Assurez-vous qu'un vendeur sans étal retourne null
		Gaulois obelix = village.trouverHabitant("Obelix");

		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur("Obelix");
		assertNull(etal, "Obélix n'a pas d'étal, il devrait être null.");
	}
}
