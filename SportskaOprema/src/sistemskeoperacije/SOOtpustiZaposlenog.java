package sistemskeoperacije;

import java.util.LinkedList;

import prodavnica.Zaposleni;

public class SOOtpustiZaposlenog {
	
	public static void otpustiZaposlenog(Zaposleni zaposleni, LinkedList<Zaposleni> listaZaposlenih) {
		if(!listaZaposlenih.contains(zaposleni)) {
			throw new RuntimeException("Trazeni zaposleni se ne nalazi na spisku zaposlenih radnika.");
		} else {
			listaZaposlenih.remove(zaposleni);
		}
		
	}

}
