package monopoli;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class ProprietaTest {
	Proprieta p,p1,p2,p3,p4; Banca B; wrapper wrap;
	@Parameter(0) public int var1;
	@Parameter(1) public int var2;
	@Parameter(2) public int var3;
	@Parameter(3) public int var4;
	@Parameter(4) public int var5;
	@Parameter(5) public int houses;
	@Parameter(6) public int albergo;
	@Parameter(7) public int expectedHouse;
	@Parameter(8) public String risp;
	@Parameter(9) public int resto;
	@Before
	public void setUp() throws Exception {
		p = new Proprieta(1,"Via gatto",500,var1,500,1);
		p1 = new Proprieta(2,"via 1",500,var2,500,1);
		p2 = new Proprieta(3,"via 2",500,var3,500,1);
		p3 = new Proprieta(4,"via 3",500,var4,500,1);
		p4 = new Proprieta(5,"via 4",500,var5,500,1);
		B = new Banca();
	}
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{1,1,2,2,3,2,0,2,"s",500},
			{3,3,3,11,2,4,1,4,"s",500},
			{11,11,1,2,3,0,0,0,"n",1000},
			{10,10,10,10,2,0,0,0,"n",1000},
			{8,8,2,6,11,35,0,0,"n",1000},
			
		});
	}
	@Test
	public void isZonaCompletaTrue(){
		Giocatore g = new Giocatore("g1","");
		g.setSoldi(800000);
		System.out.println(var1);
		p.compra(g); p1.compra(g);p3.compra(g);p4.compra(g);p2.compra(g);
		assertTrue(p.isZonaCompleta(g));
		
	}
	@Test
	public void testPagaAffitto() {
		Giocatore g = new Giocatore("pino", "bussola");
		Giocatore g2 = new Giocatore("alfredo", "mazza");
		g.setSoldi(500);
		p.compra(g);
		g2.setSoldi(10000);
		g.setSoldi(500);
		p.pagaAffitto(g2);
		assertEquals(9500,g2.getSoldi());
		assertEquals(1000,g.getSoldi());
	}
	@Test
	public void testPagaAffittoNonSufficienti() {
		Giocatore g = new Giocatore("pino", "bussola");
		Giocatore g2 = new Giocatore("alfredo", "mazza");
		g.setSoldi(500);
		p.compra(g);
		g2.setSoldi(100);
		g.setSoldi(500);
		p.pagaAffitto(g2);
		assertEquals(0,g2.getSoldi());
		assertEquals(500,g.getSoldi());
	}
	@Test
	public void TestCompraSufficienti(){
		Giocatore g = new Giocatore("pino", "bussola");
		g.setSoldi(1000);
		p.compra(g);
		assertEquals(500,g.getSoldi());
		assertNotNull(g.getMyProperties());
	}
	@Test
	public void TestCompraNonSufficienti(){
		Giocatore g = new Giocatore("pino", "bussola");
		g.setSoldi(400);
		p.compra(g);
		assertEquals(400,g.getSoldi());
		assertEquals(0,g.getMyProperties().size());
	}
	@Test
	public void costruisciCaseTest(){
		p.costruisciCase(houses, B);
		assertEquals(expectedHouse,p.getNumeroCase());
	}
	@Test
	public void costruisciAlbergo(){
		B.setAlberghi(30);
		p.setNumeroCase(houses);
		p.costruisciAlbergo(B);
		assertEquals(albergo,p.getAlbergo());
	}
	@Test
	public void costruisciAlbergoBancaPovera(){
		B.setAlberghi(0);
		p.setNumeroCase(4);
		p.costruisciAlbergo(B);
		assertEquals(0,p.getAlbergo());
	}
	@Test
	public void attivaEffettoTest(){
		wrap = mock(wrapper.class);
		String s = risp;
		when(wrap.getS()).thenReturn(s);
		Giocatore g = new Giocatore("g1","");
		p.setWrap(wrap);
		g.setSoldi(1000);
		p.setStato(false);
		p.attivaEffetto(g);
		assertEquals(resto,g.getSoldi());
		p.setStato(true);
		p.attivaEffetto(g);
		assertEquals(resto,g.getSoldi());
		//assertEquals(g.getListOfProperties().size(),1);
		
	}
	@Test
	public void setGetTest(){
		p.setAlbergo(1);
		p.setC(new Contratto(200,100,p));
		p.setIpotecata(true);
		p.setNumeroCase(2);
		p.setProprietario(new Giocatore("D",""));
		p.setValore(200);
		p.setZona(1);
		p.setStato(true);
		assertEquals(1,p.getAlbergo());
		assertEquals(200,p.getC().getAffitto());
		assertEquals(2,p.getNumeroCase());
		assertEquals("D",p.getProprietario().getNome());
		assertEquals(200,p.getValore());
		assertEquals(1,p.getZona());
		assertEquals(true,p.isStato());
		assertEquals(true, p.isOccupata());
		assertEquals(true,p.isIpotecata());
		assertEquals("Via gatto", p.getNome());
	}
}
