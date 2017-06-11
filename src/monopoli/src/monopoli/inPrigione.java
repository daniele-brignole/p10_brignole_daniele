package monopoli;

import java.util.Scanner;
/** classe per la casella in prigione
 * 
 * @author Daniele Brignole
 *
 *
 */
public class inPrigione extends Casella{
	/**inizializza l'oggetto inPrigione
	 * 
	 * @param p posizione della casella
	 * @param n nome della casella
	 */
	inPrigione(int p, String n) {
		super(p, n);
		posizione = p; nome = n;
	}
/**manda in prigione il giocatore che finisce su questa casella
 * @return 
 * 
 */
	@Override
	boolean attivaEffetto(Giocatore g) {
		// TODO Auto-generated method stub
		g.putPrigion();
		return false;
	}

	@Override
	String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

}
