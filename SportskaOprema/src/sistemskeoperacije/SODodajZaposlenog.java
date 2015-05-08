package sistemskeoperacije;

import java.util.LinkedList;

import prodavnica.Zaposleni;

public class SODodajZaposlenog {
	
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
