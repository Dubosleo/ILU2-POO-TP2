package controleur;

import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.setVillage(village);
		this.setControlVerifierIdentite(controlVerifierIdentite);
		this.setControlTrouverEtalVendeur(controlTrouverEtalVendeur);
	}

	public ControlVerifierIdentite getControlVerifierIdentite() {
		return controlVerifierIdentite;
	}

	public void setControlVerifierIdentite(ControlVerifierIdentite controlVerifierIdentite) {
		this.controlVerifierIdentite = controlVerifierIdentite;
	}

	public ControlTrouverEtalVendeur getControlTrouverEtalVendeur() {
		return controlTrouverEtalVendeur;
	}

	public void setControlTrouverEtalVendeur(ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public Village getVillage() {
		return village;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	//TODO a completer
}
