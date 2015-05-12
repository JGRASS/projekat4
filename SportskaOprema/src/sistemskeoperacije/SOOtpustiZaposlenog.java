package sistemskeoperacije;

import java.util.LinkedList;

import prodavnica.Zaposleni;

public class SOOtpustiZaposlenog {
	/**
	 * Metoda kojom se odredjeni zaposleni izbacuje iz liste zaposlenih osoba.
	 * @param zaposleni zaposleni kog zelimo da izbacimo.
	 * @param listaZaposlenih lista zaposlenih osoba.
	 */
	public static void otpustiZaposlenog(Zaposleni zaposleni, LinkedList<Zaposleni> listaZaposlenih) {
		if(!listaZaposlenih.contains(zaposleni)) {
			throw new RuntimeException("Trazeni zaposleni se ne nalazi na spisku zaposlenih radnika.");
		} else {
			listaZaposlenih.remove(zaposleni);
		}
		
	}

}
