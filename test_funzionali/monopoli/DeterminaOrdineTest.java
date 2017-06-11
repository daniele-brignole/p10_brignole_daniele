package monopoli;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
//test funzionale del caso d'uso impostare l'ordine dei giocatori
public class DeterminaOrdineTest {
	Partita p; Giocatore g1; Giocatore g2; Giocatore g3; ArrayList<Giocatore> gl;ArrayList<Giocatore> glo;
	@Before
	public void setUp() throws Exception {
		g1 =  mock(Giocatore.class);
		g2 =  mock(Giocatore.class);
		g3 = mock(Giocatore.class);
		gl = new ArrayList<Giocatore>();
		gl.add(g1); gl.add(g2); gl.add(g3);
		when(g1.makeSum(1, 1)).thenReturn(5);
		when(g2.makeSum(1, 1)).thenReturn(6);
		when(g3.makeSum(1, 1)).thenReturn(3);
	}

	@Test
	public void ordineTestE1() {
		p= new Partita(3,gl);
		glo = new ArrayList<Giocatore>(); glo.add(g2);glo.add(g1);glo.add(g3);
		assertEquals(p.getOrder().get(0).getNome(), glo.get(0).getNome());
		assertEquals(p.getOrder().get(1).getNome(), glo.get(1).getNome());
		assertEquals(p.getOrder().get(2).getNome(), glo.get(2).getNome());
	}

}
