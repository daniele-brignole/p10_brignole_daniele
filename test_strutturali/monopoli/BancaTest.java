package monopoli;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BancaTest {
	Banca b;
	@Before
	public void setUp() throws Exception {
		b = new Banca();
	}

	@Test
	public void testBanca() {
		assertNotNull(b);
		assertEquals(32,b.getCaseTotali());
		assertEquals(12,b.getAlberghi());
	}
	@Test
	public void getSetTest(){
		b.setAlberghi(5);
		b.setCaseTotali(20);
		assertEquals(5,b.getAlberghi());
		assertEquals(20,b.getCaseTotali());
	}
}
