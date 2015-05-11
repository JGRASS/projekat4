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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import prodavnica.Kupac;
import prodavnica.Proizvod;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Font;

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
	private JPanel panel_1;
	private JScrollPane scrollPane_1;
	private JList Proizvodilist;


	/**
	 * Create the frame.
	 */
	public PrimiNarudzbinuGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PrimiNarudzbinuGUI.class.getResource("/Icons/hg.jpg")));
		setResizable(false);
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				GUIKontroler.osveziListuKupaca(KupciList);
				GUIKontroler.osveziListuProizvoda(Proizvodilist);
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		setTitle("Primi narudzbinu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 547, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
		contentPane.add(getPanel(), BorderLayout.EAST);
		GUIKontroler.osveziListuKupaca(KupciList);
		GUIKontroler.osveziListuProizvoda(Proizvodilist);
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getKupciList());
			scrollPane.setColumnHeaderView(getPanel_1());
		}
		return scrollPane;
	}
	private JList getKupciList() {
		if (KupciList == null) {
			KupciList = new JList();
			KupciList.setFont(new Font("Tahoma", Font.PLAIN, 10));
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
			lblKolicina = new JLabel("Koli\u010Dina");
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
					Proizvod c=(Proizvod)(Proizvodilist.getSelectedValue());
					if(Integer.parseInt(kolicinatextField.getText())<=c.getKolicina()){
					GUIKontroler.primiNarudzbenicu(((Kupac) KupciList.getSelectedValue()), imeProizvodatextField.getText(), idProizvodatextField.getText(), kolicinatextField.getText(), Double.parseDouble(cenatextField.getText()));
					dispose();
					}
					else{
						JOptionPane.showMessageDialog(contentPane,
								"Nema dovoljno proizvoda", "Greska",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return btnOk;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new GridLayout(0, 1, 0, 0));
			panel_1.add(getScrollPane_1());
		}
		return panel_1;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setViewportView(getProizvodilist());
		}
		return scrollPane_1;
	}
	private JList getProizvodilist() {
		if (Proizvodilist == null) {
			Proizvodilist = new JList();
			Proizvodilist.setFont(new Font("Tahoma", Font.PLAIN, 10));
			Proizvodilist.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					try {
						Proizvod p= (Proizvod)(Proizvodilist.getSelectedValue());
						imeProizvodatextField.setText(p.getNaziv());
						imeProizvodatextField.setEditable(false);
						idProizvodatextField.setText(p.getId());
						idProizvodatextField.setEditable(false);
						cenatextField.setText(p.getCena()+"");
						cenatextField.setEditable(false);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(contentPane,
								"Lista je prazna", "Greska",
								JOptionPane.ERROR_MESSAGE);
					}
					
				}
			});
		}
		return Proizvodilist;
	}
}
