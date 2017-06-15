package monopoli;

import java.util.Scanner;
// TODO: Auto-generated Javadoc

/**
 * classe che rappresenta la pedina che si muove sul tabellone.
 *
 * @author Daniele Brignole
 */
public class Pedina {
	
	/**
	 * inizializza la pedina e la mette nella posizione iniziale del tabellone.
	 *
	 * @param nome nome della pedina
	 */
	Pedina(String nome){
		this.nome = nome;
		posizione = 0;
		tab = new Tabellone();
		
		attuale = tab.getCasella(0);
		//System.out.println("attuale: "+ attuale.getNome());
		
	}
	
	/**
	 * Sets the proprietario.
	 *
	 * @param g the new proprietario
	 */
	public void setProprietario(Giocatore g){
		proprietario = g;
	}
	
	/**
	 * muove la pedina di una quantit� di caselle pari alla somma di due dadi
	 * se il tiro � un doppio si tira di nuovo
	 * se � la terza volta che si tira il giocatore va in prigione.
	 */
	public void muovi(){
		//if(scan == null) System.out.println("lo scanner � nullo");
		int d1 = proprietario.tiradado1();
		System.out.println(d1);
		int d2 = proprietario.tiradado2();
		System.out.println(d2);
		int sum = proprietario.makeSum(d1, d2);
		System.out.println(sum);
		for (int i = 0; i<sum;i++){
			posizione += 1;
			if (posizione == 14){
				posizione = 0;
				proprietario.setSoldi(proprietario.getSoldi()+20000);
			}
		}
		attuale = tab.getCasella(posizione);
		//if (tab.getCasella(posizione)== null) System.out.println("casella inesistente");
		System.out.println(tab.getCasella(posizione).getNome());
		attuale.attivaEffetto(proprietario);
		//System.out.println("Dati "+this.proprietario.getNome()+ " Propriet�: "+ proprietario.getPropriet�inLista() + " soldi: " + proprietario.getSoldi());
		if(proprietario.isDouble(d1, d2)){
			System.out.println("doppio");
			ntiri++;
			if (ntiri == 3){
				proprietario.putPrigion();
				ntiri = 0;
				return;
			}
			muovi();
		}
		ntiri = 0;
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Tabellone getTab() {
		return tab;
	}

	public void setTab(Tabellone tab) {
		this.tab = tab;
	}

	public Casella getAttuale() {
		return attuale;
	}

	public void setAttuale(Casella attuale) {
		this.attuale = attuale;
	}

	public int getNtiri() {
		return ntiri;
	}

	public void setNtiri(int ntiri) {
		this.ntiri = ntiri;
	}

	public Giocatore getProprietario() {
		return proprietario;
	}

	public void setPosizione(int posizione) {
		this.posizione = posizione;
	}

	/**
	 * Gets the posizione.
	 *
	 * @return the posizione
	 */
	public Casella getPosizione(){
		return attuale;
	}
	public int getPos(){
		return posizione;
	}
	/** The nome. */
	private String nome;
	
	/**
	 * The posizione.
	 */
	private int posizione;
	
	/**
	 * The tabellone.
	 */
	private Tabellone tab;
	
	/**
	 * The attuale.
	 */
	private Casella attuale = new Proprieta(0,"Via",0,-1,1,1);
	
	/**
	 * The ntiri.
	 */
	private int ntiri = 0;
	
	/**
	 * The proprietario.
	 */
	private Giocatore proprietario = null;
}
