package monopoli;

import java.io.IOException;
import java.util.ArrayList;
// TODO: Auto-generated Javadoc
/**classe che rappresenta una partita a monopoli, imposta 
 * alcune opzioni e decide l'ordine dei giocatori. Gestisce 
 * gli eventi nel corso della partita
 * 
 * @author Daniele Brignole
 * 
 *
 */
public class Partita {
	
	/**
	 * The n giocatori.
	 */
	private int nGiocatori;
	
	/**
	 * The counter turni.
	 */
	private int counterTurni;
	
	/**
	 * The players.
	 */
	private ArrayList<Giocatore> players = new ArrayList<Giocatore>();
	
	/**
	 * The order.
	 */
	private ArrayList<Giocatore> order = new ArrayList<Giocatore>();
	
	/**
	 * The giocatore di turno.
	 */
	private Giocatore giocatoreDiTurno;
	
	/**
	 * The risultati.
	 */
	private ArrayList<Integer> risultati= new ArrayList<Integer>();
	
	/**
	 * The g.
	 */
	private int g = 0;
	
	/**
	 * Instantiates a new partita.
	 *
	 * @param p the p
	 */
	Partita(Partita p){
		
	};
	
	/**
	 * costruisce l'oggetto partita inizializzando la lista dei giocatori, 
	 * quindi determina l'ordine in cui essi agiranno.
	 *
	 * @param nG numero di giocatori
	 * @param players lista dei giocatori non ordinata
	 */
	Partita(int nG, ArrayList<Giocatore> players){
		nGiocatori = nG;
		this.players = new ArrayList<Giocatore>(players);
		Tabellone tabellone = new Tabellone();
		for (int y = 0; y < nGiocatori; y++){
			int dado1 = this.players.get(y).tiradado1();
			int dado2 = this.players.get(y).tiradado2();
			risultati.add(this.players.get(y).makeSum(dado1, dado2));
		}
		int max = -1;
		for (int i = 0; i < nGiocatori; i++){
			for(int j = i; j < nGiocatori; j++){
				if (risultati.get(i) >= risultati.get(j)) max = i;
				else max = j;
			}
			order.add(this.players.get(max));
		}
		giocatoreDiTurno = this.order.get(0);
	}
	
	public int getnGiocatori() {
		return nGiocatori;
	}

	public void setnGiocatori(int nGiocatori) {
		this.nGiocatori = nGiocatori;
	}

	public int getCounterTurni() {
		return counterTurni;
	}

	public void setCounterTurni(int counterTurni) {
		this.counterTurni = counterTurni;
	}

	public ArrayList<Giocatore> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Giocatore> players) {
		this.players = players;
	}

	public ArrayList<Giocatore> getOrder() {
		return order;
	}

	public void setOrder(ArrayList<Giocatore> order) {
		this.order = order;
	}

	public Giocatore getGiocatoreDiTurno() {
		return giocatoreDiTurno;
	}

	public void setGiocatoreDiTurno(Giocatore giocatoreDiTurno) {
		this.giocatoreDiTurno = giocatoreDiTurno;
	}

	public ArrayList<Integer> getRisultati() {
		return risultati;
	}

	public void setRisultati(ArrayList<Integer> risultati) {
		this.risultati = risultati;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	/**
	 * passa il turno al giocatore successivo.
	 */
	public void passaGiocatore(){
		g++;
		if (g > nGiocatori) g = 0;
		giocatoreDiTurno = order.get(g);
	}
	
	/**
	 * genera gli oggetti pedine disponibili e fa scegliere ai giocatori in ordine la 
	 * pedina che desiderano avere.
	 */
	public void generaPedine(){
		Pedina fungo = new Pedina("Fungo");
		Pedina pera = new Pedina("Pera");
		Pedina Candela = new Pedina("Candela");
		Pedina Cactus = new Pedina("Cactus");
		Pedina Arancia = new Pedina("Arancia");
		Pedina Vino = new Pedina("Vino");
		int choice;
		for (int i = 0; i < nGiocatori; i++){
			choice = -1;
			while(choice == -1){
				try {
					choice = order.get(i).makeChoice();
				} catch (IOException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (choice == -1 ){
					System.out.println("Input errato riprovare");
				}
			}
			switch(choice){
			case 0:
				order.get(i).setPedina(fungo);
				System.out.println("Hai scelto il fungo");
				fungo.setProprietario(order.get(i));
				break;
			case 1:
				order.get(i).setPedina(pera);
				System.out.println("Hai scelto la pera");
				pera.setProprietario(order.get(i));
				break;
			case 2:
				order.get(i).setPedina(Candela);
				System.out.println("Hai scelto la candela");
				Candela.setProprietario(order.get(i));
				break;
			case 3:
				order.get(i).setPedina(Cactus);
				System.out.println("Hai scelto il cactus");
				Cactus.setProprietario(order.get(i));
				break;
			case 4:
				order.get(i).setPedina(Arancia);
				System.out.println("Hai scelto l'arancia");
				Arancia.setProprietario(order.get(i));
				break;
			case 5:
				order.get(i).setPedina(Vino);
				System.out.println("Hai scelto il vino");
				Vino.setProprietario(order.get(i));
				break;
			}
		}
	}
}
