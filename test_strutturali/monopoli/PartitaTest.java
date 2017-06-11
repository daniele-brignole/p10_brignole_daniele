package monopoli;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
@RunWith(Parameterized.class)
public class PartitaTest {
	Partita p; Giocatore g1; Giocatore g2; Giocatore g3; ArrayList<Giocatore> gl; ArrayList<Giocatore> glo;
	@Parameter(0) public int var1;
	@Parameter(1) public int var2;
	@Parameter(2) public int var3;
	
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
		when(g1.makeChoice()).thenReturn(var1);
		when(g2.makeChoice()).thenReturn(var2);
		when(g3.makeChoice()).thenReturn(var3);
		glo = new ArrayList<Giocatore>(); glo.add(g2);glo.add(g1);glo.add(g3);
	}
	@Parameters
	public static Collection<Integer[]> data(){
		return Arrays.asList(new Integer[][] {
			{1,0,4},
			{5,1,4},
			{2,3,9}
			
		});
	}
	@Test
	public void testCreazione() {
		p= new Partita(3,gl);
		assertEquals(p.getOrder().get(0).getNome(), glo.get(0).getNome());
		assertEquals(p.getOrder().get(1).getNome(), glo.get(1).getNome());
		assertEquals(p.getOrder().get(2).getNome(), glo.get(2).getNome());
	}
	@Test
	public void testCreaPedina(){
		p = new Partita(3,gl);
		p.generaPedine();
		assertEquals(g1.getPedina().getNome(), "Fungo");
		assertEquals(g2.getPedina().getNome(), "Candela");
		assertEquals(g3.getPedina().getNome(), "Arancia");
		
	}
	@Test
	public void testGetterSetter(){
		ArrayList<Integer> provaint = new ArrayList<Integer>();
		provaint.add(1);
		p = new Partita(3,gl);
		p.setCounterTurni(1);
		p.setG(0);
		p.setGiocatoreDiTurno(g1);
		p.setOrder(glo);
		p.setPlayers(gl);
		p.setnGiocatori(2);
		p.setRisultati(provaint);
		assertEquals(1,p.getCounterTurni());
		assertEquals(0,p.getG());
		assertEquals(g1,p.getGiocatoreDiTurno());
		assertEquals(glo,p.getOrder());
		assertEquals(gl,p.getPlayers());
		assertEquals(2,p.getnGiocatori());
		assertEquals(1,p.getRisultati().size());
		
	}
	@Test
	public void passaGiocatoreTest(){
		p = new Partita(3,gl);
		p.setGiocatoreDiTurno(g1);
		p.passaGiocatore();
		assertEquals(p.getGiocatoreDiTurno().getNome(),g3.getNome());
	}
	@Test
	public void Partitatest(){
		p = new Partita(p);
		assertNotNull(p);
	}
	@Test
	public void passaGiocatoreResetGiroTest(){
		p = new Partita(3,gl);
		p.setGiocatoreDiTurno(g3);
		p.setG(3);
		p.passaGiocatore();
		assertEquals(p.getGiocatoreDiTurno().getNome(),g2.getNome());
	}

}
