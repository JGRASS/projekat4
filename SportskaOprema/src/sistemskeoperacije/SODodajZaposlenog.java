package sistemskeoperacije;

import java.util.LinkedList;

import prodavnica.Zaposleni;

public class SODodajZaposlenog {
	/**
	 * Metoda dodaje zaposlenog na listu zaposlenih.
	 * @param ime ime zaposlenog.
	 * @param prezime prezime zaposlenog.
	 * @param pol pol zaposlenog.
	 * @param brTelefona broj telefona zaposlenog.
	 * @param Id_zaposlenog identifikacioni broj zaposlenog.
	 * @param adresa adresa prebivalista zaposlenog.
	 * @param listaZaposlenih lista zaposlenih osoba.
	 */
	public static void dodajZaposlenog(String ime, String prezime, String pol,
			String brTelefona, String Id_zaposlenog, String adresa, LinkedList<Zaposleni> listaZaposlenih) {
		
		Zaposleni z = new Zaposleni();
		
		z.setIme(ime);
		z.setPrezime(prezime);
		z.setPol(pol);
		z.setID_zaposlenog(Id_zaposlenog);
		z.setBrTelefona(brTelefona);
		z.setAdresa(adresa);
		
		listaZaposlenih.add(z);
	
	}

}
