package sistemskeoperacije;

import java.util.LinkedList;

import nabavka.Dobavljac;

public class SOIzbrisiDobavljaca {
	/**
	 * Metoda koja iz liste dobavljaca izbacuje odredjenog dobavljaca.
	 * @param p dobavljac kog zelimo da izbacimo.
	 * @param dobavljaci lista dobavljaca.
	 */
	public static void izbrisiDobavljaca(Dobavljac p, LinkedList<Dobavljac> dobavljaci){
		if(dobavljaci.contains(p))
			dobavljaci.remove(p);
	}
}
