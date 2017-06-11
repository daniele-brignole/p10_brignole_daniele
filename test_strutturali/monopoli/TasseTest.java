package monopoli;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TasseTest {
	Tasse t;
	@Before
	public void setUp() throws Exception {
		t = new Tasse(1,"Tassa di Steven", 15000);
	}

	@Test
	public void testCostruttore() {
		assertNotNull(t);
	}
	@Test
	public void testAttivaEffetto(){
		Giocatore g = new Giocatore("g","");
		g.setSoldi(30000);
		t.attivaEffetto(g);
		assertEquals(15000,g.getSoldi());
	}
}
