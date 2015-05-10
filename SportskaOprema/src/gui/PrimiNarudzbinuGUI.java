package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import prodavnica.Kupac;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

public class PrimiNarudzbinuGUI extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JList KupciList;
	private JPanel panel;
	private JLabel lblNazivProizvoda;
	private JTextField imeProizvodatextField;
	private JLabel lblIdProizvoda;
	private JTextField idProizvodatextField;
	private JLabel lblKolicina;
	private JTextField kolicinatextField;
	private JLabel lblCena;
	private JTextField cenatextField;
	private JButton btnDodajKupca;
	private JButton btnOk;


	/**
	 * Create the frame.
	 */
	public PrimiNarudzbinuGUI() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				GUIKontroler.osveziListuKupaca(KupciList);
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		setTitle("Primi narudzbinu");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
		contentPane.add(getPanel(), BorderLayout.EAST);
		GUIKontroler.osveziListuKupaca(KupciList);
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getKupciList());
		}
		return scrollPane;
	}
	private JList getKupciList() {
		if (KupciList == null) {
			KupciList = new JList();
		}
		return KupciList;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new MigLayout("", "[grow]", "[][][][][][][][][][][]"));
			panel.add(getLblNazivProizvoda(), "cell 0 0");
			panel.add(getImeProizvodatextField(), "cell 0 1,growx");
			panel.add(getLblIdProizvoda(), "cell 0 2");
			panel.add(getIdProizvodatextField(), "cell 0 3,growx");
			panel.add(getLblKolicina(), "cell 0 4");
			panel.add(getKolicinatextField(), "cell 0 5,growx");
			panel.add(getLblCena(), "cell 0 6");
			panel.add(getCenatextField(), "cell 0 7,growx");
			panel.add(getBtnDodajKupca(), "cell 0 9,growx");
			panel.add(getBtnOk(), "cell 0 10,growx");
		}
		return panel;
	}
	private JLabel getLblNazivProizvoda() {
		if (lblNazivProizvoda == null) {
			lblNazivProizvoda = new JLabel("Naziv proizvoda");
		}
		return lblNazivProizvoda;
	}
	private JTextField getImeProizvodatextField() {
		if (imeProizvodatextField == null) {
			imeProizvodatextField = new JTextField();
			imeProizvodatextField.setColumns(10);
		}
		return imeProizvodatextField;
	}
	private JLabel getLblIdProizvoda() {
		if (lblIdProizvoda == null) {
			lblIdProizvoda = new JLabel("ID proizvoda");
		}
		return lblIdProizvoda;
	}
	private JTextField getIdProizvodatextField() {
		if (idProizvodatextField == null) {
			idProizvodatextField = new JTextField();
			idProizvodatextField.setColumns(10);
		}
		return idProizvodatextField;
	}
	private JLabel getLblKolicina() {
		if (lblKolicina == null) {
			lblKolicina = new JLabel("Kolicina");
		}
		return lblKolicina;
	}
	private JTextField getKolicinatextField() {
		if (kolicinatextField == null) {
			kolicinatextField = new JTextField();
			kolicinatextField.setColumns(10);
		}
		return kolicinatextField;
	}
	private JLabel getLblCena() {
		if (lblCena == null) {
			lblCena = new JLabel("Cena");
		}
		return lblCena;
	}
	private JTextField getCenatextField() {
		if (cenatextField == null) {
			cenatextField = new JTextField();
			cenatextField.setColumns(10);
		}
		return cenatextField;
	}
	private JButton getBtnDodajKupca() {
		if (btnDodajKupca == null) {
			btnDodajKupca = new JButton("Dodaj kupca");
			btnDodajKupca.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.prikaziDodaj();
				}
			});
		}
		return btnDodajKupca;
	}
	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("Ok");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.primiNarudzbenicu(((Kupac) KupciList.getSelectedValue()), imeProizvodatextField.getText(), idProizvodatextField.getText(), Integer.parseInt(kolicinatextField.getText()), Double.parseDouble(cenatextField.getText()));
					dispose();
				}
			});
		}
		return btnOk;
	}
}
