package sistemskeoperacije;

import java.util.LinkedList;

import prodavnica.Kupac;

public class SODodajKupca {
	/**
	 * Metoda koja dodaje objekat klase Kupac u listu svih kupaca.
	 * @param kupac objekat klase Kupac koji treba da bude dodat u listu.
	 * @param kupci Lista svih kupaca.
	 */
	public static void dodajKupca(Kupac kupac, LinkedList<Kupac> kupci){
		kupci.add(kupac);
		
	}
}
