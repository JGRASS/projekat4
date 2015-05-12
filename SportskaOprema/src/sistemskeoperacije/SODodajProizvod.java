package sistemskeoperacije;

import java.util.LinkedList;

import prodavnica.Proizvod;

public class SODodajProizvod {
	/**
	 * Metoda dodaje proizvod na spisak svih proizvoda.
	 * @param p proivod koji treba dodati.
	 * @param proizvodi lista svih porizvoda.
	 */
	public static void dodajProizvod(Proizvod p, LinkedList<Proizvod> proizvodi) {
		proizvodi.add(p);
	}

}
