package prodavnica;

public class Kupac {
private int id;
private String ime;
/**
 * Kolicina novca koju je potrosio kod nas 
 */
private double kolicinaNovca;


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getIme() {
	return ime;
}
public void setIme(String ime) {
	this.ime = ime;
}
public double getkolicinaNovca() {
	return kolicinaNovca;
}
public void setKolicina(double kolicinaNovca) {
	this.kolicinaNovca = kolicinaNovca;
}
public String toString() {
	return "Kupac sa id:" + id + ", i imenom: " + ime + ", je kod nas potrosio do sada: " + kolicinaNovca ;
}

}
