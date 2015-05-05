package prodavnica;

import java.util.LinkedList;

public class Zaposleni implements ZaposleniInterface{
	
	private String ime;
	private String prezime;
	private String pol;
	private String brTelefona;
	private String ID_zaposlenog;
	private String adresa;
	protected LinkedList<Zaposleni> listaZaposlenih = new LinkedList<Zaposleni>();
	
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getPol() {
		return pol;
	}
	public void setPol(String pol) {
		this.pol = pol;
	}
	public String getBrTelefona() {
		return brTelefona;
	}
	public void setBrTelefona(String brTelefona) {
		this.brTelefona = brTelefona;
	}
	public String getID_zaposlenog() {
		return ID_zaposlenog;
	}
	public void setID_zaposlenog(String iD_zaposlenog) {
		ID_zaposlenog = iD_zaposlenog;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
	public String toString() {
		return "Zaposleni [ID_zaposlenog=" + ID_zaposlenog + ", ime=" + ime
				+ ", prezime=" + prezime + ", pol=" + pol + ", brTelefona="
				+ brTelefona + ", adresa=" + adresa + "]";
	}
	
	public void dodajZaposlenog(){
		
	}
	public void dodajZaposlenog(String ime, String prezime, String pol,
			String brTelefona, String Id_zaposlenog, String adresa) {
		
		Zaposleni z = new Zaposleni();
		
		z.setIme(ime);
		z.setPrezime(prezime);
		z.setPol(pol);
		z.setID_zaposlenog(Id_zaposlenog);
		z.setBrTelefona(brTelefona);
		z.setAdresa(adresa);
		
		listaZaposlenih.add(z);
	
	}

	public void otpustiZaposlenog(Zaposleni zaposleni) {
		if(!listaZaposlenih.contains(zaposleni)) {
			throw new RuntimeException("Trazeni zaposleni se ne nalazi na spisku zaposlenih radnika.");
		} else {
			listaZaposlenih.remove(zaposleni);
		}
		
	}

}
