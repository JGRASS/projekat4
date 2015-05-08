package sistemskeoperacije;

import java.util.LinkedList;

import nabavka.Dobavljac;

public class SODodajDobavljaca {

	public static void dodajDobavljaca(Dobavljac p, LinkedList<Dobavljac> dobavljaci){
		dobavljaci.add(p);
	}
}
