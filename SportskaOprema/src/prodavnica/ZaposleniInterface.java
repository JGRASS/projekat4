package prodavnica;

public interface ZaposleniInterface {
	
	public void dodajZaposlenog(String ime, String prezime, String pol, String brTelefona, String Id_zaposlenog, String adresa);
	public void otpustiZaposlenog(Zaposleni zaposleni);

}
