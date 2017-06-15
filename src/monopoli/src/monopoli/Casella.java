package monopoli;

import java.util.Scanner;
// TODO: Auto-generated Javadoc

/**
 * classe generica di una casella del tabellone, i suoi metodi
 * sono astratti in modo da venire implementati in modo diverso 
 * in base al tipo di casella da rappresentare.
 *
 * @author Daniele Brignole
 */
public abstract class Casella {
	
	/**
	 * The posizione.
	 */
	protected int posizione;
	
	/**
	 * The nome.
	 */
	protected String nome;
	
	/**
	 * inizializza l'oggetto casella.
	 *
	 * @param p posizione della casella
	 * @param n nome della casella
	 */
	Casella(int p, String n) {
	}
	/**attiva l'effetto relativo alla casella su cui finisce il giocatore
	 * 	
	 * @param g giocatore che termina sulla casella
	 * 
	 */
	abstract boolean attivaEffetto(Giocatore g);
	
	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	abstract String getNome();
	
}
