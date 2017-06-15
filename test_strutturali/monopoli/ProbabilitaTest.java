package monopoli;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProbabilitaTest {

	Probabilita i;
	@Before
	public void setUp() throws Exception {
		i = new Probabilita(2,"Prob");
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
