package sistemskeoperacije;

import java.util.LinkedList;

import prodavnica.Proizvod;;

public class SOPronadjiProizvod {
	/**
	 * Metoda koja nam vraca objekat klase Proizvod, na osnovu unetog naziva proizvoda.
	 * @param naziv naziv proizvoda koji zelimo da pronadjemo
	 * @param proizvodi lista proizvoda.
	 * @return <ul>
	 * <li>objekat klase Proizvod, ukoliko u listi proizvoda postoji objekat sa datim nazivom.</li>
	 * <li>Null, ukoliko objekat ne postoji u listi.</li>
	 * </ul>
	 */
	public static Proizvod pronadjiProizvod(String naziv, LinkedList<Proizvod> proizvodi) {
		for (int i = 0; i < proizvodi.size(); i++) {
			if (proizvodi.get(i).getNaziv().equalsIgnoreCase(naziv)) {
				return proizvodi.get(i);
			}
		}
		return null;
	}


}
