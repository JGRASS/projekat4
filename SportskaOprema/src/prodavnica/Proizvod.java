package prodavnica;

public class Proizvod {
	
private int id;
private String naziv;
private int kolicina;
private double cena;

public double getCena() {
	return cena;
}
public void setCena(double cena) {
	this.cena = cena;
}
public int getId() {
	return id;
}
public void setId(int id) {
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
	return "Proizvoda sa id: " + id +", cenom: "+cena+ ", i nazivom: " + naziv + ", na lageru ima: " + kolicina
			;
}



}
