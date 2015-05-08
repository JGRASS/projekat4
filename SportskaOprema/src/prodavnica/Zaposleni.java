package prodavnica;


import java.util.LinkedList;

public class Zaposleni {
	
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
		if(ime == null || ime.isEmpty())
			throw new RuntimeException("Morate uneti ime.");
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		if(prezime == null || prezime.isEmpty())
			throw new RuntimeException("Morate uneti prezime.");
		this.prezime = prezime;
	}
	public String getPol() {
		return pol;
	}
	public void setPol(String pol) {
		if(pol == null || pol.isEmpty())
			throw new RuntimeException("Morate uneti pol.");
		this.pol = pol;
	}
	public String getBrTelefona() {
		return brTelefona;
	}
	public void setBrTelefona(String brTelefona) {
		if(brTelefona == null || brTelefona.isEmpty())
			throw new RuntimeException("Morate uneti broj telefona.");
		this.brTelefona = brTelefona;
	}
	public String getID_zaposlenog() {
		return ID_zaposlenog;
	}
	public void setID_zaposlenog(String iD_zaposlenog) {
		if(iD_zaposlenog == null || iD_zaposlenog.isEmpty())
			throw new RuntimeException("Morate uneti broj iD zaposlenog.");
		ID_zaposlenog = iD_zaposlenog;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		if(adresa == null || adresa.isEmpty())
			throw new RuntimeException("Morate uneti adresu.");
		this.adresa = adresa;
	}
	
	public String toString() {
		return "Zaposleni [ID_zaposlenog=" + ID_zaposlenog + ", ime=" + ime
				+ ", prezime=" + prezime + ", pol=" + pol + ", brTelefona="
				+ brTelefona + ", adresa=" + adresa + "]";
	}

}
