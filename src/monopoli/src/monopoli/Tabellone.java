package monopoli;
/**classe che rappresenta il tabellone di gioco
 * 
 * @author Daniele Brignole
 *
 */
public class Tabellone {
	
	/**
	 * The caselle.
	 */
	private Casella[] caselle = new Casella[13];
	/**inizializza il tabellone impostando le 13 caselle
	 * 
	 */
	Tabellone(){
		caselle[0] = new Propriet�(0,"Via",0,-1,1,1);
		caselle[1] = new Propriet�(1,"Vicolo Corto",6000,1,1,1);
		caselle[2] = new Probabilit�(2,"probabilit�");
		caselle[3] = new Propriet�(3,"Vicolo Stretto",6000,1,1,1);
		caselle[4] = new Tasse(4,"Tassa patrimoniale",5000);
		caselle[5] = new Propriet�(5,"Stazione Sud",20000,10,1,1);
		caselle[6] = new Propriet�(6,"Bastioni Gran Sasso",10000,2,1,1);
		caselle[7] = new Imprevisti(7,"imprevisto");
		caselle[8] = new Propriet�(8,"Viale Monterosa",10000,2,1,1);
		caselle[9] = new Propriet�(9,"Viale Vesuvio",12000,2,1,1);
		caselle[10] = new Propriet�(10,"Prigione/transito",0,-1,1,1);
		caselle[11] = new Propriet�(11,"Via Accademia", 14000,3,1,1);
		caselle[12] = new Propriet�(12,"Via brigno", 50000,4,1,1);
	}
	/**cerca la casella sul tabellone corrispondente alla posizione richiesta
	 * 
	 * @param index posizione ricercata sul tabellone
	 * @return la casella corrispondente all'index
	 * 
	 */
	public Casella getCasella(int index){
		return caselle[index];
	}
}
