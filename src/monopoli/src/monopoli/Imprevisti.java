package monopoli;

import java.util.Scanner;
/**classe per la casella degli imprevisti
 * 
 * @author Daniele Brignole
 * 
 *
 */
public class Imprevisti extends Casella{
	/**inizializza l'oggetto imprevisto
	 * 
	 * @param p posizione della casella
	 * @param n nome della casella
	 */
	Imprevisti(int p, String n) {
		super(p, n);
		posizione = p; nome = n;
	}
/**non avendo definito precedentemente il caso dell'imprevisto
 * il metodo da una semplice stampa a video
 * @return 
 * 
 */
	@Override
	boolean attivaEffetto(Giocatore g) {
		// TODO Auto-generated method stub
		System.out.println("Pesca un imprevisto!");
		return false;
	}

	/* (non-Javadoc)
	 * @see monopoli.Casella#getNome()
	 */
	@Override
	String getNome() {
		return nome;
	}

}
