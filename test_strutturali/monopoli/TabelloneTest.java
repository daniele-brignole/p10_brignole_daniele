package monopoli;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TabelloneTest {
	Tabellone t;
	@Before
	public void setUp() throws Exception {
		t = new Tabellone();
	}

	@Test
	public void testTab() {
		assertNotNull(t);
	}
	@Test
	public void testGetCasella(){
		assertEquals("Viale Monterosa", t.getCasella(8).getNome());
	}
}
