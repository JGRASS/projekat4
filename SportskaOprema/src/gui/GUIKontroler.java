package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import nabavka.Dobavljac;
import prodavnica.Kupac;
import prodavnica.Prodavnica;
import prodavnica.Proizvod;

import prodavnica.Zaposleni;

import sistemskeoperacije.SODodajProizvod;


public class GUIKontroler extends JFrame {

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

	
	public static Proizvod pronadjiProizvod(String naziv) {
		return prodavnica.pronadjiProizvod(naziv);
	}
	
	public static Kupac pronadjiKupca(String ime) {
		return prodavnica.prondadjiKupca(ime);
	}
	
	public static Dobavljac pronadjiDobavljaca (String ime) {
		return prodavnica.pronadjiDobavljaca(ime);
	}

	public static void dodajZaposlenog(String ime, String prezime,
			String pol, String telefon, String id, String adresa) {
		prodavnica.dodajZaposlenog(ime, prezime, pol, telefon, id, adresa);
		
	}
	
	public static void otvoriDodajZaposlenog() {
		DodajZaposlenog prozor = new DodajZaposlenog();
		prozor.setLocationRelativeTo(glavniProzor.getContentPane());
		prozor.setVisible(true);
	}

	public static void dodajProizvod(String Id, String naziv,
			double cena, int kolicina) {
		// kad bude formiran glavni prozor treba napraviti da iskace poruka da je pogresno uneta neka vrednost
			try {
				Proizvod p=new Proizvod();
				p.setId(Id);
				p.setKolicina(kolicina);
				p.setCena(cena);
				p.setNaziv(naziv);
				prodavnica.dodajProizvod(p);
			} catch (Exception e) {
				
			}
		
		
	}
	public static LinkedList<Proizvod> prikaziProizvode(){
		return  prodavnica.prikaziSveProizvode();
	}

	public static void izbrisiProizvod(Proizvod p) {
		prodavnica.izbrisiProizvod(p);
		
	}

}
