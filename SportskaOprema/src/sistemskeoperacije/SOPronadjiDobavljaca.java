package sistemskeoperacije;

import java.util.LinkedList;

import nabavka.Dobavljac;

public class SOPronadjiDobavljaca {
	/**
	 * Metoda koja nam vraca objekat klase Dobavljac, na osnovu unetog imena dobavljaca.
	 * @param ime ime dobavljaca kog zelimo da pronadjemo
	 * @param dobavljaci lista dobavljaca
	 * @return <ul>
	 * <li>objekat klase Dobavljac, ukoliko u listi dobavljaca postoji objekat sa datim imenom.</li>
	 * <li>Null, ukoliko objekat ne postoji u listi.</li>
	 * </ul>
	 */
	public static Dobavljac pronadjiProizvod(String ime, LinkedList<Dobavljac> dobavljaci) {
		for (int i = 0; i < dobavljaci.size(); i++) {
			if (dobavljaci.get(i).getIme().equals(ime)) {
				return dobavljaci.get(i);
			}
		}
		return null;
	}

}
