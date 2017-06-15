package monopoli;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
//test funzionale del caso d'uso dell'acquisto di una propriet� libera
public class CompraProprietaLiberaTest {
	Proprieta p; Giocatore g; wrapper w;
	@Before
	public void setUp() throws Exception {
		w = mock(wrapper.class);
		p = new Proprieta(1,"Via Prova",500,1,200,200);
		g = new Giocatore("Daniele","psw");
		p.setWrap(w);
		
	}
	//scenario principale: acquista la propriet�
	@Test
	public void compraE1() {
		g.getMyProperties().clear();
		g.setSoldi(1000);
		when(w.getS()).thenReturn("s");
		p.attivaEffetto(g);
		assertEquals(1,g.getMyProperties().size());
	}
	//scenario alternativo: vuole acquistare ma non ha abbastanza soldi
	@Test
	public void compraE2(){
		g.getMyProperties().clear();
		g.setSoldi(200);
		when(w.getS()).thenReturn("s");
		p.attivaEffetto(g);
		assertEquals(0,g.getMyProperties().size());
	}
	//scenario alternativo: non acquista la propriet�
	@Test
	public void compraE3(){
		g.getMyProperties().clear();
		g.setSoldi(200);
		when(w.getS()).thenReturn("n");
		p.attivaEffetto(g);
		assertEquals(0,g.getMyProperties().size());
	}
	//scenario alternativo: input errato nella decisione
	@Test
	public void compraU1(){
		g.getMyProperties().clear();
		g.setSoldi(200);
		when(w.getS()).thenReturn("b");
		p.attivaEffetto(g);
		assertEquals(0,g.getMyProperties().size());
	}
}
