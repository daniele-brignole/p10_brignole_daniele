package monopoli;

// TODO: Auto-generated Javadoc
/**Classe dell'asta per la registrazione di una propriet‡
 * The Class Asta.
 */
/*
 * rispetto al modello, Ë cambiato l' attibuto 
 * propriet‡Offerta da int a Propriet‡
 */
public class Asta {
	
	/**
	 * The offerta iniziale.
	 */
	private int offertaIniziale;
	
	/**
	 * The propriet‡ offerta.
	 */
	private Propriet‡ propriet‡Offerta;
	
	/**
	 * The proprietario.
	 */
	private Giocatore proprietario;
	
	/**
	 * Instantiates a new asta.
	 *
	 * @param offertaIniziale the offerta iniziale
	 * @param propriet‡Offerta the propriet‡ offerta
	 * @param proprietario the proprietario
	 */
	Asta(int offertaIniziale, Propriet‡ propriet‡Offerta, Giocatore proprietario){
		this.offertaIniziale = offertaIniziale;
		this.propriet‡Offerta = propriet‡Offerta;
		this.proprietario = proprietario;
	}
}
