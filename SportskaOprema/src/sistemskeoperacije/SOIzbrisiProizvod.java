package sistemskeoperacije;

import java.util.LinkedList;

import prodavnica.Proizvod;

public class SOIzbrisiProizvod {
	/**
	 * Metoda koja brise proizvod iz liste.
	 * @param p proizvod koji treba da bude obrisan.
	 * @param proizvodi lista proizvoda.
	 */
	public static void izbrisiProizvod(Proizvod p,LinkedList<Proizvod> proizvodi){
		if(proizvodi.contains(p))proizvodi.remove(p);
	}
}
