package nabavka;

import java.io.Serializable;
import java.util.LinkedList;

import prodavnica.Proizvod;

public class Dobavljac implements Serializable {
	
	/**
	 * predstavlja jedinstveni identifikator dobavljaca.
	 */
	private String dobavljacId;
	/**
	 * predstavlja ime dobavljaca.
	 */
	private String ime;
	/**
	 * predstavlja adresudobavljaca.
	 */
	private String adresa;
	/**
	 * predstavlja telefonski broj dobavljaca.
	 */
	private String telefon;
	/**
	 * predstavlja listu proizvoda koje neki dobavljac poseduje.
	 */
	private LinkedList<Proizvod> proizvodi = new LinkedList<Proizvod>();
	
	/**
	 * metoda vraca vrednost jedinstvenog identifikatora dobavljaca 	
	 * @return jedinstveni identifikator dobavljaca kao String
	 */
	public String getDobavljacId() {
		return dobavljacId;
	}
	/**
	 * postavlja identifikator dobavljaca na novu vrednust
	 * @param dobavljacId nova vrednost koja ce biti dodeljena identifikatoru
	 */
	public void setDobavljacId(String dobavljacId) {
		if(dobavljacId == null || dobavljacId.isEmpty())
			throw new RuntimeException("Morate uneti ID.");
		this.dobavljacId = dobavljacId;
	}
	/**
	 * metoda vraca ime dobavljaca
	 * @return ime dobavljaca kao String
	 */
	public String getIme() {
		return ime;
	}
	/**
	 * postavlja ime dobavljaca na novounetu vrednost
	 * @param ime novouneta vrednost imena dobavljaca
	 */
	public void setIme(String ime) {
		if(ime == null || ime.isEmpty())
			throw new RuntimeException("Morate uneti ime.");
		this.ime = ime;
	}
	/**
	 * metoda vraca adresu dobavljaca
	 * @return adresa dobavljaca kao String
	 */
	public String getAdresa() {
		return adresa;
	}
	/**
	 * postavlja adresu dobavljaca na novounetu adresu
	 * @param adresa novouneta adresa dobacljaca
	 */
	public void setAdresa(String adresa) {
		if(adresa == null || adresa.isEmpty())
			throw new RuntimeException("Morate uneti adresu.");
		this.adresa = adresa;
	} 
	/**
	 * metoda vraca broj telefona dobavljaca 
	 * @return broj telefona dobavljaca kao String
	 */
	public String getTelefon() {
		return telefon;
	}
	/**
	 * postavlja vrednost atributa telefon, na novounetu vrednost
	 * @param telefon novouneta vrednost za atribut-teleofon
	 */
	public void setTelefon(String telefon) {
		if(telefon == null || telefon.isEmpty())
			throw new RuntimeException("Morate uneti telefon.");
		this.telefon = telefon;
	}
	/**
	 * metoda vraca listu proizvoda koju poseduje odredjeni dobavljac
	 * @return	lista proizvoda
	 */
	public LinkedList<Proizvod> getProizvodi() {
		return proizvodi;
	}
	/**
	 * postavlja vrednost liste proizvoda na novounetu vrednost 
	 * @param proizvodi novouneta lista proizvoda
	 */
	public void setProizvodi(LinkedList<Proizvod> proizvodi) {
		this.proizvodi = proizvodi;
	}
	@Override
	public String toString() {
		return "Dobavljac sa Id: " + dobavljacId + ",imenom: " + ime
				+ ",adresom: " + adresa + ",i telefonom: " + telefon;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dobavljac other = (Dobavljac) obj;
		if (dobavljacId == null) {
			if (other.dobavljacId != null)
				return false;
		} else if (!dobavljacId.equals(other.dobavljacId))
			return false;
		return true;
	}
	

}
