package monopoli;

import static org.junit.Assert.*;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class GiocatoreTest {
	Giocatore g,g1; ArrayList<Proprieta> lp; Proprieta p;
	
	@Parameter(0) public String risp;
	
	@Before
	public void setUp() throws Exception {
		g = new Giocatore("Daniele","pennuto");
		g1 = new Giocatore("Matteo", "marzapane");
		g.setSoldi(1000); g1.setSoldi(1000);
		lp = new ArrayList<Proprieta>();
		p = new Proprieta(1,"Via Tulipano",1,1,1,1);
	}
	@Parameters
	public static Collection<String[]> data(){
		return Arrays.asList(new String[][] {
			{"5"},
			{"4"},
			{"3"},
			{"2"},
			{"1"},
			{"0"},
			{"6"}
		});
	}
	
	@Test
	public void testGiocatore() {
		assertNotNull(g);
		assertEquals("Daniele", g.getNome());
		assertEquals("pennuto",g.getPassword());
	}
	
	@Test
	public void testPay(){
		g.pay(g1, 500);
		assertEquals(500,g.getSoldi());
		assertEquals(1500,g1.getSoldi());
	}
	@Test
	public void testPayBanca(){
		g.setSoldi(1000);
		g.pay(500);
		assertEquals(500,g.getSoldi());
	}
	@Test
	public void testDadi(){
		int dado1 = g.tiradado1();
		int dado2 = g.tiradado2();
		assertTrue(dado1 > 0 && dado1 < 7 && dado2 > 0 && dado2 < 7);
	}
	@Test
	public void testSumOfDice(){
		int dado1 = 2;
		int dado2 = 5;
		assertEquals(7,g.makeSum(dado1, dado2));
	}
	@Test
	public void testIsDouble(){
		int d1 = 2;
		int d2 = 2;
		assertTrue(g.isDouble(d1, d2));
		d1 = 3;
		assertFalse(g.isDouble(d1, d2));
	}
	@Test
	public void testPrigione(){
		g.putPrigion();
		assertTrue(g.isPrigion());
		g.putFree();
		assertFalse(g.isPrigion());
	}
	@Test
	public void testAddPartita(){
		Partita p = null;
		p = g.addPartita(1, 4, 8000, 2);
		assertNotNull(p);
	}
	@Test
	public void testAddProprieta(){
		
		g.addPropriety(p);
		assertEquals(1,g.getMyProperties().size());
	}
	@Test
	public void testRemoveProprieta(){
		g.removeProperty(p);
		assertEquals(0,g.getMyProperties().size());
	}
	@Test
	public void testPrintProprietaInLista(){
		g.addPropriety(p);
		String s = g.PrintProprietainLista();
		assertNotNull(s);
	}
	@Test
	public void testGetSet(){
		g.setContratti(2);
		g.setCountJail(1);
		g.setMyProperties(lp);
		g.setNome("Brigno");
		g.setPassword("password");
		g.setPedina(new Pedina("Steven"));
		g.setRis1(5);
		g.setRis2(1);
		g.setSoldi(7000);
		g.setSumofDice(8);
		g.setGameOver(true);
		assertEquals(2,g.getContratti());
		assertEquals(1,g.getCountJail());
		assertEquals(lp.size(),g.getMyProperties().size());
		assertEquals("Brigno", g.getNome());
		assertEquals("password",g.getPassword());
		assertEquals("Steven",g.getPedina().getNome());
		assertEquals(5,g.getRis1());
		assertEquals(1,g.getRis2());
		assertEquals(7000,g.getSoldi());
		assertEquals(8,g.getSumofDice());
		assertTrue(g.isGameOver());
	}
	@Test
	public void testMakeChoice() throws IOException{
		wrapper w = mock(wrapper.class);
		when(w.getS()).thenReturn(risp);
		g.setWrap(w);
		g.makeChoice();
	}
}
