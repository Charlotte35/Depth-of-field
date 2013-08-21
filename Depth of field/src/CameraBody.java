public class CameraBody {

	/* Connait le cercle de confusion acceptable pour le boitier */
	/* Choose the camera, film format or circle of confusion */
	protected static float circleOfConfusion;

	// Constructeur avec des param�tres
	public CameraBody(float circleOfConfusion) {
		System.out.println("Cr�ation d'un bo�tier avec des param�tres");
		CameraBody.circleOfConfusion = circleOfConfusion;
	}

	// *************************ACCESSEURS************

	// Retourne le cercle de confusion
	public static float getCircleOfConfusion() {
		return circleOfConfusion;
	}

	// ****************MUTATEURS*****************

	// D�finit le cercle de confusion
	public void setCircleOfCondusion(float pCircleOfConfusion) {
		circleOfConfusion = pCircleOfConfusion;
	}

}
