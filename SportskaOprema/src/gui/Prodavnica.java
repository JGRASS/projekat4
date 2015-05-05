package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;

public class Prodavnica extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnIzvestaji;
	private JMenuItem mntmDnevni;
	private JMenuItem mntmNedeljni;
	private JMenuItem mntmMesecni;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private JMenu mnAbout;
	private JSplitPane splitPane;
	private JLabel lbl_stanjeNaRacunu;
	private JTextField textField_stanjeNaRacunu;
	private JMenu mnZaposleni;
	private JMenuItem mntmDodajZaposlenog;
	private JMenuItem mntmZaposleni;
	private JMenuItem mntmZaposleni_1;
	private JMenuItem mntmAboutProgram;
	private JMenuItem mntmNarudzbenica;
	private JTabbedPane tabbedPane;
	private JLayeredPane layeredPane_Prodaja;
	private JLayeredPane layeredPane_Nabavka;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prodavnica frame = new Prodavnica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Prodavnica() {
		setTitle("Prodavnica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getSplitPane(), BorderLayout.SOUTH);
		contentPane.add(getTabbedPane(), BorderLayout.CENTER);
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnIzvestaji());
			menuBar.add(getMnZaposleni());
			menuBar.add(getMnAbout());
		}
		return menuBar;
	}
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmOpen());
			mnFile.add(getMntmSave());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}
	private JMenu getMnIzvestaji() {
		if (mnIzvestaji == null) {
			mnIzvestaji = new JMenu("Izvestaji");
			mnIzvestaji.add(getMntmDnevni());
			mnIzvestaji.add(getMntmNedeljni());
			mnIzvestaji.add(getMntmMesecni());
			mnIzvestaji.add(getMntmNarudzbenica());
		}
		return mnIzvestaji;
	}
	private JMenuItem getMntmDnevni() {
		if (mntmDnevni == null) {
			mntmDnevni = new JMenuItem("Dnevni");
		}
		return mntmDnevni;
	}
	private JMenuItem getMntmNedeljni() {
		if (mntmNedeljni == null) {
			mntmNedeljni = new JMenuItem("Nedeljni");
		}
		return mntmNedeljni;
	}
	private JMenuItem getMntmMesecni() {
		if (mntmMesecni == null) {
			mntmMesecni = new JMenuItem("Mesecni");
		}
		return mntmMesecni;
	}
	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("open");
		}
		return mntmOpen;
	}
	private JMenuItem getMntmSave() {
		if (mntmSave == null) {
			mntmSave = new JMenuItem("save");
		}
		return mntmSave;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("exit");
		}
		return mntmExit;
	}
	private JMenu getMnAbout() {
		if (mnAbout == null) {
			mnAbout = new JMenu("Help");
			mnAbout.add(getMntmAboutProgram());
		}
		return mnAbout;
	}
	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setLeftComponent(getLbl_stanjeNaRacunu());
			splitPane.setRightComponent(getTextField_stanjeNaRacunu());
		}
		return splitPane;
	}
	private JLabel getLbl_stanjeNaRacunu() {
		if (lbl_stanjeNaRacunu == null) {
			lbl_stanjeNaRacunu = new JLabel("Stanje na ra\u010Dunu:");
		}
		return lbl_stanjeNaRacunu;
	}
	private JTextField getTextField_stanjeNaRacunu() {
		if (textField_stanjeNaRacunu == null) {
			textField_stanjeNaRacunu = new JTextField();
			textField_stanjeNaRacunu.setColumns(10);
		}
		return textField_stanjeNaRacunu;
	}
	private JMenu getMnZaposleni() {
		if (mnZaposleni == null) {
			mnZaposleni = new JMenu("Zaposleni");
			mnZaposleni.add(getMntmDodajZaposlenog());
			mnZaposleni.add(getMntmZaposleni());
			mnZaposleni.add(getMntmZaposleni_1());
		}
		return mnZaposleni;
	}
	private JMenuItem getMntmDodajZaposlenog() {
		if (mntmDodajZaposlenog == null) {
			mntmDodajZaposlenog = new JMenuItem("Dodaj zaposlenog");
		}
		return mntmDodajZaposlenog;
	}
	private JMenuItem getMntmZaposleni() {
		if (mntmZaposleni == null) {
			mntmZaposleni = new JMenuItem("Zaposleni 1");
		}
		return mntmZaposleni;
	}
	private JMenuItem getMntmZaposleni_1() {
		if (mntmZaposleni_1 == null) {
			mntmZaposleni_1 = new JMenuItem("Zaposleni 2");
		}
		return mntmZaposleni_1;
	}
	private JMenuItem getMntmAboutProgram() {
		if (mntmAboutProgram == null) {
			mntmAboutProgram = new JMenuItem("About program");
		}
		return mntmAboutProgram;
	}
	private JMenuItem getMntmNarudzbenica() {
		if (mntmNarudzbenica == null) {
			mntmNarudzbenica = new JMenuItem("Narudzbenica");
		}
		return mntmNarudzbenica;
	}
	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.addTab("Prodaja", null, getLayeredPane_1(), null);
			tabbedPane.addTab("Nabavka", null, getLayeredPane_1_1(), null);
		}
		return tabbedPane;
	}
	private JLayeredPane getLayeredPane_1() {
		if (layeredPane_Prodaja == null) {
			layeredPane_Prodaja = new JLayeredPane();
		}
		return layeredPane_Prodaja;
	}
	private JLayeredPane getLayeredPane_1_1() {
		if (layeredPane_Nabavka == null) {
			layeredPane_Nabavka = new JLayeredPane();
		}
		return layeredPane_Nabavka;
	}
}
