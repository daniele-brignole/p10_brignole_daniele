package monopoli;

import java.io.IOException;
import java.util.Scanner;
/**classe main per verificare la corretta compilazione senza eccezioni 
 * delle funzioni da osservare. Ha uno scopo per lo più personale
 *
 * 
 * @author Daniele Brignole
 *  
 */
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Giocatore g = new Giocatore("Daniele","gorillaBello92");
		Partita partita = null;
		System.out.println("Buongiorno "+ g.getNome() + ", cosa desideri fare? (premi pulsante qualunque per iniziare)");
		Scanner s1 = new Scanner(System.in);
		s1.next();
		//s1.close();
		show("Scegliere impostazioni");
		int lev,gioc,soldi,contratti;
		show("Imposta livello: 1 pubblico 2 privato");
		lev = s1.nextInt();
		show("Imposta il numero di giocatori //beta test 1 giocatore");
		gioc = 1;
		show("Imposta il numero di soldi iniziali:");
		soldi = s1.nextInt();
		show("Imposta il numero di contratti iniziali:");
		contratti = s1.nextInt();
		partita = g.addPartita(lev, gioc, soldi, contratti);
		show("Scegli la tua pedina 0 fungo 1 pera 2 candela 3 cactus 4 arancia 5 vino ");
		partita.generaPedine();
		show("Tira i dadi e muovi la pedina");
		g.getPedina().muovi();
		show("Sei su " + g.getPedina().getPosizione().getNome());
		
	}
	/**funzione per semplificare le stampe a video
	 * 
	 * @param text testo da mostrare
	 * 
 	 */
	public static void show(String text){
		System.out.println(text);
	}

}
