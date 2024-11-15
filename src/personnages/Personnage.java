package personnages;

public class Personnage {
	protected String nom;
	protected int force;

	public Personnage(String nom, int force) {
		this.nom = nom;
		if (force <= 0) {
			throw new IllegalArgumentException("La force doit être strictement positive.");
		}
		this.force = force;
	}

	public int getForce() {
		return force;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public String toString() {
		return "[nom=" + nom + ", force=" + force + "]";
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	protected String prendreParole() {
		return nom + " : ";
	}
}