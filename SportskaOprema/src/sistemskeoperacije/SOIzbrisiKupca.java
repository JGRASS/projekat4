package sistemskeoperacije;

import java.util.LinkedList;

import prodavnica.Kupac;

public class SOIzbrisiKupca {
	/**
	 * Metoda koja iz liste kupaca izbacuje odredjenog kupca.
	 * @param p kupac kog zelimo da izbacimo.
	 * @param kupci lista kupaca.
	 */
	public static void izbrisiKupca(Kupac p, LinkedList<Kupac> kupci){
		if(kupci.contains(p))
			kupci.remove(p);
	}
}
