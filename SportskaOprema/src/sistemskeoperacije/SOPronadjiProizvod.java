package sistemskeoperacije;

import java.util.LinkedList;

import prodavnica.Proizvod;;

public class SOPronadjiProizvod {
	
	public static Proizvod pronadjiProizvod(String naziv, LinkedList<Proizvod> proizvodi) {
		for (int i = 0; i < proizvodi.size(); i++) {
			if (proizvodi.get(i).getNaziv().equals(naziv)) {
				return proizvodi.get(i);
			}
		}
		return null;
	}


}
