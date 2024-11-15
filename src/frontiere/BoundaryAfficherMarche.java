package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosmarche = controlAfficherMarche.donnerinfosmarche();
		if (infosmarche.length == 0) {
			System.out.println("Le marché est vide , revenez plus tard");
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append(nomAcheteur + ", vous trouverez au marche: \n");
			for (int i = 0; i < infosmarche.length;) {
				sb.append("-" + infosmarche[i++] + "qui vend" + infosmarche[i++] + "" + infosmarche[i++]);
			}
			System.out.println(sb.toString());
		}
	}
}
