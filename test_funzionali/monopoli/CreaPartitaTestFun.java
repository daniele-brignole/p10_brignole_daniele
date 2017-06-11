package monopoli;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
//Test funzionale per il caso d'uso della creazione della partita
public class CreaPartitaTestFun {
	creaPartita cp; Giocatore g; Partita p = null;
	@Before
	public void setUp() throws Exception {
		cp = new creaPartita();g = new Giocatore("Daniele","psw");
	}
	//livello pubblico
	@Test
	public void CreaE1() {
		p = g.addPartita(2, 1, 8000, 2);
		assertNotNull(p);
	}
	//livello privato
	@Test
	public void CreaE2() {
		p = g.addPartita(0, 1, 8000, 2);
		assertNotNull(p);
	}

}
