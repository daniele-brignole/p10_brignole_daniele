package monopoli;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author Daniele Brignole
 *
 */
public class Proprietà extends Casella {
	private wrapper wrap = new wrapper();
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
	/**inizializza l'oggetto proprietà con i valori di parametro
	 * 
	 * @param p posizione della proprietà
	 * @param n nome della proprietà
	 * @param valore valore di acquisto della proprietà
	 * @param colore colore della zona di appartenenza della proprietà
	 * @param affitto valore base di affitto della proprietà
	 * @param ipoteca valore di ipoteca della proprietà
	 */
	Proprietà(int p, String n, int valore, int colore,int affitto,int ipoteca) {
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
	 * è finito sulla casella della proprietà a quello che la possiede,
	 * a patto che essa non sia ipotecata.
	 * 
	 * @param pagante giocatore che deve pagare l'affitto
	 *  
	 */
	public void pagaAffitto(Giocatore pagante){
		int affitto = c.calcolaAffitto();
		int remainder = (pagante.getSoldi() - affitto);
		if (remainder < 0 ) pagante.gameOver(); //per motivi di implementazione il giocatore perde
		pagante.pay(this.proprietario, affitto);;
	}
	public boolean isOccupata(){
		return stato;
	}
	/**metodo per la costruzione delle case su una proprietà posseduta
	 * 
	 * @param ncase numero di case da costruire
	 * @param banca banca a cui prendere le case
	 * @return true se l'operazione è andata a buon fine, false altrimenti
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
			c.setHouses(numeroCase);
			return true;
		}
	}
	/**metodo per la costruzione di un albergo su una proprietà con almeno 4 case
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
	/**metodo che controlla se il giocatore possiede tutte le proprietà 
	 * della stessa zona di quella considerata
	 * 
	 * @param g giocatore che possiede l'insieme di case da controllare
	 * @return true se il giocatore possiede l'intera zona, 
	 * 		quindi tutte le proprietà di uno stesso colore, false altrimenti
	 * 
	 */
	public boolean isZonaCompleta(Giocatore g){
		int zoneTotali = 0; int z=0;
		
		if (zona == 1 || zona == 8) zoneTotali = 2; 
		else if (zona == 10) zoneTotali = 4;
		else if (zona == 11) zoneTotali = 2;
		else zoneTotali = 3;
		ArrayList<Proprietà> myProperties = new ArrayList<Proprietà>(g.getMyProperties());
		for (int i = 0; i < myProperties.size();i++){
			if(myProperties.get(i).zona == this.zona) z++;
		}
		System.out.println(z +" "+zoneTotali);
		
		if (z!=zoneTotali) return false;
		
		else return true;
	}
	public boolean compra(Giocatore g){
		if (g.getSoldi() < this.valore) {
			System.out.println("Soldi insufficienti");
			return false;
		}
		g.pay(this.valore);;
		g.addPropriety(this);
		//g.getProprietàinLista();
		this.proprietario = g;
		stato = true;
		return true;
	}

	@Override
	/**Metodo che controlla se la proprietà su cui è finito il giocatore 
	 * è libera o occupata e ne permette l'acquisto nel primo caso (con possibile rifiuto 
	 * e conseguente messa in asta della proprietà) o
	 * il pagamento dell'affitto nel secondo caso
	 * @param g giocatore che finisce sulla casella di proprietà
	 * 
	 */
	boolean attivaEffetto(Giocatore g) {
		// TODO Auto-generated method stub
		if(!stato) {
			System.out.println("Comprare o non comprare? s/n");
			
			//wrap.setS();
			String risp = wrap.getS();
			System.out.println(risp);
			if (risp.equals("s")) compra(g);
			else if(risp.equals("n")) {
				System.out.println("Non hai comprato la proprietà, verrà messa all'asta");
				
				Asta asta = new Asta(500,this,null);
				return false;
			}
			else {
				System.out.println("Input errato");
				attivaEffetto(g);
				}
			}
		else pagaAffitto(g);
		return true;
	}

	@Override
	String getNome() {
		return this.nome;
	}
	public int getZona() {
		return zona;
	}
	public void setZona(int zona) {
		this.zona = zona;
	}
	public int getValore() {
		return valore;
	}
	public void setValore(int valore) {
		this.valore = valore;
	}
	public boolean isStato() {
		return stato;
	}
	public void setStato(boolean stato) {
		this.stato = stato;
	}
	public int getNumeroCase() {
		return numeroCase;
	}
	public void setNumeroCase(int numeroCase) {
		this.numeroCase = numeroCase;
	}
	public int getAlbergo() {
		return albergo;
	}
	public void setAlbergo(int albergo) {
		this.albergo = albergo;
	}
	public Contratto getC() {
		return c;
	}
	public void setC(Contratto c) {
		this.c = c;
	}
	public void setProprietario(Giocatore proprietario) {
		this.proprietario = proprietario;
	}
	public void setIpotecata(boolean ipotecata) {
		this.ipotecata = ipotecata;
	}
	public wrapper getWrap() {
		return wrap;
	}
	public void setWrap(wrapper wrap) {
		this.wrap = wrap;
	}
	
	

}
class wrapper{
	wrapper(){
		
	}
	
	public String getS(){
		String s1 = "";
		return s1;
	}
	private String s ;
}
