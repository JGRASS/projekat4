package prodavnica;

import java.io.Serializable;
import java.util.LinkedList;
/**
 * predstavlja zaposlenog u nasoj prodavnici
 * @author Thekgiga
 *
 */
public class Zaposleni implements Serializable {
	/**
	 * ime zaposlenog
	 */
	private String ime;
	/**
	 * prezime zaposlenog
	 */
	private String prezime;
	/**
	 * pol zaposlenog
	 */
	private String pol;
	/**
	 * broj telefona zaposlenog
	 */
	private String brTelefona;
	/**
	 * jedinstveni identifikator zaposlenog
	 */
	private String ID_zaposlenog;
	/**
	 * adresa prebivalista zaposlenog
	 */
	private String adresa; 
	/**
	 * lista zaposlenih radnika
	 */
	protected LinkedList<Zaposleni> listaZaposlenih = new LinkedList<Zaposleni>();
	/**
	 * metoda vraca ime zaposlenog
	 * @return ime zaposlenog kao String
	 */
	public String getIme() {
		return ime;
	}
	/**
	 * psotavlja ime radnika na novu vrednost
	 * @param ime nova vrednost imena
	 */
	public void setIme(String ime) {
		if (ime == null || ime.isEmpty())
			throw new RuntimeException("Morate uneti ime.");
		this.ime = ime;
	}
	/**
	 * metoda vraca preziime zaposlenog
	 * @return prezime zaposlenog kao String
	 */
	public String getPrezime() {
		return prezime;
	}
	/**
	 * postavlja prezime radnika na novu vrednost
	 * @param prezime nova vrednost prezimena 
	 */
	public void setPrezime(String prezime) {
		if (prezime == null || prezime.isEmpty())
			throw new RuntimeException("Morate uneti prezime.");
		this.prezime = prezime;
	}
	/**
	 * metoda vraca pol zaposlenog
	 * @return pol zaposlenog kao String
	 */
	public String getPol() {
		return pol;
	}
	/**
	 * postavlja pol zaposlenog na novu vrednost
	 * @param pol nova vrednost pola
	 */
	public void setPol(String pol) {
		if (pol == null || pol.isEmpty())
			throw new RuntimeException("Morate uneti pol.");
		this.pol = pol;
	}
	/**
	 * metoda vraca broj telefona zaposlenog
	 * @return broj telefona kaoString
	 */
	public String getBrTelefona() {
		return brTelefona;
	}
	/**
	 * postavlja broj telefona zaposlenog na novu vrednost
	 * @param brTelefona  novi broj telefona
	 */
	public void setBrTelefona(String brTelefona) {
		if (brTelefona == null || brTelefona.isEmpty())
			throw new RuntimeException("Morate uneti broj telefona.");
		this.brTelefona = brTelefona;
	}
	/**
	 * metoda vraca jedinstveni identifikator zaposlenog
	 * @return jedinstveni identifikator zaposlenog kao String
	 */
	public String getID_zaposlenog() {
		return ID_zaposlenog;
	}
	/**
	 * postavlja vrednost jedinstvenog identifikatora zaposlenog na novounetu
	 * @param iD_zaposlenog novouneta vrednost identifikatora
	 */
	public void setID_zaposlenog(String iD_zaposlenog) {
		if (iD_zaposlenog == null || iD_zaposlenog.isEmpty())
			throw new RuntimeException("Morate uneti broj iD zaposlenog.");
		ID_zaposlenog = iD_zaposlenog;
	}
	/**
	 * metoda vraca adresu  zaposlenog
	 * @return	adresa zaposlenog kao String
	 */
	public String getAdresa() {
		return adresa;
	}
	/**
	 * 
	 * @param adresa
	 */
	public void setAdresa(String adresa) {
		if (adresa == null || adresa.isEmpty())
			throw new RuntimeException("Morate uneti adresu.");
		this.adresa = adresa;
	}

	public String toString() {
		return "ID zaposlenog: " + ID_zaposlenog + ", ime: " + ime
				+ ", prezime: " + prezime + ", pol: " + pol + ", brTelefona: "
				+ brTelefona + ", adresa: " + adresa + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Zaposleni other = (Zaposleni) obj;
		if (ID_zaposlenog == null) {
			if (other.ID_zaposlenog != null)
				return false;
		} else if (!ID_zaposlenog.equals(other.ID_zaposlenog))
			return false;
		return true;
	}

}
