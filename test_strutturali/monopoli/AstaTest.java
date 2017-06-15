package monopoli;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AstaTest {
	Asta a; Proprieta p; Giocatore g;
	@Before
	public void setUp() throws Exception {
		p = new Proprieta(1,"Via della prova",500,1,1,1);
		g = new Giocatore("Daniele", "");
		a = new Asta(500,p,g);
	}

	@Test
	public void testAsta() {
		assertNotNull(a);
		assertEquals("Via della prova", a.getProprietaOfferta().getNome());
		assertEquals("Daniele",a.getProprietario().getNome());
		assertEquals(500,a.getOffertaIniziale());
	}
	@Test
	public void getSetTest(){
		a.setOffertaIniziale(800);
		a.setProprietario(new Giocatore("Brigno",""));
		a.setProprietaOfferta(new Proprieta(8,"Via B1",1300,5,7,3));
		assertEquals(800,a.getOffertaIniziale());
		assertEquals("Via B1",a.getProprietaOfferta().getNome());
		assertEquals("Brigno",a.getProprietario().getNome());
	}
}
