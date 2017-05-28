package monopoli;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author Daniele Brignole
 *
 */
public class Propriet� extends Casella {
	
	/**
	 * The zona.
	 */
	
	private int zona;
	
	/**
	 * The valore.
	 */
	private int valore;
	
	/**
	 * The stato.
	 */
	private boolean stato = false;
	
	/**
	 * The proprietario.
	 */
	private Giocatore proprietario = null;
	
	/**
	 * The ipotecata.
	 */
	private boolean ipotecata = false;
	
	/**
	 * The numero case.
	 */
	private int numeroCase = 0;
	
	/**
	 * The albergo.
	 */
	private int albergo = 0;
	
	/**
	 * The c.
	 */
	private Contratto c;
	/**inizializza l'oggetto propriet� con i valori di parametro
	 * 
	 * @param p posizione della propriet�
	 * @param n nome della propriet�
	 * @param valore valore di acquisto della propriet�
	 * @param colore colore della zona di appartenenza della propriet�
	 * @param affitto valore base di affitto della propriet�
	 * @param ipoteca valore di ipoteca della propriet�
	 */
	Propriet�(int p, String n, int valore, int colore,int affitto,int ipoteca) {
		super(p,n);
		posizione = p;
		nome = n;
		this.valore = valore;
		this.zona = colore;
		c= new Contratto(affitto,ipoteca,this);
		// TODO Auto-generated constructor stub
		
	}
	public Giocatore getProprietario(){
		return proprietario;
	}
	public boolean isIpotecata(){
		return ipotecata;
	}
	/**metodo che trasferisce i soldi dell'affitto dal giocatore che 
	 * � finito sulla casella della propriet� a quello che la possiede,
	 * a patto che essa non sia ipotecata.
	 * 
	 * @param pagante giocatore che deve pagare l'affitto
	 *  
	 */
	public void pagaAffitto(Giocatore pagante){
		int affitto = c.calcolaAffitto();
		int remainder = (pagante.getSoldi() - affitto);
		//if (remainder < 0 ) pagante.gameOver(); //per motivi di implementazione il giocatore perde
		pagante.pay(this.proprietario, affitto);;
	}
	public boolean isOccupata(){
		return stato;
	}
	/**metodo per la costruzione delle case su una propriet� posseduta
	 * 
	 * @param ncase numero di case da costruire
	 * @param banca banca a cui prendere le case
	 * @return true se l'operazione � andata a buon fine, false altrimenti
	 * 
	 */
	public boolean costruisciCase(int ncase, Banca banca){
		int remainder = banca.getCaseTotali() - ncase;
		if ( remainder < 0 ) {
			System.out.println("Case non disponibili in banca");
			return false;
		}
		else {
			banca.setCaseTotali(remainder);
			numeroCase = numeroCase + ncase;
			return true;
		}
	}
	/**metodo per la costruzione di un albergo su una propriet� con almeno 4 case
	 *  
	 * @param banca banca a cui prendere l'albergo
	 * @return true se l'operazione va a buon fine, false altrimenti
	 * 
	 */
	public boolean costruisciAlbergo(Banca banca){
		if (numeroCase != 4){
			System.out.println("Case non sufficienti, necessarie 4 case per costruire l'albergo");
			return false;
		}
		int remainder = banca.getAlberghi() - 1;
		if ( remainder < 0 ) {
			System.out.println("Albergho non disponibile in banca");
			return false;
		}
		else {
			banca.setAlberghi(remainder);
			this.albergo = 1;
			return true;
		}
	}
	/**metodo che controlla se il giocatore possiede tutte le propriet� 
	 * della stessa zona di quella considerata
	 * 
	 * @param g giocatore che possiede l'insieme di case da controllare
	 * @return true se il giocatore possiede l'intera zona, 
	 * 		quindi tutte le propriet� di uno stesso colore, false altrimenti
	 * 
	 */
	public boolean isZonaCompleta(Giocatore g){
		int zoneTotali; int z=0;
		if (zona == 1 || zona == 8) zoneTotali = 2;
		if (zona == 10) zoneTotali = 4;
		if (zona == 11) zoneTotali = 2;
		else zoneTotali = 3;
		ArrayList<Propriet�> myProperties = new ArrayList<Propriet�>(g.getListOfProperties());
		for (int i = 0; i < myProperties.size();i++){
			if(myProperties.get(i).zona == this.zona) z++;
		}
		if (z!=zoneTotali) return false;
		return true;
	}
	public boolean compra(Giocatore g){
		if (g.getSoldi() < this.valore) {
			System.out.println("Soldi insufficienti");
			return false;
		}
		g.pay(this.valore);;
		g.addPropriety(this);
		ipotecata = true;
		return true;
	}

	@Override
	/**Metodo che controlla se la propriet� su cui � finito il giocatore 
	 * � libera o occupata e ne permette l'acquisto nel primo caso (con possibile rifiuto 
	 * e conseguente messa in asta della propriet�) o
	 * il pagamento dell'affitto nel secondo caso
	 * @param g giocatore che finisce sulla casella di propriet�
	 * 
	 */
	void attivaEffetto(Giocatore g) {
		// TODO Auto-generated method stub
		if(!stato) {
			System.out.println("Comprare o non comprare? s/n");
			Scanner scan = new Scanner(System.in);
			String risp = scan.next();
			//scan.close();
			if (risp.equals("s")) compra(g);
			else if(risp.equals("n")) {
				System.out.println("Non hai comprato la propriet�, verr� messa all'asta");
				
				Asta asta = new Asta(500,this,null);
				return;
			}
			else {
				System.out.println("Input errato");
				attivaEffetto(g);
				}
			}
		else pagaAffitto(g);
	}

	@Override
	String getNome() {
		return this.nome;
	}

}
