package prodavnica;

import java.util.LinkedList;

import sistemskeoperacije.SODaLiImaPopust;
import sistemskeoperacije.SODodajDobavljaca;
import sistemskeoperacije.SODodajKupca;
import sistemskeoperacije.SODodajProizvocDobavljaca;
import sistemskeoperacije.SODodajProizvod;
import sistemskeoperacije.SODodajZaposlenog;
import sistemskeoperacije.SOIzbrisiDobavljaca;
import sistemskeoperacije.SOIzbrisiKupca;
import sistemskeoperacije.SOIzbrisiProizvod;
import sistemskeoperacije.SONaruci;
import sistemskeoperacije.SOOtpustiZaposlenog;
import sistemskeoperacije.SOPretraziDobavljace;
import sistemskeoperacije.SOPrikaziSveDobavljace;
import sistemskeoperacije.SOPrikaziSveKupce;
import sistemskeoperacije.SOPrikaziSveProizvode;
import sistemskeoperacije.SOPrimiNarudzbinu;
import sistemskeoperacije.SOPronadjiDobavljaca;
import sistemskeoperacije.SOPronadjiKupca;
import sistemskeoperacije.SOPronadjiProizvod;
import sistemskeoperacije.SOProveriIdDobavljaca;
import sistemskeoperacije.SOProveriIdKupca;
import sistemskeoperacije.SOProveriIdProizvoda;
import sistemskeoperacije.SOSacuvajUFajlDobavljac;
import sistemskeoperacije.SOSacuvajUFajlKupac;
import sistemskeoperacije.SOSacuvajUFajlZaposleni;
import sistemskeoperacije.SOUcitajIzFajlaDobavljac;
import sistemskeoperacije.SOUcitajIzFajlaKupac;
import sistemskeoperacije.SOUcitajIzFajlaZaposleni;
import nabavka.Dobavljac;

/**
 * Predstavlja klasu nase prodavnice. 
 * Dokumentacija za vecinu metoda iz ove klase je uradjena u okviru sistemskih operacija.
 * 
 */
public class Prodavnica {
	/**
	 * predstavlja tekuci racun nase prodavnice
	 */
	private double tekuciRacun = 1000;
	/**
	 * predstavlja listu kupaca
	 */
	private LinkedList<Kupac> kupci = new LinkedList<Kupac>();
	/**
	 * predstavlja listu proizvoda koji se nalaze u prodavnici
	 */
	private LinkedList<Proizvod> proizvodi = new LinkedList<Proizvod>();
	/**
	 * predstavlja listu dobavljaca
	 */
	private LinkedList<Dobavljac> dobavljaci = new LinkedList<Dobavljac>();
	/**
	 * predstavlja listu zaposlenih radnika
	 */
	private LinkedList<Zaposleni> zaposleni = new LinkedList<Zaposleni>();

	public void naruci(Proizvod p, Dobavljac d) {
		tekuciRacun = SONaruci.naruci(d, p, proizvodi, tekuciRacun, dobavljaci);
	}

	public boolean daLiImaPopust(Kupac kupac) {
		return SODaLiImaPopust.daLiImaPopust(kupac, kupci);
	}

	public void primiNarudzbinu(Kupac k, Proizvod p) {
		tekuciRacun = SOPrimiNarudzbinu.primiNarudzbinu(k, p, kupci, proizvodi,
				tekuciRacun);
	}

	public Kupac prondadjiKupca(String ime) {
		return SOPronadjiKupca.pronadjiKupca(ime, kupci);
	}

	public Proizvod pronadjiProizvod(String naziv) {
		return SOPronadjiProizvod.pronadjiProizvod(naziv, proizvodi);
	}

	public Dobavljac pronadjiDobavljaca(String ime) {
		return SOPronadjiDobavljaca.pronadjiProizvod(ime, dobavljaci);
	}

	public void dodajProizvod(Proizvod p) {
		SODodajProizvod.dodajProizvod(p, proizvodi);
	}

	public void dodajZaposlenog(String ime, String prezime, String pol,
			String brTelefona, String Id_zaposlenog, String adresa) {
		SODodajZaposlenog.dodajZaposlenog(ime, prezime, pol, brTelefona,
				Id_zaposlenog, adresa, zaposleni);
	}

	public void otpustiZaposlenog(Zaposleni z) {
		SOOtpustiZaposlenog.otpustiZaposlenog(z, zaposleni);
	}
	/**
	 * metoda vraca stanje na tekucem racunu
	 * @return stanje na tekucem racunu kao Double
	 */
	public double getTekuciRacun() {
		return tekuciRacun;
	}

	/**
	 * postavlja vrednost tekuceg racuna na novounesenu
	 * 
	 * @param tekuciRacun
	 *            novounesena vrednost
	 */
	public void setTekuciRacun(double tekuciRacun) {
		this.tekuciRacun = tekuciRacun;
	}
	/**
	 * metoda izlistava sve kupce
	 * @return lista kupaca
	 */
	public LinkedList<Kupac> getKupci() {
		return kupci;
	}

	/**
	 * postavlja listu kupaca na novounesenu listu
	 * 
	 * @param kupci
	 *            novounesena lista kupaca
	 */
	public void setKupci(LinkedList<Kupac> kupci) {
		this.kupci = kupci;
	}
	/**
	 * metoda izlistava sve proizvode
	 * @return lista proizvoda
	 */
	public LinkedList<Proizvod> getProizvodi() {
		return proizvodi;
	}

	/**
	 * postavlja listu proizvoda na novouneseu listu
	 * 
	 * @param proizvodi
	 *            novounesena lista proizvoda
	 */
	public void setProizvodi(LinkedList<Proizvod> proizvodi) {
		this.proizvodi = proizvodi;
	}
	/**
	 * metoda izlistava sve dobavljace
	 * @return lista dobavljaca
	 */
	public LinkedList<Dobavljac> getDobavljaci() {
		return dobavljaci;
	}

	/**
	 * postavlja listu dobavljaca na novounesenu
	 * 
	 * @param dobavljaci
	 *            novounesena lista dobavljaca
	 */
	public void setDobavljaci(LinkedList<Dobavljac> dobavljaci) {
		this.dobavljaci = dobavljaci;
	}
	/**
	 * metoda izlistava sve zaposlene
	 * @return lista zaposlenih
	 */
	public LinkedList<Zaposleni> getZaposleni() {
		return zaposleni;
	}

	/**
	 * postavlja vrednost liste zaposleni na novounesenu vrednost
	 * 
	 * @param zaposleni
	 *            novounesena vrednost
	 */
	public void setZaposleni(LinkedList<Zaposleni> zaposleni) {
		this.zaposleni = zaposleni;
	}

	public LinkedList<Proizvod> prikaziSveProizvode() {
		return SOPrikaziSveProizvode.vratiSveProizvode(proizvodi);
	}

	public void izbrisiProizvod(Proizvod p) {
		SOIzbrisiProizvod.izbrisiProizvod(p, proizvodi);

	}

	public void dodajKupca(Kupac p) {
		SODodajKupca.dodajKupca(p, kupci);

	}

	public void dodajDobavljaca(Dobavljac p) {
		SODodajDobavljaca.dodajDobavljaca(p, dobavljaci);

	}

	public LinkedList<Kupac> prikaziSveKupce() {

		return SOPrikaziSveKupce.prikaziSveKupce(kupci);
	}

	public LinkedList<Dobavljac> prikaziSveDobavljace() {

		return SOPrikaziSveDobavljace.prikaziSveDobavljace(dobavljaci);
	}

	public void izbrisiKupca(Kupac p) {
		SOIzbrisiKupca.izbrisiKupca(p, kupci);

	}

	public void izbrisiDobavljaca(Dobavljac p) {
		SOIzbrisiDobavljaca.izbrisiDobavljaca(p, dobavljaci);

	}

	public void sacuvajUFajlDobavljac(String putanja) {
		SOSacuvajUFajlDobavljac.sacuvajUFajl(putanja, dobavljaci);
	}

	public void sacuvajUFajlKupac(String putanja) {
		SOSacuvajUFajlKupac.sacuvajUFajl(putanja, kupci);
	}

	public void sacuvajUFajlZaposleni(String putanja) {
		SOSacuvajUFajlZaposleni.sacuvajUFajl(putanja, zaposleni);
	}

	public void ucitajUFajlDobavljac(String putanja) {
		SOUcitajIzFajlaDobavljac.ucitajIzFajla(putanja, dobavljaci);
	}

	public void ucitajUFajlKupac(String putanja) {
		SOUcitajIzFajlaKupac.ucitajIzFajla(putanja, kupci);
	}

	public void ucitajUFajlZaposleni(String putanja) {
		SOUcitajIzFajlaZaposleni.ucitajIzFajla(putanja, zaposleni);
	}

	public boolean proveriIdProizvoda(String id) {
		return SOProveriIdProizvoda.proveriIdProizvoda(id, proizvodi);

	}

	public boolean proveriIdKupca(String id) {

		return SOProveriIdKupca.proveriIdKupca(id, kupci);
	}

	public boolean proveriIdDobavljaca(String id) {

		return SOProveriIdDobavljaca.proveriIdDobavljaca(id, dobavljaci);
	}

	public void dodajProizvodDobavljaca(Proizvod p, Dobavljac d) {
		SODodajProizvocDobavljaca.dodaj(p, d, dobavljaci);
	}

	public Dobavljac pretraziDobavljace(String id) {

		return SOPretraziDobavljace.pretraziDobavljace(id, dobavljaci);
	}
}
