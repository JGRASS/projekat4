package sistemskeoperacije;

import java.util.LinkedList;

import nabavka.Dobavljac;

public class SOPronadjiDobavljaca {
	
	public static Dobavljac pronadjiProizvod(String ime, LinkedList<Dobavljac> dobavljaci) {
		for (int i = 0; i < dobavljaci.size(); i++) {
			if (dobavljaci.get(i).getIme().equals(ime)) {
				return dobavljaci.get(i);
			}
		}
		return null;
	}

}
