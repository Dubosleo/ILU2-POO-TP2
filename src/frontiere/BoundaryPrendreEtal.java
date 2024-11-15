package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);
	private String produit;
	private int nbProduit;
	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if(controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Bonjour"+ nomVendeur+",je vais regarder si je peux vous trouver un étal");
			if(controlPrendreEtal.resteEtals()) {
				installerVendeur(nomVendeur);
				System.out.println("Le vendeur"+nomVendeur+"s'est instalallé a l'étal n"+controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit));
				
			}
			else {
				System.out.println("Désolée"+nomVendeur+"je n'ai plus d'étal qui ne soit pas déja occupé.");
			}
		}
		else {
			System.out.println("Je suis désolée"+ nomVendeur + "mais il faut etre un habitant de notre village pour commencer ici.");
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me rest un étal pour vous !");
		System.out.println("Il me faudrait quelques renseignements");
		produit=Clavier.entrerChaine("Quel porduit souhaitez-vous vendre?");
		nbProduit=Clavier.entrerEntier("Combien souhaitez-vous en vendre?");
	}
}
