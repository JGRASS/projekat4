package nabavka;

import java.util.LinkedList;

import prodavnica.Proizvod;

public class Dobavljac {
	
	private String dobavljacId, ime, adresa, telefon;
	private LinkedList<Proizvod> proizvodi = new LinkedList<Proizvod>();
	
	public String getDobavljacId() {
		return dobavljacId;
	}
	public void setDobavljacId(String dobavljacId) {
		if(dobavljacId == null || dobavljacId.isEmpty())
			throw new RuntimeException("Morate uneti ID.");
		this.dobavljacId = dobavljacId;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		if(ime == null || ime.isEmpty())
			throw new RuntimeException("Morate uneti ime.");
		this.ime = ime;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		if(adresa == null || adresa.isEmpty())
			throw new RuntimeException("Morate uneti adresu.");
		this.adresa = adresa;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		if(telefon == null || telefon.isEmpty())
			throw new RuntimeException("Morate uneti telefon.");
		this.telefon = telefon;
	}
	public LinkedList<Proizvod> getProizvodi() {
		return proizvodi;
	}
	public void setProizvodi(LinkedList<Proizvod> proizvodi) {
		this.proizvodi = proizvodi;
	}

}
