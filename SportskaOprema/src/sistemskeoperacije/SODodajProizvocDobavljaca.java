package sistemskeoperacije;

import java.util.LinkedList;

import nabavka.Dobavljac;
import prodavnica.Proizvod;

public class SODodajProizvocDobavljaca {
	/**
	 * Metoda pridruzuje odgovarajuci proizvod dobavljacu.
	 * @param p proizvod koji treba dodati dobavljacu.
	 * @param d dobavljac kome se proizvod dodaje.
	 * @param dobavljaci lista svih dobavljaca.
	 */
	public static void dodaj(Proizvod p, Dobavljac d, LinkedList<Dobavljac> dobavljaci) {
		for (int i = 0; i < dobavljaci.size(); i++) {
			if (dobavljaci.get(i).equals(d)) {
				dobavljaci.get(i).getProizvodi().add(p);
			}
		}
	}

}
