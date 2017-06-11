package monopoli;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
// Test funzionale del caso d'uso del pagamento dell'affitto, nota, se non si hanno
// abbastanza soldi si può solo perdere
public class PagaAffittoTest {
	Proprietà p; Giocatore g,g1;
	@Before
	public void setUp() throws Exception {
		p = new Proprietà(1,"Via Prova",500,1,200,200);
		g = new Giocatore("Daniele","psw");
		g1 = new Giocatore("bruno","psw");
		g.setSoldi(1000); p.compra(g);
	}
	//scenario principale: il giocatore paga l'affitto
	@Test
	public void affittoTestE1() {
		g1.setSoldi(1000);
		p.attivaEffetto(g1);
		assertEquals(800, g1.getSoldi());
		assertEquals(700, g.getSoldi());
	}
	//scenario alternatico: il giocatore non ha sufficienti soldi
	@Test
	public void affittoTestE2() {
		g1.setSoldi(0);
		p.attivaEffetto(g1);
		assertTrue(g1.isGameOver());
	}
}
