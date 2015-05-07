package prodavnica;

public class Proizvod {
	
private String id;
private String naziv;
private int kolicina;
private double cena;

public double getCena() {
	return cena;
}
public void setCena(double cena) {
	this.cena = cena;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getNaziv() {
	return naziv;
}
public void setNaziv(String naziv) {
	this.naziv = naziv;
}
public int getKolicina() {
	return kolicina;
}
public void setKolicina(int kolicina) {
	this.kolicina = kolicina;
}
public String toString() {
	return "Proizvoda sa id: " + id +", cenom: "+cena+ ", i nazivom: " + naziv + ", na lageru ima: " + kolicina;
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
