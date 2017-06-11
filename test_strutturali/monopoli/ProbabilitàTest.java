package monopoli;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Probabilit‡Test {

	Probabilit‡ i;
	@Before
	public void setUp() throws Exception {
		i = new Probabilit‡(2,"Prob");
	}

	@Test
	public void testImprevisti() {
		assertNotNull(i);
	}
	@Test
	public void testGetNome(){
		assertNull(i.getNome());
	}
	@Test
	public void testAttivaEffetto(){
		i.attivaEffetto(new Giocatore("D",""));
	}

}
