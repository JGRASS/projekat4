package sistemskeoperacije;

import java.util.LinkedList;

import prodavnica.Kupac;

public class SOPronadjiKupca {
	/**
	 * Metoda koja nam vraca objekat klase Kupac, na osnovu unetog imena kupca.
	 * @param ime ime kupca kog zelimo da pronadjemo.
	 * @param kupci lista kupaca.
	 * @return <ul>
	 * <li>objekat klase Kupac, ukoliko u listi kupaca postoji objekat sa datim imenom.</li>
	 * <li>Null, ukoliko objekat ne postoji u listi.</li>
	 * </ul>
	 */
	public static Kupac pronadjiKupca(String ime, LinkedList<Kupac> kupci) {
		for (int i = 0; i < kupci.size(); i++) {
			if (kupci.get(i).getIme().equals(ime)) {
				return kupci.get(i);
			}
		}
		return null;
	}

}
