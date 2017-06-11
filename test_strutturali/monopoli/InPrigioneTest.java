package monopoli;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InPrigioneTest {
	inPrigione ip;
	@Before
	public void setUp() throws Exception {
		ip = new inPrigione(8,"");
	}

	@Test
	public void testConstruct() {
		assertNotNull(ip);
	}
	@Test
	public void testGet(){
		assertNull(ip.getNome());
	}
	@Test
	public void testAttivaEffetto(){
		Giocatore g = new Giocatore("D","");
		ip.attivaEffetto(g);
		assertTrue(g.isPrigion());
	}
}
