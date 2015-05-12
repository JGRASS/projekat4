package prodavnica;

import java.io.Serializable;
/**
 * predstavlja klasu proizvoda koji moze da se nabavlja i prodaje.

 *
 */
public class Proizvod implements Serializable {
	/**
	 * jedinstveni identifikator proizvoda
	 */
	private String id;
	/**
	 * naziv proizvoda
	 */
	private String naziv;
	/**
	 * kolicina proizvoda na lageru.
	 */
	private int kolicina;
	/**
	 * cena prooizvoda.
	 */
	private double cena;
	/**
	 * metoda vraca cenu proizvoda
	 * @return cena proizvoda kao Double
	 */
	public double getCena() {
		return cena;
	}
	/**
	 *postavlja cenu proizvoda na novounetu vrednost 
	 * @param cena novouneta vrednost
	 */
	public void setCena(double cena) {
		this.cena = cena;
	}
	/**
	 * metoda vraca jedinstveni identifikator proizvoda
	 * @return	jedinstveni identifikator proizvoda kao String
	 */
	public String getId() {
		return id;
	}
	/**
	 * postavlja vrednost jedinstvenog identifikatora na novu vrednost
	 * @param id nova vrednost
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * metoda vraca naziv proizvoda
	 * @return naziv proizvoda kao String
	 */
	public String getNaziv() {
		return naziv;
	}
	/**
	 * postavlja naziv proizvoda na novu vrednost
	 * @param naziv nova vrednost
	 */
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	/**
	 * metoda vraca koliicnu proizvoda na lageru
	 * @return kolicina proizvoda kao ceo broj
	 */
	public int getKolicina() {
		return kolicina;
	}
	/**
	 * postavlja kolicinu proizvoda na novu vrednost
	 * @param kolicina nova vrednost
	 */
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}

	public String toString() {
		return "Proizvoda sa id: " + id + ", cenom: " + cena + ", i nazivom: "
				+ naziv + ", na lageru ima: " + kolicina;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proizvod other = (Proizvod) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
