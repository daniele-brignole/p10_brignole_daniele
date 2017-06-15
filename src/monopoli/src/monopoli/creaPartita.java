package monopoli;

import java.util.ArrayList;
// TODO: Auto-generated Javadoc

/**
 * classe di aiuto per la creazione della partita.
 *
 * @author Daniele Brignole
 */
public class creaPartita {
	
	/**
	 * inizializza l'oggetto.
	 */
	creaPartita(){};
	
	/**
	 * The livello.
	 */
	private int livello;
	
	/**
	 * The soldi iniziali.
	 */
	private int soldiIniziali;
	
	/**
	 * The numero giocatori.
	 */
	private int numeroGiocatori;
	
	/**
	 * The contratti iniziali.
	 */
	private int contrattiIniziali;
	
	/**
	 * The partecipanti.
	 */
	private ArrayList<Giocatore> partecipanti = new ArrayList<Giocatore>();
	
	/**
	 * setta le impostazioni della partita volute dall'utente.
	 *
	 * @param numeroGiocatori numero di giocatori
	 * @param soldiIniziali soldi iniziali
	 * @param contrattiIniziali contratti iniziali
	 */
	public void setImpostazioni(int numeroGiocatori,int soldiIniziali, int contrattiIniziali){
		this.numeroGiocatori = numeroGiocatori;
		this.soldiIniziali = soldiIniziali;
		this.contrattiIniziali = contrattiIniziali;
	}
	
	/**
	 * setta il livello di segretezza della partita.
	 *
	 * @param livello livello di privatezza pubblico 1 privato 2
	 */
	public void setLivello(int livello){
		this.livello = livello;
	}
	
	/**
	 * inizializza e crea la partita. si rifa all'UC della creazione partita
	 *
	 * @param g giocatore che crea la partita
	 * @return La partita creata
	 */
	public Partita start(Giocatore g){
		g.setSoldi(soldiIniziali);
		g.setContratti(contrattiIniziali);
		partecipanti.add(g);
		Partita partita = new Partita(numeroGiocatori,partecipanti);
		if (partita != null) System.out.println("gioco creato");
		return partita;
	}

	/**
	 * Gets the soldi iniziali.
	 *
	 * @return the soldi iniziali
	 */
	public int getSoldiIniziali() {
		return soldiIniziali;
	}

	/**
	 * Sets the soldi iniziali.
	 *
	 * @param soldiIniziali the new soldi iniziali
	 */
	public void setSoldiIniziali(int soldiIniziali) {
		this.soldiIniziali = soldiIniziali;
	}

	/**
	 * Gets the numero giocatori.
	 *
	 * @return the numero giocatori
	 */
	public int getNumeroGiocatori() {
		return numeroGiocatori;
	}

	/**
	 * Sets the numero giocatori.
	 *
	 * @param numeroGiocatori the new numero giocatori
	 */
	public void setNumeroGiocatori(int numeroGiocatori) {
		this.numeroGiocatori = numeroGiocatori;
	}

	/**
	 * Gets the contratti iniziali.
	 *
	 * @return the contratti iniziali
	 */
	public int getContrattiIniziali() {
		return contrattiIniziali;
	}

	/**
	 * Sets the contratti iniziali.
	 *
	 * @param contrattiIniziali the new contratti iniziali
	 */
	public void setContrattiIniziali(int contrattiIniziali) {
		this.contrattiIniziali = contrattiIniziali;
	}

	/**
	 * Gets the partecipanti.
	 *
	 * @return the partecipanti
	 */
	public ArrayList<Giocatore> getPartecipanti() {
		return partecipanti;
	}

	/**
	 * Sets the partecipanti.
	 *
	 * @param partecipanti the new partecipanti
	 */
	public void setPartecipanti(ArrayList<Giocatore> partecipanti) {
		this.partecipanti = partecipanti;
	}

	/**
	 * Gets the livello.
	 *
	 * @return the livello
	 */
	public int getLivello() {
		return livello;
	}
}
