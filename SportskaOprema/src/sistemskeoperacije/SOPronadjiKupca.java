package sistemskeoperacije;

import java.util.LinkedList;

import prodavnica.Kupac;

public class SOPronadjiKupca {
	
	public static Kupac pronadjiKupca(String ime, LinkedList<Kupac> kupci) {
		for (int i = 0; i < kupci.size(); i++) {
			if (kupci.get(i).getIme().equals(ime)) {
				return kupci.get(i);
			}
		}
		return null;
	}

}
