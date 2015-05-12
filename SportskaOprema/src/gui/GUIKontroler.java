package gui;

import java.awt.EventQueue;
import java.io.File;
import java.util.LinkedList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import nabavka.Dobavljac;
import prodavnica.Kupac;
import prodavnica.Prodavnica;
import prodavnica.Proizvod;

public class GUIKontroler extends JFrame {

	public GUIKontroler() {
	}

	private static Prodavnica prodavnica = new Prodavnica();
	private static ProdavnicaGUI glavniProzor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					glavniProzor = new ProdavnicaGUI();
					glavniProzor.setVisible(true);
					glavniProzor.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Metoda koja nam vraca objekat klase Proizvod, na osnovu unetog naziva proizvoda.
	 * @param naziv proizvoda koji zelimo da pronadjemo
	 * @return <ul>
	 *         <li>objekat klase Proizvod, ukoliko u listi proizvoda postoji
	 *         objekat sa datim nazivom.</li>
	 *         <li>Null, ukoliko objekat ne postoji u listi.</li>
	 *         </ul>
	 */
	public static Proizvod pronadjiProizvod(String naziv) {
		return prodavnica.pronadjiProizvod(naziv);
	}
	/**
	 * Metoda koja nam vraca objekat klase Kupac, na osnovu unetog imena kupca.
	 * @param ime ime kupca kojeg zelimo da pronadjemo
	 * @return<ul>
	 *         <li>objekat klase Kupac, ukoliko u listi proizvoda postoji
	 *         objekat sa datim imenom.</li>
	 *         <li>Null, ukoliko objekat ne postoji u listi.</li>
	 *         </ul>
	 */
	public static Kupac pronadjiKupca(String ime) {
		return prodavnica.prondadjiKupca(ime);
	}	
	/**
	 * Metoda koja nam vraca objekat klase Dobavljac, na osnovu unetog imena
	 * dobavljaca.
	 * 
	 * @param ime
	 *            ime dobavljaca
	 * @return objekat klase Dobavljac sa trazenim imenom
	 */
	public static Dobavljac pronadjiDobavljaca(String ime) {
		return prodavnica.pronadjiDobavljaca(ime);
	}
	/**
	 * Metoda dodaje zaposlenog na listu zaposlenih.
	 * 
	 * @param ime
	 *            ime zaposlenog
	 * @param prezime
	 *            prezime zaposlenog
	 * @param pol
	 *            pol zaposlenog
	 * @param telefon
	 *            broj telefona zaposlenog
	 * @param id
	 *            jedinstveni identifikator zaposlenog
	 * @param adresa
	 *            adresa zaposlenog
	 */
	public static void dodajZaposlenog(String ime, String prezime, String pol,
			String telefon, String id, String adresa) {
		prodavnica.dodajZaposlenog(ime, prezime, pol, telefon, id, adresa);
		glavniProzor.getZaposleniList().setListData(
				prodavnica.getZaposleni().toArray());
	}
	/**
	 * metoda koja otvara prozor za dodavanje novog zaposlenog
	 */
	public static void otvoriDodajZaposlenog() {
		DodajZaposlenog prozor = new DodajZaposlenog();
		prozor.setLocationRelativeTo(glavniProzor.getContentPane());
		prozor.setVisible(true);
	}
	/**
	 * metoda koja sluzi za dodavanje proizvoda
	 * @param Id jedinstveni identifikator proizvoda
	 * @param naziv naziv proizvoda
	 * @param cena cena proizvoda
	 * @param kolicina kolicina proizvoda koju dodajemo
	 */
	public static void dodajProizvod(String Id, String naziv, String cena,
			String kolicina) {

		try {
			Proizvod p = new Proizvod();
			p.setId(Id);
			p.setKolicina(Integer.parseInt(kolicina));
			p.setCena(Double.parseDouble(cena));
			p.setNaziv(naziv);
			prodavnica.dodajProizvod(p);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(),
					"Pogresno uneta vrednost", "Greska",
					JOptionPane.ERROR_MESSAGE);
		}

	}
	/**
	 * Metoda koja prikazuje listu svih proizvoda.
	 * @return lista proizvoda
	 */
	public static LinkedList<Proizvod> prikaziProizvode() {
		return prodavnica.prikaziSveProizvode();
	}
	/**
	 * metoda koja brise proizvod iz liste
	 * @param p proizvod koji treba obrisati
	 */
	public static void izbrisiProizvod(Proizvod p) {
		prodavnica.izbrisiProizvod(p);

	}
	/**
	 * metoda koja otvara prozor za dodavanje proizvoda, kupca, dobavljaca
	 */
	public static void prikaziDodaj() {
		DodajGUI prozor = new DodajGUI();
		prozor.setVisible(true);
		prozor.setLocationRelativeTo(glavniProzor.getContentPane());
	}
	/**
	 * metoda koja otvara prozor za pronalazenje proizvoda, kupca, dobavljaca
	 */
	public static void prikaziPronadji() {
		PronadjiGUI prozor = new PronadjiGUI();
		prozor.setVisible(true);
		prozor.setLocationRelativeTo(glavniProzor.getContentPane());
	}
	/**
	 * metoda koja otvara prozor koji sadrzi informacije o autorima aplikacije
	 */
	public static void prikaziInformacije() {
		JOptionPane.showMessageDialog(glavniProzor.getContentPane(),
				"Autori: \n Nemanja Vukic \n Gordan Gigovic \n Ivan Rakic",
				"Informacije o programu", JOptionPane.INFORMATION_MESSAGE);
	}
	/**
	 * metoda koja gasi aplikaciju
	 */
	public static void ugasiAplikaciju() {
		int opcija = JOptionPane.showConfirmDialog(
				glavniProzor.getContentPane(),
				"Da li zelite da zatvorite program?", "Izlazak",
				JOptionPane.YES_NO_OPTION);

		if (opcija == JOptionPane.YES_OPTION)
			System.exit(0);
	}
	/**
	 * metoda kojom se vrse izmene na racunu
	 * @param area mesto gde se upisuje stanje na racunu.
	 */
	public static void promeniStanjeRacuna(JTextField area) {
		area.setText("" + prodavnica.getTekuciRacun());
	}
	/**
	 * Metoda koja dodaje objekat klase Kupac u listu svih kupaca.
	 * @param Id jedinstveni identifikator kupca	
	 * @param ime ime kupca
	 * @param kolicinaNovca kolicina novca koju je kupac potrosio kod nas u radnji
	 */
	public static void dodajKupca(String Id, String ime, String kolicinaNovca) {
		try {
			Kupac p = new Kupac();
			p.setId(Id);
			p.setIme(ime);
			p.setKolicina(Double.parseDouble(kolicinaNovca));

			prodavnica.dodajKupca(p);

			glavniProzor.getProdajaList().setListData(
					prodavnica.getKupci().toArray());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(),
					"Pogresno uneta vrednost", "Greska",
					JOptionPane.ERROR_MESSAGE);

		}

	}
	/**
	 * metoda koja sluzi za unosenje novog dobavljaca u listu
	 * @param Id jedinstveni identifikator dobavljaca
	 * @param ime ime dobavljaca
	 * @param adresa adresa dobavljaca
	 * @param telefon telefon dobavljaca
	 * @param proizvodi lista proizvoda koju poseduje taj dobavljac
	 */
	public static void dodajDobavljaca(String Id, String ime, String adresa,
			String telefon, LinkedList<Proizvod> proizvodi) {
		try {
			Dobavljac p = new Dobavljac();
			p.setDobavljacId(Id);
			p.setIme(ime);
			p.setAdresa(adresa);
			p.setTelefon(telefon);
			p.setProizvodi(proizvodi);
			prodavnica.dodajDobavljaca(p);

			glavniProzor.getNabavkaList().setListData(
					prodavnica.getDobavljaci().toArray());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(),
					"Pogresno uneta vrednost", "Greska",
					JOptionPane.ERROR_MESSAGE);
		}

	}
	/**
	 * metoda koja sluzi za prikaz svih kupaca
	 * @return lista kupaca
	 */
	public static LinkedList<Kupac> prikaziSveKupce() {

		return prodavnica.prikaziSveKupce();
	}
	/**
	 * metoda koja sluzi za prikaz svih dobavljaca
	 * @return	lista dobavljaca
	 */
	public static LinkedList<Dobavljac> prikaziSveDobavljace() {

		return prodavnica.prikaziSveDobavljace();
	}
	/**
	 * metoda koja brise odgovarajuceg kupca iz liste
	 * @param p kupac koji treba da bude obrisan
	 */
	public static void izbrisiKupca(Kupac p) {
		prodavnica.izbrisiKupca(p);

	}
	/**
	 * metoda koja brise odgovarajuceg dobavljaca iz liste
	 * @param p dobavljac koji treba da bude obrisan
	 */
	public static void izbrisiDobavljaca(Dobavljac p) {
		prodavnica.izbrisiDobavljaca(p);

	}
	/**
	 * metoda koja proverava listu proizvoda
	 * @param lista lista u koju ce biti upisani podaci
	 */
	public static void osveziListuProizvoda(JList lista) {
		lista.setListData(prodavnica.getProizvodi().toArray());
	}
	/**
	 * meotda koja proverava listu kupaca
	 * @param lista lista u koju ce biti uneti kupci
	 */
	public static void osveziListuKupaca(JList lista) {
		lista.setListData(prodavnica.getKupci().toArray());
	}
	/**
	 * metoda koja proverava listu dobavljaca
	 * @param lista lista u koju ce bitgi uneti dobavljaci
	 */
	public static void osveziListuDobavljaca(JList lista) {
		lista.setListData(prodavnica.getDobavljaci().toArray());
	}

	public static void ucitajIzFajlaKupac(JList lista) {
		try {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(glavniProzor.getContentPane());

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				prodavnica.ucitajUFajlKupac(file.getAbsolutePath());
				osveziListuKupaca(lista);
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(),
					e1.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void ucitajIzFajlaDobavljac(JList lista) {
		try {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(glavniProzor.getContentPane());

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				prodavnica.ucitajUFajlDobavljac(file.getAbsolutePath());
				osveziListuDobavljaca(lista);
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(),
					e1.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * metoda koja vrsi deserijalizaciju liste zapolsenih iz fajla
	 * @param lista
	 */
	public static void ucitajIzFajlaZaposleni(JList lista) {
		try {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(glavniProzor.getContentPane());

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				prodavnica.ucitajUFajlZaposleni(file.getAbsolutePath());
				glavniProzor.getZaposleniList().setListData(
						prodavnica.getZaposleni().toArray());
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(),
					e1.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * metoda koja vrsi serijalizaciju liste zaposlenih
	 */
	public static void sacuvajUFajlZaposleni() {
		try {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(glavniProzor.getContentPane());

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();

				prodavnica.sacuvajUFajlZaposleni(file.getAbsolutePath());
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(),
					e1.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * metoda koja vrsi serijalizaciju liste kupaca
	 */
	public static void sacuvajUFajlKupac() {
		try {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(glavniProzor.getContentPane());

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();

				prodavnica.sacuvajUFajlKupac(file.getAbsolutePath());
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(),
					e1.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * metoda koja vrsi serijalizaciju liste dobavljaca
	 */
	public static void sacuvajUFajlDobavljac() {
		try {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(glavniProzor.getContentPane());

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();

				prodavnica.sacuvajUFajlDobavljac(file.getAbsolutePath());
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(),
					e1.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * metoda koja vrsi primanje narudzbine 
	 * @param k kupac koji narucuje proizvod
	 * @param imeProizvoda naziv proizvoda
	 * @param id jedinstveni identifikator proizvoda
	 * @param kolicina kolicina koju narucuje
	 * @param cena cena po kojoj narucuje proizvd
	 */
	public static void primiNarudzbenicu(Kupac k, String imeProizvoda,
			String id, String kolicina, double cena) {
		try {
			Proizvod p = new Proizvod();
			p.setCena(cena);
			p.setId(id);
			p.setKolicina(Integer.parseInt(kolicina));
			p.setNaziv(imeProizvoda);

			prodavnica.primiNarudzbinu(k, p);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(),
					"Pogresno uneta vrednost", "Greska",
					JOptionPane.ERROR_MESSAGE);

		}

		glavniProzor.getTextField_stanjeNaRacunu().setText(
				"" + prodavnica.getTekuciRacun());
	}
	/**
	 * metoda koja sluzi za prikaz prozora za primanje narudzbine
	 */
	public static void prikaziPrimiNarudzbinu() {
		PrimiNarudzbinuGUI prozor = new PrimiNarudzbinuGUI();
		prozor.setVisible(true);
		prozor.setLocationRelativeTo(glavniProzor.getContentPane());
	}
	/**
	 * metoda koja proerava trenutno stanje na racunu
	 * @param field
	 */
	public static void osveziStanjeNaRacunu(JTextField field) {
		field.setText("" + prodavnica.getTekuciRacun());
	}
	/**
	 * Metoda proverava da li je identifikacioni broj proizvoda vec zauzet.
	 * @param id identifikacioni broj za koji vrsimo proveru
	 * @return <ul>
	 *         <li>false, ukoliko je zauzet</li>
	 *         <li>true, ukoliko je slobodan</li>
	 *         </ul>
	 */
	public static boolean proverIdProizvoda(String id) {
		return prodavnica.proveriIdProizvoda(id);
	}
	/**
	 * Metoda proverava da li je identifikacioni broj dobavljaca vec zauzet
	 * @param id identifikacioni broj kupca za kog vrsimo proveru
	 * @return <ul>
	 *         <li>false, ukoliko je zauzet</li>
	 *         <li>true, ukoliko je slobodan</li>
	 *         </ul>
	 */
	public static boolean proveriIdKupca(String id) {

		return prodavnica.proveriIdKupca(id);
	}
	/**
	 * metoda koja proverava da li je ID dobavljaca zauzet
	 * @param id jedinstveni identifikatordobavljaca za kog vrsimo proveru
	 * @return <ul>
	 *         <li>false, ukoliko je zauzet</li>
	 *         <li>true, ukoliko je slobodan</li>
	 *         </ul>
	 */
	public static boolean proveriIdDobavljaca(String id) {

		return prodavnica.proveriIdDobavljaca(id);
	}
	/**
	 * metoda koja dodaje proizvod dobavljacu
	 * @param ime naziv proizvoda
	 * @param id jedinstveni identifikator proizvoda
	 * @param cena cena proizvoda
	 * @param kolicina kolicina koju narucujemo
	 * @param d dobavljac od kog narucujemo robu
	 */
	public static void dodajProizvodDobavljaca(String ime, String id,
			String cena, String kolicina, Dobavljac d) {
		try {
			Proizvod p = new Proizvod();
			p.setCena(Double.parseDouble(cena));
			p.setId(id);
			p.setKolicina(Integer.parseInt(kolicina));
			p.setNaziv(ime);

			prodavnica.dodajProizvodDobavljaca(p, d);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(),
					"Pogresno uneta vrednost", "Greska",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * metoda koja sluzi za prikaz prozora za dodavanje proizvoda odredjenog dobavljaca
	 * @param p dobavljac za kog dodajemo proizvod
	 */
	public static void prikaziDodajProizvodDobavljaca(Dobavljac p) {

		DodajProizvodDobavljacaGUI prozor = new DodajProizvodDobavljacaGUI(p);
		prozor.setVisible(true);
		prozor.setLocationRelativeTo(glavniProzor.getContentPane());
	}
	/**
	 * meotda koa pravi listu proizvoda dobavlajaca sa odredjenim imenom
	 * @param lista nova lista
	 * @param ime ime dobavljaca cije proizvode trazimo
	 */
	public static void osveziListuProizvodaDobavljaca(JList lista, String ime) {
		Dobavljac d = new Dobavljac();
		for (int i = 0; i < prodavnica.getDobavljaci().size(); i++) {
			if (prodavnica.getDobavljaci().get(i).getIme().equals(ime)) {
				d = prodavnica.getDobavljaci().get(i);
				break;
			}
		}

		lista.setListData(d.getProizvodi().toArray());
	}
	/**
	 * metoda koja pretrazuje listu dobavljaca na osnovu jedinstvenog identifikatora
	 * @param id jedinstveni identifikator dobavljaca kojeg treba pronaci
	 * @return objekat klase Dobavljac
	 */
	public static Dobavljac pretraziDobavljace(String id) {

		return prodavnica.pretraziDobavljace(id);
	}
	/**
	 * metoda koja sluzi za narucivanje proizvoda
	 * @param dobavljac dobavljac od kog narucujemo proizvod
	 * @param id jedinstveni identifikator proizvoda koji narucujemo
	 * @param cena cena proizvoda koji narucujemo
	 * @param naziv naziv proizvoda koji narucujemo
	 * @param kolicina kolicina proizvoda koju narucujemo
	 */
	public static void naruciProizvod(Dobavljac dobavljac, String id,
			String cena, String naziv, String kolicina) {
		try {
			Proizvod p = new Proizvod();
			p.setId(id);
			p.setNaziv(naziv);
			p.setCena(Double.parseDouble(cena));
			p.setKolicina(Integer.parseInt(kolicina));
			prodavnica.naruci(p, dobavljac);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(),
					"Pogresno uneta vrednost", "Greska",
					JOptionPane.ERROR_MESSAGE);
		}

	}
	/**
	 * metoda koja sluzi za otvaranje prozora za narucivanje proizvoda
	 */
	public static void prikaziNaruciProizvod() {
		Naruci p = new Naruci(prodavnica.getTekuciRacun());
		p.setVisible(true);
		p.setLocationRelativeTo(glavniProzor.getContentPane());

	}
}
