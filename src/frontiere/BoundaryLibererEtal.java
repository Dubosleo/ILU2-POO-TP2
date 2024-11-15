package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if (controlLibererEtal.isVendeur(nomVendeur) == null) {
			System.out.println("Mais vous n'etes pas inscrit sur notre marché ajourd'hui!");
		} else {
			if (controlLibererEtal.libererEtal(nomVendeur) != null) {

				System.out.println("Vous avez vendu" + controlLibererEtal.libererEtal(nomVendeur)[4] + "sur"
						+ controlLibererEtal.libererEtal(nomVendeur)[3] + ""
						+ controlLibererEtal.libererEtal(nomVendeur)[2] + "");
			}
		}
	}

}
