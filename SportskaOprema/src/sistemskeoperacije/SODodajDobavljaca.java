package sistemskeoperacije;

import java.util.LinkedList;

import nabavka.Dobavljac;

public class SODodajDobavljaca {
	/**
	 * Dodaje objekat klase Dobabljac u listu svih dobavljaca.
	 * @param p objekat klase Dobavljac koji treba da se doda u listu.
	 * @param dobavljaci lista svih dobavljaca.
	 */
	public static void dodajDobavljaca(Dobavljac p, LinkedList<Dobavljac> dobavljaci){
		dobavljaci.add(p);
	}
}
