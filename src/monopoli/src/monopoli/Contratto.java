package monopoli;
// TODO: Auto-generated Javadoc

/**
 * classe che rappresenta il contratto di una proprietà, serve per contenere i 
 * dati di ipoteca e dell'affitto.
 *
 * @author Daniele Brignole
 */
public class Contratto {
	
	/**
	 * The affitto.
	 */
	private int affitto;
	
	/**
	 * The houses.
	 */
	private int houses;
	
	/**
	 * The albergo.
	 */
	private boolean albergo;
	
	/**
	 * The ipoteca.
	 */
	private int ipoteca;
	
	/**
	 * The associata.
	 */
	private Proprietà associata = null;
	
	/**
	 * inizializza l'oggetto contratto.
	 *
	 * @param affitto affitto base non modificato della proprietà
	 * @param ipoteca valore di ipoteca della casa
	 * @param associata proprietà associata a questo contratto
	 */
	public Contratto(int affitto,int ipoteca, Proprietà associata) {
		super();
		this.affitto = affitto;
		this.associata = associata;
		this.houses = 0;
		this.albergo = false;
		this.ipoteca = ipoteca;
	}
	
	/**
	 *  metodo che calcola l'affitto di questa proprietà in base a
	 * - zona completa
	 * - numero di case
	 * - presenza di albergo.
	 *
	 * @return l'affitto effettivo della proprietà
	 */
	public int calcolaAffitto(){
		if (associata.isIpotecata()) return  0;
		else {
			int a = affitto;
			if(associata.isZonaCompleta(associata.getProprietario())) return a = a*3;
			else if(houses > 0) return a = a*10*houses;
			else if (albergo) return a= a*100;
			else return a;
		}
	}
	
	/**
	 * Gets the affitto.
	 *
	 * @return the affitto
	 */
	public int getAffitto() {
		return affitto;
	}
	
	/**
	 * Sets the affitto.
	 *
	 * @param affitto the new affitto
	 */
	public void setAffitto(int affitto) {
		this.affitto = affitto;
	}
	
	/**
	 * Gets the houses.
	 *
	 * @return the houses
	 */
	public int getHouses() {
		return houses;
	}
	
	/**
	 * Sets the houses.
	 *
	 * @param houses the new houses
	 */
	public void setHouses(int houses) {
		this.houses = houses;
	}
	
	/**
	 * Checks if is albergo.
	 *
	 * @return true, if is albergo
	 */
	public boolean isAlbergo() {
		return albergo;
	}
	
	/**
	 * Sets the albergo.
	 *
	 * @param albergo the new albergo
	 */
	public void setAlbergo(boolean albergo) {
		this.albergo = albergo;
	}
	
	/**
	 * Gets the ipoteca.
	 *
	 * @return the ipoteca
	 */
	public int getIpoteca() {
		return ipoteca;
	}
	
	/**
	 * Sets the ipoteca.
	 *
	 * @param ipoteca the new ipoteca
	 */
	public void setIpoteca(int ipoteca) {
		this.ipoteca = ipoteca;
	}
}
