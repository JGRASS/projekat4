/**
 * 
 */
package prodavnica;

import static org.junit.Assert.*;

import java.util.LinkedList;

import nabavka.Dobavljac;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Seka i bato
 *
 */
public class ProdavnicaTest {
	
	private Prodavnica prodavnica;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		prodavnica = new Prodavnica();
		prodavnica.setTekuciRacun(5000);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		prodavnica = null;
	}

	/**
	 * Test method for {@link prodavnica.Prodavnica#naruci(prodavnica.Proizvod, nabavka.Dobavljac)}.
	 */
	@Test
	public void testNaruci() {
		Proizvod p = new Proizvod();
		p.setCena(50);
		p.setId("1");
		p.setKolicina(10);
		p.setNaziv("Sladoled");
		
		Dobavljac d = new Dobavljac();
		LinkedList<Proizvod> proizvodi = new LinkedList<Proizvod>();
		
		Proizvod p2 = new Proizvod();
		p.setCena(50);
		p.setId("1");
		p.setKolicina(2000);
		p.setNaziv("Sladoled");
		proizvodi.add(p2);
		
		d.setAdresa("adresa");
		d.setDobavljacId("1");
		d.setIme("ime");
		d.setProizvodi(proizvodi);
		d.setTelefon("telefon");
		
		prodavnica.naruci(p, d);
		
		assertEquals(p, prodavnica.getProizvodi().get(0));
		assertEquals(d, prodavnica.getDobavljaci().get(0));
		assertEquals(4500, prodavnica.getTekuciRacun(), 500);
	}
	
	/**
	 * Test method for {@link prodavnica.Prodavnica#naruci(prodavnica.Proizvod, nabavka.Dobavljac)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testNaruciException() {
	
		prodavnica.naruci(null, null);
	}

	/**
	 * Test method for {@link prodavnica.Prodavnica#daLiImaPopust(prodavnica.Kupac)}.
	 */
	@Test
	public void testDaLiImaPopust() {
		Kupac k = new Kupac();
		k.setKolicina(20000);
		k.setId("1");
		k.setIme("ime");
		prodavnica.dodajKupca(k);
		
		assertTrue(prodavnica.daLiImaPopust(k));
	}
	
	/**
	 * Test method for {@link prodavnica.Prodavnica#daLiImaPopust(prodavnica.Kupac)}.
	 */
	@Test
	public void testDaLiImaPopust2() {
		Kupac k = new Kupac();
		k.setKolicina(20);
		k.setId("1");
		k.setIme("ime");
		prodavnica.dodajKupca(k);
		
		assertFalse(prodavnica.daLiImaPopust(k));
	}
	
	/**
	 * Test method for {@link prodavnica.Prodavnica#daLiImaPopust(prodavnica.Kupac)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testDaLiImaPopustException() {
		prodavnica.daLiImaPopust(null);
	}

	/**
	 * Test method for {@link prodavnica.Prodavnica#primiNarudzbinu(prodavnica.Kupac, prodavnica.Proizvod)}.
	 */
	@Test
	public void testPrimiNarudzbinu() {
		Kupac k = new Kupac();
		k.setKolicina(2000);
		k.setId("1");
		k.setIme("ime");
		prodavnica.dodajKupca(k);
		
		Proizvod p = new Proizvod();
		p.setCena(50);
		p.setId("1");
		p.setKolicina(10);
		p.setNaziv("Sladoled");
		prodavnica.dodajProizvod(p);
		prodavnica.primiNarudzbinu(k, p);
		
		assertEquals(5500, prodavnica.getTekuciRacun(), 500);
		assertEquals(2500, prodavnica.getKupci().get(0).getkolicinaNovca(), 500);
		assertEquals(0, prodavnica.getProizvodi().get(0).getKolicina());
	}

	/**
	 * Test method for {@link prodavnica.Prodavnica#prondadjiKupca(java.lang.String)}.
	 */
	@Test
	public void testProndadjiKupca() {
		Kupac k = new Kupac();
		k.setKolicina(2000);
		k.setId("1");
		k.setIme("ime");
		prodavnica.dodajKupca(k);
		
		assertEquals(k, prodavnica.prondadjiKupca("ime"));
	}
	
	/**
	 * Test method for {@link prodavnica.Prodavnica#prondadjiKupca(java.lang.String)}.
	 */
	@Test
	public void testProndadjiKupca2() {
		Kupac k = new Kupac();
		k.setKolicina(2000);
		k.setId("1");
		k.setIme("ime");
		prodavnica.dodajKupca(k);
		
		assertEquals(null, prodavnica.prondadjiKupca("naziv"));
	}

	/**
	 * Test method for {@link prodavnica.Prodavnica#pronadjiProizvod(java.lang.String)}.
	 */
	@Test
	public void testPronadjiProizvod() {
		Proizvod p = new Proizvod();
		p.setCena(50);
		p.setId("1");
		p.setKolicina(10);
		p.setNaziv("Sladoled");
		prodavnica.dodajProizvod(p);
		
		assertEquals(p, prodavnica.pronadjiProizvod("Sladoled"));
	}
	
	/**
	 * Test method for {@link prodavnica.Prodavnica#pronadjiProizvod(java.lang.String)}.
	 */
	@Test
	public void testPronadjiProizvod2() {
		Proizvod p = new Proizvod();
		p.setCena(50);
		p.setId("1");
		p.setKolicina(10);
		p.setNaziv("Sladoled");
		prodavnica.dodajProizvod(p);
		
		assertEquals(null, prodavnica.pronadjiProizvod("naziv"));
	}

	/**
	 * Test method for {@link prodavnica.Prodavnica#pronadjiDobavljaca(java.lang.String)}.
	 */
	@Test
	public void testPronadjiDobavljaca() {
		Dobavljac d = new Dobavljac();
		d.setAdresa("adresa");
		d.setDobavljacId("1");
		d.setIme("ime");
		d.setTelefon("telefon");
		
		prodavnica.dodajDobavljaca(d);
		
		assertEquals(d, prodavnica.pronadjiDobavljaca("ime"));
	}
	
	/**
	 * Test method for {@link prodavnica.Prodavnica#pronadjiDobavljaca(java.lang.String)}.
	 */
	@Test
	public void testPronadjiDobavljaca2() {
		Dobavljac d = new Dobavljac();
		d.setAdresa("adresa");
		d.setDobavljacId("1");
		d.setIme("ime");
		d.setTelefon("telefon");
		
		prodavnica.dodajDobavljaca(d);
		
		assertEquals(null, prodavnica.pronadjiDobavljaca("naziv"));
	}

	/**
	 * Test method for {@link prodavnica.Prodavnica#dodajProizvod(prodavnica.Proizvod)}.
	 */
	@Test
	public void testDodajProizvod() {
		Proizvod p = new Proizvod();
		p.setCena(50);
		p.setId("1");
		p.setKolicina(10);
		p.setNaziv("Sladoled");
		prodavnica.dodajProizvod(p);
		
		Proizvod p2 = new Proizvod();
		p.setCena(50);
		p.setId("2");
		p.setKolicina(10);
		p.setNaziv("Sladoled2");
		prodavnica.dodajProizvod(p2);
		
		assertEquals(p, prodavnica.getProizvodi().get(0));
		assertEquals(p2, prodavnica.getProizvodi().get(1));
		assertEquals(2, prodavnica.getProizvodi().size());
	}

	/**
	 * Test method for {@link prodavnica.Prodavnica#dodajZaposlenog(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testDodajZaposlenog() {
		Zaposleni z = new Zaposleni();
		z.setAdresa("adresa");
		z.setBrTelefona("telefon");
		z.setID_zaposlenog("1");
		z.setIme("ime");
		z.setPol("pol");
		z.setPrezime("prezime");
		prodavnica.dodajZaposlenog("ime", "prezime", "pol", "telefon", "1", "adresa");
		
		assertEquals(z, prodavnica.getZaposleni().get(0));
		assertEquals(1, prodavnica.getZaposleni().size());
	}

	/**
	 * Test method for {@link prodavnica.Prodavnica#otpustiZaposlenog(prodavnica.Zaposleni)}.
	 */
	@Test
	public void testOtpustiZaposlenog() {
		Zaposleni z = new Zaposleni();
		z.setAdresa("adresa");
		z.setBrTelefona("telefon");
		z.setID_zaposlenog("1");
		z.setIme("ime");
		z.setPol("pol");
		z.setPrezime("prezime");
		prodavnica.dodajZaposlenog("ime", "prezime", "pol", "telefon", "1", "adresa");
		prodavnica.otpustiZaposlenog(z);
		
		assertEquals(0, prodavnica.getZaposleni().size());
	}

	/**
	 * Test method for {@link prodavnica.Prodavnica#izbrisiProizvod(prodavnica.Proizvod)}.
	 */
	@Test
	public void testIzbrisiProizvod() {
		Proizvod p = new Proizvod();
		p.setCena(50);
		p.setId("1");
		p.setKolicina(10);
		p.setNaziv("Sladoled");
		prodavnica.dodajProizvod(p);
		
		Proizvod p2 = new Proizvod();
		p.setCena(50);
		p.setId("2");
		p.setKolicina(10);
		p.setNaziv("Sladoled2");
		prodavnica.dodajProizvod(p2);
		
		prodavnica.izbrisiProizvod(p2);
		assertEquals(p, prodavnica.getProizvodi().get(0));
		assertEquals(1, prodavnica.getProizvodi().size());
		
	}

	/**
	 * Test method for {@link prodavnica.Prodavnica#dodajKupca(prodavnica.Kupac)}.
	 */
	@Test
	public void testDodajKupca() {
		Kupac k = new Kupac();
		k.setKolicina(2000);
		k.setId("1");
		k.setIme("ime");
		prodavnica.dodajKupca(k);
		
		assertEquals(k, prodavnica.getKupci().get(0));
		assertEquals(1, prodavnica.getKupci().size());
	}

	/**
	 * Test method for {@link prodavnica.Prodavnica#dodajDobavljaca(nabavka.Dobavljac)}.
	 */
	@Test
	public void testDodajDobavljaca() {
		Dobavljac d = new Dobavljac();
		d.setAdresa("adresa");
		d.setDobavljacId("1");
		d.setIme("ime");
		d.setTelefon("telefon");
		
		prodavnica.dodajDobavljaca(d);
		
		assertEquals(d, prodavnica.getDobavljaci().get(0));
		assertEquals(1, prodavnica.getDobavljaci().size());
	}

	/**
	 * Test method for {@link prodavnica.Prodavnica#izbrisiKupca(prodavnica.Kupac)}.
	 */
	@Test
	public void testIzbrisiKupca() {
		Kupac k = new Kupac();
		k.setKolicina(2000);
		k.setId("1");
		k.setIme("ime");
		prodavnica.dodajKupca(k);
		
		prodavnica.izbrisiKupca(k);
		
		assertEquals(0, prodavnica.getKupci().size());
	}

	/**
	 * Test method for {@link prodavnica.Prodavnica#izbrisiDobavljaca(nabavka.Dobavljac)}.
	 */
	@Test
	public void testIzbrisiDobavljaca() {
		Dobavljac d = new Dobavljac();
		d.setAdresa("adresa");
		d.setDobavljacId("1");
		d.setIme("ime");
		d.setTelefon("telefon");
		
		prodavnica.dodajDobavljaca(d);
		prodavnica.izbrisiDobavljaca(d);
		
		assertEquals(0, prodavnica.getDobavljaci().size());
	}

	/**
	 * Test method for {@link prodavnica.Prodavnica#proveriIdProizvoda(java.lang.String)}.
	 */
	@Test
	public void testProveriIdProizvoda() {
		Proizvod p = new Proizvod();
		p.setCena(50);
		p.setId("1");
		p.setKolicina(10);
		p.setNaziv("Sladoled");
		prodavnica.dodajProizvod(p);
		
		assertFalse(prodavnica.proveriIdProizvoda("1"));
	}

	/**
	 * Test method for {@link prodavnica.Prodavnica#proveriIdKupca(java.lang.String)}.
	 */
	@Test
	public void testProveriIdKupca() {
		Kupac k = new Kupac();
		k.setKolicina(2000);
		k.setId("1");
		k.setIme("ime");
		prodavnica.dodajKupca(k);
		
		assertFalse(prodavnica.proveriIdKupca("1"));
	}

	/**
	 * Test method for {@link prodavnica.Prodavnica#proveriIdDobavljaca(java.lang.String)}.
	 */
	@Test
	public void testProveriIdDobavljaca() {
		Dobavljac d = new Dobavljac();
		d.setAdresa("adresa");
		d.setDobavljacId("1");
		d.setIme("ime");
		d.setTelefon("telefon");
		
		prodavnica.dodajDobavljaca(d);
		
		assertFalse(prodavnica.proveriIdDobavljaca("1"));
	}

}
