package monopoli;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collection;
@RunWith(Parameterized.class)
public class PedinaTest {
	Pedina p; Tabellone tab; wrapper w;
	
	@Parameter(0) public int expected;
	 @Parameter(1) public int input1;
	 @Parameter(2) public int input2;
	@Before
	public void setUp() throws Exception {
		p = new Pedina("fungo");
		
		tab = new Tabellone();
		
	}
	@Parameters
	public static Collection<Integer[]> data(){
		return Arrays.asList(new Integer[][] {
			{5,2,3},
			{4,2,2}
			
		});
	}
	@Test
	public void testMuovi() {
		Giocatore mockPlayer = mock(Giocatore.class);
		w = mock(wrapper.class);
		p.setProprietario(mockPlayer);
		mockPlayer.setSoldi(80000);
		when(mockPlayer.tiradado1()).thenReturn(input1);
		when(mockPlayer.tiradado2()).thenReturn(input2);
		when(mockPlayer.makeSum(2,3)).thenReturn(expected);
		when(mockPlayer.makeSum(2,2)).thenReturn(expected);
		when(mockPlayer.isDouble(2, 2)).thenReturn(true);
		String s = "s";
		when(w.getS()).thenReturn(s);
		//p.getAttuale().setWrap(w);
		p.muovi();
		System.out.println(p.getPosizione().getNome());
		assertEquals(p.getPosizione().getNome(), tab.getCasella(5).getNome());
	}
	
	@Test
	public void testGetSet(){
		p.setAttuale(tab.getCasella(1));
		p.setNome("Fungo");
		p.setNtiri(1);
		p.setPosizione(2);
		p.setProprietario(new Giocatore("Daniele",""));
		p.setTab(tab);
		assertEquals(p.getAttuale(),tab.getCasella(1));
		assertEquals(p.getNome(),"Fungo");
		assertEquals(p.getNtiri(),1);
		assertEquals(p.getPos(),2);
		assertEquals(p.getProprietario().getNome(),"Daniele");
		assertEquals(p.getTab(),tab);
	}
	
	
	
}

