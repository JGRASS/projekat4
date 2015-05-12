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
 * Predstavlja klasu nase prodavnice. Dokumentacija za vecinu metoda iz ove
 * klase je uradjena u okviru sistemskih operacija.
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

	/**
	 * Metoda kojom narucujemo odredjenu kolicinu proizvoda od dobavljaca.
	 * 
	 * @param p
	 *            proizvod koji zelimo da narucimo
	 * @param d
	 *            dobavljac od kog vrsimo narucivanje
	 */
	public void naruci(Proizvod p, Dobavljac d) {
		tekuciRacun = SONaruci.naruci(d, p, proizvodi, tekuciRacun, dobavljaci);
	}

	/**
	 * Metoda provarava da li kupac ostvaruje pravo na popust. Pravo na popust
	 * se ostvaruje ukoliko je kupac u nasoj prodavnici potrosio vise od 10000
	 * dinara.
	 * 
	 * @param kupac
	 *            objekat klase kupac za koji se proverava da li ima popust
	 * @return <ul>
	 *         <li>true, ukoliko kupac ima popust.</li>
	 *         <li>false, ukoliko kupac nema pravo na popust.</li>
	 *         </ul>
	 */
	public boolean daLiImaPopust(Kupac kupac) {
		return SODaLiImaPopust.daLiImaPopust(kupac, kupci);
	}

	/**
	 * Metoda koja sluzi za primanje narudzbine, kao povratna vrednost se dobija
	 * iznos racuna.
	 * 
	 * @param k
	 *            kupac koji vrsi narudzbinu
	 * @param p
	 *            proizvod koji se narucuje
	 */
	public void primiNarudzbinu(Kupac k, Proizvod p) {
		tekuciRacun = SOPrimiNarudzbinu.primiNarudzbinu(k, p, kupci, proizvodi,
				tekuciRacun);
	}

	/**
	 * Metoda koja nam vraca objekat klase Kupac, na osnovu unetog imena kupca.
	 * 
	 * @param ime
	 *            ime kupca kojeg zelimo da pronadjemo
	 * @return <ul>
	 *         <li>objekat klase Kupac, ukoliko u listi proizvoda postoji
	 *         objekat sa datim imenom.</li>
	 *         <li>Null, ukoliko objekat ne postoji u listi.</li>
	 *         </ul>
	 */
	public Kupac prondadjiKupca(String ime) {
		return SOPronadjiKupca.pronadjiKupca(ime, kupci);
	}

	/**
	 * Metoda koja nam vraca objekat klase Proizvod, na osnovu unetog naziva
	 * proizvoda.
	 * 
	 * @param naziv
	 *            proizvoda koji zelimo da pronadjemo
	 * @return <ul>
	 *         <li>objekat klase Proizvod, ukoliko u listi proizvoda postoji
	 *         objekat sa datim nazivom.</li>
	 *         <li>Null, ukoliko objekat ne postoji u listi.</li>
	 *         </ul>
	 */
	public Proizvod pronadjiProizvod(String naziv) {
		return SOPronadjiProizvod.pronadjiProizvod(naziv, proizvodi);
	}

	/**
	 * Metoda koja nam vraca objekat klase Dobavljac, na osnovu unetog imena
	 * dobavljaca.
	 * 
	 * @param ime
	 *            ime dobavljaca
	 * @return objekat klase Dobavljac sa trazenim imenom
	 */
	public Dobavljac pronadjiDobavljaca(String ime) {
		return SOPronadjiDobavljaca.pronadjiProizvod(ime, dobavljaci);
	}

	/**
	 * Metoda dodaje proizvod na spisak svih proizvoda.
	 * 
	 * @param p
	 *            proivod koji treba dodati.
	 */
	public void dodajProizvod(Proizvod p) {
		SODodajProizvod.dodajProizvod(p, proizvodi);
	}

	/**
	 * Metoda dodaje zaposlenog na listu zaposlenih.
	 * 
	 * @param ime
	 *            ime zaposlenog
	 * @param prezime
	 *            prezime zaposlenog
	 * @param pol
	 *            pol zaposlenog
	 * @param brTelefona
	 *            broj telefona zaposlenog
	 * @param Id_zaposlenog
	 *            jedinstveni identifikator zaposlenog
	 * @param adresa
	 *            adresa zaposlenog
	 */
	public void dodajZaposlenog(String ime, String prezime, String pol,
			String brTelefona, String Id_zaposlenog, String adresa) {
		SODodajZaposlenog.dodajZaposlenog(ime, prezime, pol, brTelefona,
				Id_zaposlenog, adresa, zaposleni);
	}

	/**
	 * Metoda kojom se odredjeni zaposleni izbacuje iz liste zaposlenih osoba.
	 * 
	 * @param z
	 *            zaposleni kog zelimo da izbacimo.
	 */
	public void otpustiZaposlenog(Zaposleni z) {
		SOOtpustiZaposlenog.otpustiZaposlenog(z, zaposleni);
	}

	/**
	 * metoda vraca stanje na tekucem racunu
	 * 
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
	 * 
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
	 * 
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
	 * 
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
	 * 
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

	/**
	 * Metoda koja prikazuje listu svih proizvoda.
	 * 
	 * @return lista proizvoda.
	 */
	public LinkedList<Proizvod> prikaziSveProizvode() {
		return SOPrikaziSveProizvode.vratiSveProizvode(proizvodi);
	}

	/**
	 * Metoda koja brise proizvod iz liste.
	 * 
	 * @param p
	 *            proizvod koji treba da bude obrisan
	 */
	public void izbrisiProizvod(Proizvod p) {
		SOIzbrisiProizvod.izbrisiProizvod(p, proizvodi);

	}

	/**
	 * Metoda koja dodaje objekat klase Kupac u listu svih kupaca.
	 * 
	 * @param p
	 *            objekat klase Kupac koji treba da bude dodat u listu.
	 */
	public void dodajKupca(Kupac p) {
		SODodajKupca.dodajKupca(p, kupci);

	}

	/**
	 * Dodaje objekat klase Dobabljac u listu svih dobavljaca.
	 * 
	 * @param p
	 *            objekat klase Dobavljac koji treba da se doda u listu.
	 */
	public void dodajDobavljaca(Dobavljac p) {
		SODodajDobavljaca.dodajDobavljaca(p, dobavljaci);

	}

	/**
	 * Metoda koja prikazuje listu svih kupaca.
	 * 
	 * @return lista kupaca.
	 */
	public LinkedList<Kupac> prikaziSveKupce() {

		return SOPrikaziSveKupce.prikaziSveKupce(kupci);
	}

	/**
	 * Metoda koja prikazuje listu svih dobavljaca
	 * 
	 * @return lista dobavljaca.
	 */
	public LinkedList<Dobavljac> prikaziSveDobavljace() {

		return SOPrikaziSveDobavljace.prikaziSveDobavljace(dobavljaci);
	}

	/**
	 * Metoda koja iz liste kupaca izbacuje odredjenog kupca.
	 * 
	 * @param p
	 *            objekat klase Kupac kog zelimo da izbacimo
	 */
	public void izbrisiKupca(Kupac p) {
		SOIzbrisiKupca.izbrisiKupca(p, kupci);

	}

	/**
	 * Metoda koja iz liste dobavljaca izbacuje odredjenog dobavljaca.
	 * 
	 * @param p
	 *            dobavljac kog zelimo da izbacimo
	 */
	public void izbrisiDobavljaca(Dobavljac p) {
		SOIzbrisiDobavljaca.izbrisiDobavljaca(p, dobavljaci);

	}

	/**
	 * Metoda vrsi serijalizaciju liste dobavljaca
	 * 
	 * @param putanja
	 *            metoda koja vrsi serijalizaciju liste kupaca.
	 */
	public void sacuvajUFajlDobavljac(String putanja) {
		SOSacuvajUFajlDobavljac.sacuvajUFajl(putanja, dobavljaci);
	}

	/**
	 * metoda koja vrsi serijalizaciju liste kupaca
	 * 
	 * @param putanja
	 *            mesto gde ce se sacuvati fajl.
	 */
	public void sacuvajUFajlKupac(String putanja) {
		SOSacuvajUFajlKupac.sacuvajUFajl(putanja, kupci);
	}

	/**
	 * Metoda koja vrsi serijalizaciju liste zaposlenih
	 * 
	 * @param putanja
	 *            mesto gde ce se sacuvati fajl.
	 */
	public void sacuvajUFajlZaposleni(String putanja) {
		SOSacuvajUFajlZaposleni.sacuvajUFajl(putanja, zaposleni);
	}

	/**
	 * Metoda koja vrsi deserijalizaciju fajla u kome se nalazi lista dobavljaca
	 * 
	 * @param putanja
	 *            lokacija fajla iz kog se vrsi ucitavanje.
	 */
	public void ucitajUFajlDobavljac(String putanja) {
		SOUcitajIzFajlaDobavljac.ucitajIzFajla(putanja, dobavljaci);
	}

	/**
	 * Metoda koja vrsi deserijalizaciju liste kupaca
	 * 
	 * @param putanja
	 *            lokacija fajla iz kog se vrsi ucitavanje.
	 */
	public void ucitajUFajlKupac(String putanja) {
		SOUcitajIzFajlaKupac.ucitajIzFajla(putanja, kupci);
	}

	/**
	 * Metoda koja vrsi deserijalizaciju liste zaposlenih.
	 * 
	 * @param putanja
	 *            lokacija fajla iz kog se vrsi ucitavanje.
	 */
	public void ucitajUFajlZaposleni(String putanja) {
		SOUcitajIzFajlaZaposleni.ucitajIzFajla(putanja, zaposleni);
	}

	/**
	 * Metoda proverava da li je identifikacioni broj proizvoda vec zauzet.
	 * 
	 * @param id
	 *            identifikacioni broj za koji vrsimo proveru.
	 * @return <ul>
	 *         <li>false, ukoliko je zauzet</li>
	 *         <li>true, ukoliko je slobodan</li>
	 *         </ul>
	 */
	public boolean proveriIdProizvoda(String id) {
		return SOProveriIdProizvoda.proveriIdProizvoda(id, proizvodi);

	}

	/**
	 * Metoda proverava da li je identifikacioni broj dobavljaca vec zauzet
	 * 
	 * @param id
	 *            identifikacioni broj kupca za kog vrsimo proveru
	 * @return <ul>
	 *         <li>false, ukoliko je zauzet</li>
	 *         <li>true, ukoliko je slobodan</li>
	 *         </ul>
	 */
	public boolean proveriIdKupca(String id) {

		return SOProveriIdKupca.proveriIdKupca(id, kupci);
	}

	/**
	 * Metoda proverava da li je identifikacioni broj dobavljaca vec zauzet
	 * 
	 * @param id
	 *            identifikacioni broj dobavljaca
	 * @return <ul>
	 *         <li>false, ukoliko je zauzet</li>
	 *         <li>true, ukoliko je slobodan</li>
	 *         </ul>
	 */
	public boolean proveriIdDobavljaca(String id) {

		return SOProveriIdDobavljaca.proveriIdDobavljaca(id, dobavljaci);
	}

	/**
	 * dodaje proizvod u listu proizvoda
	 * 
	 * @param p
	 *            objekat klase Proizvod koji dodajemo
	 * @param d
	 *            Dobavljac od kog smo nabavili proizvod
	 */
	public void dodajProizvodDobavljaca(Proizvod p, Dobavljac d) {
		SODodajProizvocDobavljaca.dodaj(p, d, dobavljaci);
	}

	/**
	 * pronalazi dobavljaca u listi dobavljaca, na osnovu jedinstvenog
	 * identifikatora.
	 * 
	 * @param id
	 *            jedinstveni identifikator dobavljaca
	 * @return objekat klase Dobavljac
	 */
	public Dobavljac pretraziDobavljace(String id) {

		return SOPretraziDobavljace.pretraziDobavljace(id, dobavljaci);
	}
}
