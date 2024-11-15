package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println("Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					emmenagerGaulois(nomVisiteur);
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
        System.out.println("Bienvenue druide " + nomVisiteur + " !");
        int forceDruide = Clavier.entrerEntier("Quelle est votre force ?");
        int effetPotionMin, effetPotionMax;
        boolean validRange = false;
        do {
            effetPotionMin = Clavier.entrerEntier("Quelle est la force de la potion la plus faible que vous produisez ?");
            effetPotionMax = Clavier.entrerEntier("Quelle est la force de la potion la plus forte que vous produisez ?");
            
            if (effetPotionMax >= effetPotionMin) {
                validRange = true; // 
            } else {
                System.out.println("Attention druide, vous vous êtes trompé entre minimum et maximum !");
            }
        } while (!validRange);

        controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);

        System.out.println("Bienvenue au village, druide " + nomVisiteur + 
            " avec une force de " + forceDruide + " et des potions entre " + 
            effetPotionMin + " et " + effetPotionMax + " de force !");
    }
	private void emmenagerGaulois(String nomVisiteur) {
        System.out.println("Bienvenue, " + nomVisiteur + " ! Quelle est votre force ?");
        int force = Clavier.entrerEntier("Entrez votre force :");
        controlEmmenager.ajouterGaulois(nomVisiteur, force);
        System.out.println("Bienvenue au village, " + nomVisiteur + " avec une force de " + force + " !");
    }
}
