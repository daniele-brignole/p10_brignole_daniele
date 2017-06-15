package monopoli;

// TODO: Auto-generated Javadoc
/**Classe dell'asta per la registrazione di una propriet�
 * The Class Asta.
 */
/*
 * rispetto al modello, � cambiato l' attibuto 
 * propriet�Offerta da int a Propriet�
 */
public class Asta {
	
	/**
	 * The offerta iniziale.
	 */
	private int offertaIniziale;
	
	/**
	 * The proprieta offerta.
	 */
	private Proprieta proprietaOfferta;
	
	/**
	 * The proprietario.
	 */
	private Giocatore proprietario;
	
	/**
	 * Instantiates a new asta.
	 *
	 * @param offertaIniziale the offerta iniziale
	 * @param proprietaOfferta the proprieta offerta
	 * @param proprietario the proprietario
	 */
	Asta(int offertaIniziale, Proprieta proprietaOfferta, Giocatore proprietario){
		this.offertaIniziale = offertaIniziale;
		this.proprietaOfferta = proprietaOfferta;
		this.proprietario = proprietario;
	}

	public int getOffertaIniziale() {
		return offertaIniziale;
	}

	public void setOffertaIniziale(int offertaIniziale) {
		this.offertaIniziale = offertaIniziale;
	}

	public Proprieta getProprietaOfferta() {
		return proprietaOfferta;
	}

	public void setProprietaOfferta(Proprieta proprietaOfferta) {
		this.proprietaOfferta = proprietaOfferta;
	}

	public Giocatore getProprietario() {
		return proprietario;
	}

	public void setProprietario(Giocatore proprietario) {
		this.proprietario = proprietario;
	}
}
