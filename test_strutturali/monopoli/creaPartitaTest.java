package monopoli;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class creaPartitaTest {
	creaPartita cp; Giocatore g; Partita p; ArrayList<Giocatore> gl;
	@Parameter public int play;
	@Before
	public void setUp() throws Exception {
		cp = new creaPartita();
		g = new Giocatore("D","");
		p = null;
		gl = new ArrayList<Giocatore>(); gl.add(g);
	}
	@Parameters
	public static Collection<Integer[]> data(){
		return Arrays.asList(new Integer[][] {
			{1},
			{2},
			{3},
			{4}
			
		});
	}
	@Test
	public void testCreaPartita() {
		cp = new creaPartita();
		assertNotNull(cp);
	}
	@Test
	public void setimpostazioniTest(){
		cp.setImpostazioni(play, 80000, 5);
		assertEquals(play, cp.getNumeroGiocatori());
		assertEquals(80000,cp.getSoldiIniziali());
		assertEquals(5,cp.getContrattiIniziali());
		
	}
	@Test
	public void startTest(){
		cp.setImpostazioni(play, 80000, 5);
		p = cp.start(g);
		assertNotNull(p);
		assertEquals(play,p.getPlayers().size());
		assertEquals(80000,g.getSoldi());
		assertEquals(5,g.getContratti());
	}
	@Test
	public void getsetTester(){
		cp.setContrattiIniziali(2);
		cp.setLivello(0);
		cp.setNumeroGiocatori(play);
		cp.setPartecipanti(gl);
		cp.setSoldiIniziali(500);
		assertEquals(2,cp.getContrattiIniziali());
		assertEquals(0,cp.getLivello());
		assertEquals(play,cp.getNumeroGiocatori());
		assertEquals(gl.size(),cp.getPartecipanti().size());
		assertEquals(500,cp.getSoldiIniziali());
	}
}
