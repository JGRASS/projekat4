package prodavnica;

import java.io.Serializable;
/**
 * predstavlja kupca u nasoj prodavnici.
 */
public class Kupac implements Serializable {
	/**
	 * jedinstveni identifikator kupca.
	 */
	private String id;
	/**
	 * ime kupca.
	 */
	private String ime;
	/**
	 * Kolicina novca koju je potrosio kod nas.
	 */
	private double kolicinaNovca;
	/**
	 * metoda vraca jeidnstveni identifikator kupca
	 * @return jedinstveni identifikator kupca kao String
	 */
	public String getId() {
		return id;
	}
	/**
	 * postavlja vrednost identifikatora kupca na novounetu
	 * @param id novouneta vrednost
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * metoda vraca ime kupca
	 * @return ime kupca kao String
	 */
	public String getIme() {
		return ime;
	}
	/**
	 * postavlja ime kupca na novouneto
	 * @param ime novouneto ime kupca
	 */
	public void setIme(String ime) {
		this.ime = ime;
	}
	/**
	 * metoda vraca kolicinu novca koju je kupac potrosio kod nas u radnji
	 * @return kolicina novca
	 */
	public double getkolicinaNovca() {
		return kolicinaNovca;
	}
	/**
	 * postavlja vrednoost parametra kolicinaNovca na novounetu 
	 * @param kolicinaNovca novouneta vrednost kolicineNovca
	 */
	public void setKolicina(double kolicinaNovca) {
		this.kolicinaNovca = kolicinaNovca;
	}

	public String toString() {
		return "Kupac sa id:" + id + ", i imenom: " + ime
				+ ", je kod nas potrosio do sada: " + kolicinaNovca;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kupac other = (Kupac) obj;
		if (id != other.id)
			return false;
		if (ime == null) {
			if (other.ime != null)
				return false;
		} else if (!ime.equals(other.ime))
			return false;
		return true;
	}

}
