public class Shot {

	/*
	 * 1 boitier + 1 objectif + param�tres de mise au point effectifs et donne
	 * la dof, hyperfocale pour une certaine ouverture et focale
	 */

	protected static float nearFocusLimit;
	protected static float hyperfocale;
	protected static float depthOfField;
	protected static float farFocusLimit;

	// Constructeur avec des param�tres
	public Shot(float hyperfocale, float nearFocusLimit, int depthOfField,
			int farFocusLimit) {

		System.out.println("Cr�ation d'une prise de vue avec des param�tres");
		Shot.hyperfocale = hyperfocale;
		Shot.nearFocusLimit = nearFocusLimit;
		Shot.farFocusLimit = farFocusLimit;
		Shot.depthOfField = depthOfField;
	}

	// ************************ACCESSEURS****************

	// Retourne la distance hyperfocale
	public static float getHyperfocale() {
		return hyperfocale = ((Lens.focaleLenght * Lens.focaleLenght)
				/ (Lens.aperture * CameraBody.circleOfConfusion) + Lens.focaleLenght);
	}

	// Retourne la distance minimum
	public static float getNearFocusLimit() {
		return nearFocusLimit = (Shot.hyperfocale * Lens.focusDistance * 1000)
				/ (Shot.hyperfocale + Lens.focusDistance * 1000) / 1000;
	}

	// Retourne la distance maximum
	public static float getFarFocusLimit() {
		return farFocusLimit = (Shot.hyperfocale * Lens.focusDistance * 1000)
				/ (Shot.hyperfocale - Lens.focusDistance * 1000) / 1000;
	}

	// Retourne la profondeur de champ
	public static float getDepthOfField() {
		return depthOfField = (Shot.farFocusLimit * Shot.nearFocusLimit);
	}

	// *********************MUTATEURS**********************

	// D�finit la distance Hyperfocale
	public void setHyperfocale(float pHyperfocale) {
		hyperfocale = pHyperfocale;
	}

	// D�finit la distance minimum
	public void setNearFocusLimit(float pNearFocusLimit) {
		nearFocusLimit = pNearFocusLimit;
	}

	// D�finit la profondeur de champ
	public void setDepthOfField(float pDepthOfField) {
		depthOfField = pDepthOfField;
	}

	// D�finit la distance maximum
	public void setFarFocusLimit(float pFarFocusLimit) {
		farFocusLimit = pFarFocusLimit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// **********************************************Menu***********************
		int choix = 0;
		Scanner sc = new Scanner(System.in);

		System.out
				.println("Bienvenue dans le programme de calcul de profondeur de champ\n");
		System.out.println("Veuillez entrer vos donn�es :\n");

		while (Lens.focaleLenght == 0 || Lens.aperture == 0
				|| Lens.focusDistance == 0 || CameraBody.circleOfConfusion == 0) {
			System.out
					.println("Faites un choix : \n 1. Entrez la longueur focale \n 2. Entrez l'ouverture de l'objectif \n 3. Entrer la distance du sujet \n 4. Entrer le cercle de confusion de l'appareil\n 5. Quitter");
			choix = sc.nextInt();

			switch (choix) {
			case 1:
				System.out.println("Entrez la longueur focale en mm.");
				Lens.focaleLenght = sc.nextInt();
				System.out.println("Vous avez entr� : " + Lens.focaleLenght
						+ "mm.\n");
				break;
			case 2:
				System.out.println("Entrez l'ouverture de l'objectif en mm.");
				Lens.aperture = sc.nextInt();
				System.out.println("Vous avez entr� : " + Lens.aperture
						+ " mm.\n");
				break;
			case 3:
				System.out.println("Entrez la distance du sujet en m.");
				Lens.focusDistance = sc.nextInt();
				System.out.println("Vous avez entr� : " + Lens.focusDistance
						+ "m.\n");
				break;
			case 4:
				System.out
						.println("Entrez le cercle de confusion de l'appareil en mm.");
				CameraBody.circleOfConfusion = sc.nextFloat();
				System.out.println("Vous avez entr� : "
						+ CameraBody.circleOfConfusion + "mm.\n");
				// System.out.println("Vous avez entr� : "+this.circleOfConfusion);
				break;
			}
			if (Lens.focaleLenght == 0 || Lens.aperture == 0
					|| Lens.focusDistance == 0
					|| CameraBody.circleOfConfusion == 0) {
				System.out.println("Il manque des valeurs !\n");
			}
		}
		System.out.println("L'objectif a une taille de "
				+ Lens.getFocaleLenght() + " mm, une ouverture de "
				+ Lens.getAperture() + " mm, pour une distance de "
				+ Lens.getFocusDistance() + " mm et un cercle de confusion de "
				+ CameraBody.getCircleOfConfusion() + ".\n");
		System.out.println("L'hyperfocale est de " + Shot.getHyperfocale()
				+ " mm, la profondeur de champ est de "
				+ Shot.getDepthOfField() + "m, avec une distance minimum de "
				+ Shot.getNearFocusLimit() + " m et une distance maximum de "
				+ Shot.getFarFocusLimit() + " m.\n");

	}

}
