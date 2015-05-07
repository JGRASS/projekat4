package prodavnica;

import java.util.LinkedList;

import sistemskeoperacije.SODaLiImaPopust;
import sistemskeoperacije.SODodajProizvod;
import sistemskeoperacije.SOIzbrisiProizvod;
import sistemskeoperacije.SONaruci;
import sistemskeoperacije.SOPrikaziSveProizvode;
import sistemskeoperacije.SOPrimiNarudzbinu;
import sistemskeoperacije.SOPronadjiDobavljaca;
import sistemskeoperacije.SOPronadjiKupca;
import sistemskeoperacije.SOPronadjiProizvod;
import nabavka.Dobavljac;

public class Prodavnica {
	
	private double tekuciRacun;
	private LinkedList<Kupac> kupci = new LinkedList<Kupac>();
	private LinkedList<Proizvod> proizvodi = new LinkedList<Proizvod>();
	public LinkedList<Proizvod> getProizvodi() {
		return proizvodi;
	}

	private LinkedList<Dobavljac> dobavljaci = new LinkedList<Dobavljac>();
	
	public void naruci(Proizvod p, Dobavljac d) {
		SONaruci.naruci(d, p, proizvodi, tekuciRacun, dobavljaci);
	}
	
	public void daLiImaPopust(Kupac kupac) {
		SODaLiImaPopust.daLiImaPopust(kupac, kupci);
	}
	
	public void primiNarudzbinu(Kupac k, Proizvod p) {
		SOPrimiNarudzbinu.primiNarudzbinu(k, p, kupci, proizvodi, tekuciRacun);
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
    public LinkedList<Proizvod> prikaziSveProizvode(){
    	return SOPrikaziSveProizvode.vratiSveProizvode(proizvodi);
    }

	public void izbrisiProizvod(Proizvod p) {
		SOIzbrisiProizvod.izbrisiProizvod(p, proizvodi);
		
	}
}
