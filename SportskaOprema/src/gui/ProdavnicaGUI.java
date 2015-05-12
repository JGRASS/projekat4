package gui;


import java.awt.BorderLayout;
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

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.Toolkit;
/**
 * glavni prozor nase apliakcije.
 *
 */
public class ProdavnicaGUI extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private JMenu mnAbout;
	private JSplitPane splitPane;
	private JLabel lbl_stanjeNaRacunu;
	private JTextField textField_stanjeNaRacunu;
	private JMenuItem mntmAboutProgram;
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
	private JButton btnDodajZaposlenog;
	private JButton btnPronai;
	private JButton btnNaruci;
	private JButton btnNewButton;


	/**
	 * Create the frame.
	 */
	public ProdavnicaGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProdavnicaGUI.class.getResource("/Icons/images.jpg")));
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				GUIKontroler.osveziStanjeNaRacunu(textField_stanjeNaRacunu);
				GUIKontroler.osveziListuKupaca(ProdajaList);
				GUIKontroler.osveziListuDobavljaca(nabavkaList);
				
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				GUIKontroler.ugasiAplikaciju();
			}
		});
		setTitle("Prodavnica");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 656, 397);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getSplitPane(), BorderLayout.SOUTH);
		contentPane.add(getTabbedPane(), BorderLayout.CENTER);
		contentPane.add(getPanel_1(), BorderLayout.EAST);
		GUIKontroler.promeniStanjeRacuna(textField_stanjeNaRacunu);
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
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
	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
			mntmOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (tabbedPane.getSelectedIndex() == 0) {
						GUIKontroler.ucitajIzFajlaKupac(ProdajaList);
						}
					
					if(tabbedPane.getSelectedIndex() == 1) {
						GUIKontroler.ucitajIzFajlaDobavljac(nabavkaList);
						}
					
					if (tabbedPane.getSelectedIndex() == 2) {
						GUIKontroler.ucitajIzFajlaZaposleni(zaposleniList);
						}
					
				}
			});
			mntmOpen.setIcon(new ImageIcon(ProdavnicaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		}
		return mntmOpen;
	}
	private JMenuItem getMntmSave() {
		if (mntmSave == null) {
			mntmSave = new JMenuItem("Save");
			mntmSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (tabbedPane.getSelectedIndex() == 0) {
						GUIKontroler.sacuvajUFajlKupac();
						}
					
					if(tabbedPane.getSelectedIndex() == 1) {
						GUIKontroler.sacuvajUFajlDobavljac();
						}
					
					if (tabbedPane.getSelectedIndex() == 2) {
						GUIKontroler.sacuvajUFajlZaposleni();
						}
					
				}
			});
			mntmSave.setIcon(new ImageIcon(ProdavnicaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		}
		return mntmSave;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.ugasiAplikaciju();
				}
			});
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
	protected JTextField getTextField_stanjeNaRacunu() {
		if (textField_stanjeNaRacunu == null) {
			textField_stanjeNaRacunu = new JTextField();
			textField_stanjeNaRacunu.setEditable(false);
			textField_stanjeNaRacunu.setColumns(10);
		}
		return textField_stanjeNaRacunu;
	}
	private JMenuItem getMntmAboutProgram() {
		if (mntmAboutProgram == null) {
			mntmAboutProgram = new JMenuItem("About program");
			mntmAboutProgram.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.prikaziInformacije();
				}
			});
		}
		return mntmAboutProgram;
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
	protected JList getProdajaList() {
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
	protected JList getNabavkaList() {
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
	protected JList getZaposleniList() {
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
			panel_1.add(getBtnDodajZaposlenog(), "cell 0 2");
			panel_1.add(getBtnPronai(), "cell 0 3,growx");
			panel_1.add(getBtnNaruci(), "cell 0 4,growx");
			panel_1.add(getBtnNewButton(), "cell 0 5");
		}
		return panel_1;
	}
	private JButton getBtnDodajProizvod() {
		if (btnDodajProizvod == null) {
			btnDodajProizvod = new JButton("Dodaj/Obrisi");
			btnDodajProizvod.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.prikaziDodaj();
				}
			});
		}
		return btnDodajProizvod;
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
			btnPronai.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.prikaziPronadji();
				}
			});
		}
		return btnPronai;
	}
	private JButton getBtnNaruci() {
		if (btnNaruci == null) {
			btnNaruci = new JButton("Primi narudzbinu");
			btnNaruci.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.prikaziPrimiNarudzbinu();
				}
			});
		}
		return btnNaruci;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Naruci proizvode  ");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.prikaziNaruciProizvod();
				}
			});
		}
		return btnNewButton;
	}
}
