package monopoli;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Imprevistitest {
	Imprevisti i;
	@Before
	public void setUp() throws Exception {
		i = new Imprevisti(2,"Imprevisto");
	}

	@Test
	public void testImprevisti() {
		assertNotNull(i);
	}
	@Test
	public void testGetNome(){
		assertEquals("Imprevisto",i.getNome());
	}
	@Test
	public void testAttivaEffetto(){
		i.attivaEffetto(new Giocatore("D",""));
	}

}
