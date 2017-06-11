package monopoli;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ContrattoTest {
	Proprietà p = null;Proprietà p2 = null; Contratto c = null; Giocatore g; Contratto g2; Banca B;
	@Before
	public void setUp() throws Exception {
		p = new Proprietà(1,"test1",6000,1,500,1);
		p2 = new Proprietà(1,"test2",5000,1,600,1);
		g = new Giocatore("Daniele", "ciao");
		g.setSoldi(80000000);
		//p.compra(g);p2.compra(g);
		B = new Banca();
		//p.costruisciCase(1, B);
		
		c = new Contratto(500,1,p);
		g2 = new Contratto(600,1,p2);
	}

	@Test
	public void testAffittoNormale() {
		int a = 500;
		p.compra(g);
		int myA = c.calcolaAffitto();
		assertEquals("Errore nel calcolo",a, myA);
	}
	@Test
	public void testAffittoZone(){
		int a = 1500;
		p.compra(g); p2.compra(g);
		assertEquals(a , c.calcolaAffitto());
	}
	@Test
	public void testAffittoCasa(){
		p.compra(g);
		p.costruisciCase(2, B);
		System.out.println(c.getHouses());
		assertEquals("Errore nel calcolo", 10000, c.calcolaAffitto());
	}
	@Test
	public void testSetAffitto(){
		c.setAffitto(50000);
		assertEquals(50000,c.getAffitto());
	}
	@Test
	public void testGetAffitto(){
		assertEquals(500,c.getAffitto());
	}
	@Test
	public void testGetSet(){
		c.setAlbergo(true);
		c.setAssociata(p);
		c.setHouses(2);
		c.setIpoteca(12);
		assertEquals(true, c.isAlbergo());
		assertEquals("test1",p.getNome());
		assertEquals(2,c.getHouses());
		assertEquals(12,c.getIpoteca());
	}

}
