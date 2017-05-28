package monopoli;
// TODO: Auto-generated Javadoc

/**
 * classe della banca, contiene le case e gli alberghi totali.
 *
 * @author Daniele Brignole
 */
public class Banca {
	
	/**
	 * The case totali.
	 */
	private static int caseTotali = 32;
	
	/**
	 * The alberghi.
	 */
	private static int alberghi = 12;
	
	/**
	 * Gets the case totali.
	 *
	 * @return the case totali
	 */
	public static int getCaseTotali() {
		return caseTotali;
	}
	
	/**
	 * Sets the case totali.
	 *
	 * @param caseTotali the new case totali
	 */
	public static void setCaseTotali(int caseTotali) {
		Banca.caseTotali = caseTotali;
	}
	
	/**
	 * Gets the alberghi.
	 *
	 * @return the alberghi
	 */
	public static int getAlberghi() {
		return alberghi;
	}
	
	/**
	 * Sets the alberghi.
	 *
	 * @param alberghi the new alberghi
	 */
	public static void setAlberghi(int alberghi) {
		Banca.alberghi = alberghi;
	}
	
}
