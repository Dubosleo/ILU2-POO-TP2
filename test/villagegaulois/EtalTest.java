package villagegaulois;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Gaulois;

class EtalTest {
	private Etal etal;
	private Gaulois vendeur;

	@BeforeEach
	void setUp() {
		vendeur = new Gaulois("Asterix", 10);
		etal = new Etal();
		etal.occuperEtal(vendeur, "potion", 10); // L'étal est occupé avec 10 potions
	}

	@Test
	void testAcheterProduitQuantiteDisponible() {
		// Arrange : quantité initiale = 10, on achète 5
		int quantiteAchetee = etal.acheterProduit(5);

		// Assert : vérifier que la quantité achetée est correcte et mise à jour
		assertEquals(5, quantiteAchetee, "La quantité achetée devrait être 5.");
		assertEquals(5, etal.getQuantite(), "Il devrait rester 5 potions après l'achat.");
	}

	@Test
	void testAcheterProduitQuantiteExcessive() {
		// Arrange : quantité initiale = 10, on essaye d'acheter 15 (plus que
		// disponible)
		int quantiteAchetee = etal.acheterProduit(15);

		// Assert : vérifier que la quantité achetée est limitée à 10, le stock
		// disponible
		assertEquals(10, quantiteAchetee, "La quantité achetée devrait être 10, car il n'y a pas plus de produits.");
		assertEquals(0, etal.getQuantite(), "Le stock devrait être à zéro après l'achat de tous les produits.");
	}

	@Test
	void testAcheterProduitQuandEtalVide() {
		// Arrange : vider l'étal avant l'achat
		etal.acheterProduit(10); // Acheter tous les produits pour mettre la quantité à 0

		// Act : essayer d'acheter quand il n'y a plus de stock
		int quantiteAchetee = etal.acheterProduit(5);

		// Assert : vérifier qu'on ne peut rien acheter quand l'étal est vide
		assertEquals(0, quantiteAchetee, "La quantité achetée devrait être 0 car l'étal est vide.");
		assertEquals(0, etal.getQuantite(), "La quantité en stock devrait rester à zéro.");
	}

	@Test
	void testAcheterProduitAvecZeroQuantite() {
		// Act : essayer d'acheter 0 produit
		int quantiteAchetee = etal.acheterProduit(0);

		// Assert : vérifier qu'aucun produit n'est acheté et que la quantité reste
		// inchangée
		assertEquals(0, quantiteAchetee, "La quantité achetée devrait être 0 car on a demandé 0.");
		assertEquals(10, etal.getQuantite(), "La quantité en stock devrait rester à 10.");
	}
}
