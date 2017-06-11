package monopoli;

import java.util.Scanner;
/**classe per la casella probabilità
 * 
 * @author Daniele Brignole
 * 
 *
 */
public class Probabilità extends Casella{
	/**inizializza l'oggetto probabilità
	 * 
	 * @param p posizione della casella
	 * @param n nome della casella
	 */
	Probabilità(int p, String n) {
		super(p, n);
		posizione = p; nome = n;
	}
/**non avendo definito precedentemente il caso dell'imprevisto
 * il metodo da una semplice stampa a video
 * 
 */
	@Override
	boolean attivaEffetto(Giocatore g) {
		// TODO Auto-generated method stub
		System.out.println("Pesca una probabilità!");
		return false;
	}

	@Override
	String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

}
