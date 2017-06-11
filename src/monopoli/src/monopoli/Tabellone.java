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
		caselle[0] = new Proprietà(0,"Via",0,-1,1,1);
		caselle[1] = new Proprietà(1,"Vicolo Corto",6000,1,1,1);
		caselle[2] = new Probabilità(2,"probabilità");
		caselle[3] = new Proprietà(3,"Vicolo Stretto",6000,1,1,1);
		caselle[4] = new Tasse(4,"Tassa patrimoniale",5000);
		caselle[5] = new Proprietà(5,"Stazione Sud",20000,10,1,1);
		caselle[6] = new Proprietà(6,"Bastioni Gran Sasso",10000,2,1,1);
		caselle[7] = new Imprevisti(7,"imprevisto");
		caselle[8] = new Proprietà(8,"Viale Monterosa",10000,2,1,1);
		caselle[9] = new Proprietà(9,"Viale Vesuvio",12000,2,1,1);
		caselle[10] = new Proprietà(10,"Prigione/transito",0,-1,1,1);
		caselle[11] = new Proprietà(11,"Via Accademia", 14000,3,1,1);
		caselle[12] = new Proprietà(12,"Via brigno", 50000,4,1,1);
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
