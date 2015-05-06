package prodavnica;

import java.util.LinkedList;

import sistemskeoperacije.SODaLiImaPopust;
import sistemskeoperacije.SONaruci;
import sistemskeoperacije.SOPrimiNarudzbinu;
import nabavka.Dobavljac;

public class Prodavnica {
	
	private double tekuciRacun;
	private LinkedList<Kupac> kupci = new LinkedList<Kupac>();
	private LinkedList<Proizvod> proizvodi = new LinkedList<Proizvod>();
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
    
}
