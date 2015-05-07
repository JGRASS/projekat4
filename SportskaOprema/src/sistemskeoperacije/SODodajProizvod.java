package sistemskeoperacije;

import java.util.LinkedList;

import prodavnica.Proizvod;

public class SODodajProizvod {
	
	public static void dodajProizvod(Proizvod p, LinkedList<Proizvod> proizvodi) {
		proizvodi.add(p);
	}

}
