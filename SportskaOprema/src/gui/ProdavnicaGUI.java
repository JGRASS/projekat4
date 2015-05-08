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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.ImageIcon;

public class ProdavnicaGUI extends JFrame {

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
	private JMenuItem mntmAboutProgram;
	private JMenuItem mntmNarudzbenica;
	private JTabbedPane tabbedPane;
	private JLayeredPane layeredPane_Prodaja;
	private JLayeredPane layeredPane_Nabavka;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JList ProdajaList;
	private JScrollPane scrollPane_1;
	private JList nabavkaList;
	private JScrollPane scrollPane_2;
	private JList zaposleniList;
	private JPanel panel_1;
	private JButton btnDodajProizvod;
	private JButton btnDodajDobavljaa;
	private JButton btnDodajZaposlenog;
	private JButton btnPronai;


	/**
	 * Create the frame.
	 */
	public ProdavnicaGUI() {
		setTitle("Prodavnica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 382);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getSplitPane(), BorderLayout.SOUTH);
		contentPane.add(getTabbedPane(), BorderLayout.CENTER);
		contentPane.add(getPanel_1(), BorderLayout.EAST);
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
			mntmOpen = new JMenuItem("Open");
			mntmOpen.setIcon(new ImageIcon(ProdavnicaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		}
		return mntmOpen;
	}
	private JMenuItem getMntmSave() {
		if (mntmSave == null) {
			mntmSave = new JMenuItem("Save");
			mntmSave.setIcon(new ImageIcon(ProdavnicaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		}
		return mntmSave;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
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
		}
		return mnZaposleni;
	}
	private JMenuItem getMntmDodajZaposlenog() {
		if (mntmDodajZaposlenog == null) {
			mntmDodajZaposlenog = new JMenuItem("Dodaj zaposlenog");
			mntmDodajZaposlenog.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.otvoriDodajZaposlenog();
					
				}
			});
		}
		return mntmDodajZaposlenog;
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
			tabbedPane.addTab("Zaposleni", null, getPanel(), null);
		}
		return tabbedPane;
	}
	private JLayeredPane getLayeredPane_1() {
		if (layeredPane_Prodaja == null) {
			layeredPane_Prodaja = new JLayeredPane();
			layeredPane_Prodaja.setLayout(new BorderLayout(0, 0));
			layeredPane_Prodaja.add(getScrollPane(), BorderLayout.CENTER);
		}
		return layeredPane_Prodaja;
	}
	private JLayeredPane getLayeredPane_1_1() {
		if (layeredPane_Nabavka == null) {
			layeredPane_Nabavka = new JLayeredPane();
			layeredPane_Nabavka.setLayout(new BorderLayout(0, 0));
			layeredPane_Nabavka.add(getScrollPane_1(), BorderLayout.CENTER);
		}
		return layeredPane_Nabavka;
	}
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getScrollPane_2(), BorderLayout.CENTER);
		}
		return panel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getProdajaList());
		}
		return scrollPane;
	}
	private JList getProdajaList() {
		if (ProdajaList == null) {
			ProdajaList = new JList();
		}
		return ProdajaList;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setViewportView(getNabavkaList());
		}
		return scrollPane_1;
	}
	private JList getNabavkaList() {
		if (nabavkaList == null) {
			nabavkaList = new JList();
		}
		return nabavkaList;
	}
	private JScrollPane getScrollPane_2() {
		if (scrollPane_2 == null) {
			scrollPane_2 = new JScrollPane();
			scrollPane_2.setViewportView(getZaposleniList());
		}
		return scrollPane_2;
	}
	private JList getZaposleniList() {
		if (zaposleniList == null) {
			zaposleniList = new JList();
		}
		return zaposleniList;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new MigLayout("", "[105px]", "[23px][][][][][]"));
			panel_1.add(getBtnDodajProizvod(), "cell 0 1,growx,aligny top");
			panel_1.add(getBtnDodajDobavljaa(), "cell 0 2");
			panel_1.add(getBtnDodajZaposlenog(), "cell 0 3");
			panel_1.add(getBtnPronai(), "cell 0 5,growx");
		}
		return panel_1;
	}
	private JButton getBtnDodajProizvod() {
		if (btnDodajProizvod == null) {
			btnDodajProizvod = new JButton("Dodaj kupca");
		}
		return btnDodajProizvod;
	}
	private JButton getBtnDodajDobavljaa() {
		if (btnDodajDobavljaa == null) {
			btnDodajDobavljaa = new JButton("Dodaj dobavlja\u010Da");
		}
		return btnDodajDobavljaa;
	}
	private JButton getBtnDodajZaposlenog() {
		if (btnDodajZaposlenog == null) {
			btnDodajZaposlenog = new JButton("Dodaj zaposlenog");
			btnDodajZaposlenog.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.otvoriDodajZaposlenog();
					
				}
			});
		}
		return btnDodajZaposlenog;
	}
	private JButton getBtnPronai() {
		if (btnPronai == null) {
			btnPronai = new JButton("Prona\u0111i");
		}
		return btnPronai;
	}
}
