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

public class Prodavnica {
	
	private double tekuciRacun;
	private LinkedList<Kupac> kupci = new LinkedList<Kupac>();
	private LinkedList<Proizvod> proizvodi = new LinkedList<Proizvod>();
	private LinkedList<Dobavljac> dobavljaci = new LinkedList<Dobavljac>();
	private LinkedList<Zaposleni> zaposleni = new LinkedList<Zaposleni>();
	
	public void naruci(Proizvod p, Dobavljac d) {
			SONaruci.naruci(d, p, proizvodi, tekuciRacun, dobavljaci);
	}
	
	public boolean daLiImaPopust(Kupac kupac) {
		return SODaLiImaPopust.daLiImaPopust(kupac, kupci);
	}
	
	public void primiNarudzbinu(Kupac k, Proizvod p) {
		tekuciRacun= SOPrimiNarudzbinu.primiNarudzbinu(k, p, kupci, proizvodi, tekuciRacun);
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
	
	public void dodajZaposlenog(String ime,String prezime,String pol,String brTelefona,String Id_zaposlenog,String adresa) {
		SODodajZaposlenog.dodajZaposlenog(ime, prezime, pol, brTelefona, Id_zaposlenog, adresa, zaposleni);
	}
	
	public void otpustiZaposlenog(Zaposleni z) {
		SOOtpustiZaposlenog.otpustiZaposlenog(z, zaposleni);
	}

	public double getTekuciRacun() {
		return tekuciRacun;
	}

	public void setTekuciRacun(double tekuciRacun) {
		this.tekuciRacun = tekuciRacun;
	}

	public LinkedList<Kupac> getKupci() {
		return kupci;
	}

	public void setKupci(LinkedList<Kupac> kupci) {
		this.kupci = kupci;
	}

	public LinkedList<Proizvod> getProizvodi() {
		return proizvodi;
	}

	public void setProizvodi(LinkedList<Proizvod> proizvodi) {
		this.proizvodi = proizvodi;
	}

	public LinkedList<Dobavljac> getDobavljaci() {
		return dobavljaci;
	}

	public void setDobavljaci(LinkedList<Dobavljac> dobavljaci) {
		this.dobavljaci = dobavljaci;
	}

	public LinkedList<Zaposleni> getZaposleni() {
		return zaposleni;
	}

	public void setZaposleni(LinkedList<Zaposleni> zaposleni) {
		this.zaposleni = zaposleni;
	}
    
    public LinkedList<Proizvod> prikaziSveProizvode(){
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
}
