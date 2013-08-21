public class Lens {

	/* Connait les intervalles de valeur focale, f-number, focus distance */

	/* Taille focale de l'objectif */
	protected static int focaleLenght;
	/* Ouverture de l'objectif */
	protected static int aperture;
	/* Distance du sujet */
	protected static int focusDistance;

	// Constructeur avec paramètres
	public Lens(int focaleLenght, int aperture, int focusDistance) {
		System.out.println("Création d'un objectif avec des paramètres");
		Lens.focaleLenght = focaleLenght;
		Lens.aperture = aperture;
		Lens.focusDistance = focusDistance;
	}

	// ************************ACCESSEURS****************

	// Retourne la taille focale de l'objectif
	public static int getFocaleLenght() {
		return focaleLenght;
	}

	// Retourne l'ouverture de l'objectif
	public static int getAperture() {
		return aperture;
	}

	// Retourne la distance du sujet
	public static int getFocusDistance() {
		return focusDistance * 1000;
	}

	// *********************MUTATEURS**********************
	// Définit la taille de l'objectif
	public void setFocaleLenght(int pFocaleLenght) {
		focaleLenght = pFocaleLenght;
	}

	// Définit l'ouverture de l'objectif
	public void setAperture(int pAperture) {
		aperture = pAperture;
	}

	// Définit la distance du sujet
	public void setFocusDistance(int pFocusDistance) {
		focusDistance = pFocusDistance;
	}

}
