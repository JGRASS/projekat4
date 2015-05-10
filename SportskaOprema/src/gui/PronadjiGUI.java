package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class PronadjiGUI extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JButton btnOdustani;
	private JButton btnPronai;
	private JLabel lblUnesiteNazivProizvoda;
	private JTextField nazivProizvodaTextField;
	private JLabel lblId;
	private JTextField idProizvodaTextField;
	private JLabel lblKoliina;
	private JTextField kolicinaProizvodaTextField;
	private JLabel lblCena;
	private JTextField cenaProizvodaTextField;
	private JLabel lblObavestenje;
	private JTextField proizvodObavestenjeTextField;
	private JLabel lblUnesiteImeKupca;
	private JTextField imeKupcaTextField;
	private JLabel lblNewLabel;
	private JTextField kupacObavestenjeTextField;
	private JLabel lblId_1;
	private JTextField kupacIDTextField;
	private JLabel lblNewLabel_1;
	private JTextField kupacNovacTextField;
	private JSplitPane splitPane;
	private JPanel panel_4;
	private JLabel lblUnesiteIme;
	private JTextField imeDobavljacTextField;
	private JLabel lblId_2;
	private JTextField dobavljacIDTextField;
	private JLabel lblAdresa;
	private JTextField dobAdresaTextField;
	private JLabel lblTelefon;
	private JTextField dobTelefonTextField;
	private JPanel panel_5;
	private JList dobavljacProizvodilist;
	private JLabel lblObavetenje;
	private JTextField dobObavestenjetextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PronadjiGUI frame = new PronadjiGUI();
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
	public PronadjiGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PronadjiGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Question.gif")));
		setResizable(false);
		setTitle("Pronadji");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 545, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getTabbedPane(), BorderLayout.CENTER);
		contentPane.add(getPanel_3(), BorderLayout.SOUTH);
	}

	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.addTab("Proizvod", null, getPanel(), null);
			tabbedPane.addTab("Kupac", null, getPanel_1(), null);
			tabbedPane.addTab("Dobavlja\u010D", null, getPanel_2(), null);
		}
		return tabbedPane;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLblUnesiteNazivProizvoda());
			panel.add(getNazivProizvodaTextField());
			panel.add(getLblId());
			panel.add(getIdProizvodaTextField());
			panel.add(getLblKoliina());
			panel.add(getKolicinaProizvodaTextField());
			panel.add(getLblCena());
			panel.add(getCenaProizvodaTextField());
			panel.add(getLblObavestenje());
			panel.add(getProizvodObavestenjeTextField());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getLblUnesiteImeKupca());
			panel_1.add(getImeKupcaTextField());
			panel_1.add(getLabel_1());
			panel_1.add(getKupacObavestenjeTextField());
			panel_1.add(getLabel_2());
			panel_1.add(getKupacIDTextField());
			panel_1.add(getLabel_3());
			panel_1.add(getKupacNovacTextField());
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(new BorderLayout(0, 0));
			panel_2.add(getSplitPane(), BorderLayout.CENTER);
		}
		return panel_2;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel_3.add(getBtnPronai());
			panel_3.add(getBtnOdustani());
		}
		return panel_3;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
		}
		return btnOdustani;
	}
	private JButton getBtnPronai() {
		if (btnPronai == null) {
			btnPronai = new JButton("Prona\u0111i");
			btnPronai.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (tabbedPane.getSelectedIndex() == 0) {
						if(GUIKontroler.pronadjiProizvod(nazivProizvodaTextField.getText()) != null) {
						idProizvodaTextField.setText(""+GUIKontroler.pronadjiProizvod(nazivProizvodaTextField.getText()).getId());
						kolicinaProizvodaTextField.setText(""+GUIKontroler.pronadjiProizvod(nazivProizvodaTextField.getText()).getKolicina());
						cenaProizvodaTextField.setText(""+GUIKontroler.pronadjiProizvod(nazivProizvodaTextField.getText()).getCena());
						proizvodObavestenjeTextField.setText("Proizvod je pronadjen.");
						} else {
							idProizvodaTextField.setText("");
							kolicinaProizvodaTextField.setText("");
							cenaProizvodaTextField.setText("");
							proizvodObavestenjeTextField.setText("Proizvod nije pronadjen.");
						}
					}
					if(tabbedPane.getSelectedIndex() == 1) {
						if (GUIKontroler.pronadjiKupca(imeKupcaTextField.getText()) != null) {
							kupacIDTextField.setText(""+GUIKontroler.pronadjiKupca(imeKupcaTextField.getText()).getId());
							kupacNovacTextField.setText(""+GUIKontroler.pronadjiKupca(imeKupcaTextField.getText()).getkolicinaNovca());
							kupacObavestenjeTextField.setText("Kupac je pronadjen.");
						}
						else {
							kupacObavestenjeTextField.setText("Kupac nije pronadjen.");
							kupacIDTextField.setText("");
							kupacNovacTextField.setText("");
							kupacObavestenjeTextField.setText("Kupac nije pronadjen.");
						}
					}
					if (tabbedPane.getSelectedIndex() == 2) {
						if (GUIKontroler.pronadjiDobavljaca(imeDobavljacTextField.getText()) != null) {
							dobavljacIDTextField.setText(GUIKontroler.pronadjiDobavljaca(imeDobavljacTextField.getText()).getDobavljacId());
							dobAdresaTextField.setText(GUIKontroler.pronadjiDobavljaca(imeDobavljacTextField.getText()).getAdresa());
							dobTelefonTextField.setText(GUIKontroler.pronadjiDobavljaca(imeDobavljacTextField.getText()).getTelefon());
							dobObavestenjetextField.setText("Dobavljač je pronađen.");
							dobavljacProizvodilist.setListData(GUIKontroler.pronadjiDobavljaca(imeDobavljacTextField.getText()).getProizvodi().toArray());
						} else {
							dobavljacIDTextField.setText("");
							dobAdresaTextField.setText("");
							dobTelefonTextField.setText("");
							dobObavestenjetextField.setText("Dobavljač nije pronađen.");
							dobavljacProizvodilist.clearSelection();
						}
					}
				}
			});
		}
		return btnPronai;
	}
	private JLabel getLblUnesiteNazivProizvoda() {
		if (lblUnesiteNazivProizvoda == null) {
			lblUnesiteNazivProizvoda = new JLabel("Unesite naziv proizvoda :");
			lblUnesiteNazivProizvoda.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblUnesiteNazivProizvoda.setBounds(166, 19, 183, 20);
		}
		return lblUnesiteNazivProizvoda;
	}
	private JTextField getNazivProizvodaTextField() {
		if (nazivProizvodaTextField == null) {
			nazivProizvodaTextField = new JTextField();
			nazivProizvodaTextField.setBounds(166, 50, 183, 29);
			nazivProizvodaTextField.setColumns(10);
		}
		return nazivProizvodaTextField;
	}
	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID :");
			lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblId.setBounds(37, 105, 46, 14);
		}
		return lblId;
	}
	private JTextField getIdProizvodaTextField() {
		if (idProizvodaTextField == null) {
			idProizvodaTextField = new JTextField();
			idProizvodaTextField.setEditable(false);
			idProizvodaTextField.setBounds(84, 100, 114, 29);
			idProizvodaTextField.setColumns(10);
		}
		return idProizvodaTextField;
	}
	private JLabel getLblKoliina() {
		if (lblKoliina == null) {
			lblKoliina = new JLabel("Koli\u010Dina :");
			lblKoliina.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblKoliina.setBounds(255, 107, 83, 12);
		}
		return lblKoliina;
	}
	private JTextField getKolicinaProizvodaTextField() {
		if (kolicinaProizvodaTextField == null) {
			kolicinaProizvodaTextField = new JTextField();
			kolicinaProizvodaTextField.setEditable(false);
			kolicinaProizvodaTextField.setBounds(336, 100, 114, 29);
			kolicinaProizvodaTextField.setColumns(10);
		}
		return kolicinaProizvodaTextField;
	}
	private JLabel getLblCena() {
		if (lblCena == null) {
			lblCena = new JLabel("Cena :");
			lblCena.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblCena.setBounds(25, 181, 46, 20);
		}
		return lblCena;
	}
	private JTextField getCenaProizvodaTextField() {
		if (cenaProizvodaTextField == null) {
			cenaProizvodaTextField = new JTextField();
			cenaProizvodaTextField.setEditable(false);
			cenaProizvodaTextField.setBounds(84, 183, 114, 29);
			cenaProizvodaTextField.setColumns(10);
		}
		return cenaProizvodaTextField;
	}
	private JLabel getLblObavestenje() {
		if (lblObavestenje == null) {
			lblObavestenje = new JLabel("Obave\u0161tenje :");
			lblObavestenje.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblObavestenje.setBounds(221, 184, 104, 15);
		}
		return lblObavestenje;
	}
	private JTextField getProizvodObavestenjeTextField() {
		if (proizvodObavestenjeTextField == null) {
			proizvodObavestenjeTextField = new JTextField();
			proizvodObavestenjeTextField.setEditable(false);
			proizvodObavestenjeTextField.setBounds(336, 183, 152, 29);
			proizvodObavestenjeTextField.setColumns(10);
		}
		return proizvodObavestenjeTextField;
	}
	private JLabel getLblUnesiteImeKupca() {
		if (lblUnesiteImeKupca == null) {
			lblUnesiteImeKupca = new JLabel("Unesite ime kupca :");
			lblUnesiteImeKupca.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblUnesiteImeKupca.setBounds(164, 11, 165, 24);
		}
		return lblUnesiteImeKupca;
	}
	private JTextField getImeKupcaTextField() {
		if (imeKupcaTextField == null) {
			imeKupcaTextField = new JTextField();
			imeKupcaTextField.setBounds(164, 46, 152, 29);
			imeKupcaTextField.setColumns(10);
		}
		return imeKupcaTextField;
	}
	private JLabel getLabel_1() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Obave\u0161tenje :");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(36, 108, 108, 24);
		}
		return lblNewLabel;
	}
	private JTextField getKupacObavestenjeTextField() {
		if (kupacObavestenjeTextField == null) {
			kupacObavestenjeTextField = new JTextField();
			kupacObavestenjeTextField.setEditable(false);
			kupacObavestenjeTextField.setBounds(164, 108, 152, 29);
			kupacObavestenjeTextField.setColumns(10);
		}
		return kupacObavestenjeTextField;
	}
	private JLabel getLabel_2() {
		if (lblId_1 == null) {
			lblId_1 = new JLabel("ID :");
			lblId_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblId_1.setBounds(36, 158, 70, 24);
		}
		return lblId_1;
	}
	private JTextField getKupacIDTextField() {
		if (kupacIDTextField == null) {
			kupacIDTextField = new JTextField();
			kupacIDTextField.setEditable(false);
			kupacIDTextField.setBounds(166, 162, 150, 29);
			kupacIDTextField.setColumns(10);
		}
		return kupacIDTextField;
	}
	private JLabel getLabel_3() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Koli\u010Dina potro\u0161enog novca :");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_1.setBounds(36, 220, 202, 14);
		}
		return lblNewLabel_1;
	}
	private JTextField getKupacNovacTextField() {
		if (kupacNovacTextField == null) {
			kupacNovacTextField = new JTextField();
			kupacNovacTextField.setEditable(false);
			kupacNovacTextField.setBounds(248, 219, 152, 29);
			kupacNovacTextField.setColumns(10);
		}
		return kupacNovacTextField;
	}
	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setLeftComponent(getPanel_4());
			splitPane.setRightComponent(getPanel_5());
			splitPane.setDividerLocation(220);
		}
		return splitPane;
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setLayout(null);
			panel_4.add(getLblUnesiteIme());
			panel_4.add(getImeDobavljacTextField());
			panel_4.add(getLblId_2());
			panel_4.add(getDobavljacIDTextField());
			panel_4.add(getLblAdresa());
			panel_4.add(getTextField_1());
			panel_4.add(getLblTelefon());
			panel_4.add(getTextField_2());
			panel_4.add(getLblObavetenje());
			panel_4.add(getDobObavestenjetextField());
		}
		return panel_4;
	}
	private JLabel getLblUnesiteIme() {
		if (lblUnesiteIme == null) {
			lblUnesiteIme = new JLabel("Unesite ime dobavlja\u010Da :");
			lblUnesiteIme.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblUnesiteIme.setBounds(10, 11, 157, 14);
		}
		return lblUnesiteIme;
	}
	private JTextField getImeDobavljacTextField() {
		if (imeDobavljacTextField == null) {
			imeDobavljacTextField = new JTextField();
			imeDobavljacTextField.setBounds(10, 36, 157, 20);
			imeDobavljacTextField.setColumns(10);
		}
		return imeDobavljacTextField;
	}
	private JLabel getLblId_2() {
		if (lblId_2 == null) {
			lblId_2 = new JLabel("ID :");
			lblId_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblId_2.setBounds(10, 67, 46, 14);
		}
		return lblId_2;
	}
	private JTextField getDobavljacIDTextField() {
		if (dobavljacIDTextField == null) {
			dobavljacIDTextField = new JTextField();
			dobavljacIDTextField.setEditable(false);
			dobavljacIDTextField.setBounds(79, 67, 122, 20);
			dobavljacIDTextField.setColumns(10);
		}
		return dobavljacIDTextField;
	}
	private JLabel getLblAdresa() {
		if (lblAdresa == null) {
			lblAdresa = new JLabel("Adresa :");
			lblAdresa.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblAdresa.setBounds(10, 99, 62, 14);
		}
		return lblAdresa;
	}
	private JTextField getTextField_1() {
		if (dobAdresaTextField == null) {
			dobAdresaTextField = new JTextField();
			dobAdresaTextField.setEditable(false);
			dobAdresaTextField.setBounds(79, 98, 120, 20);
			dobAdresaTextField.setColumns(10);
		}
		return dobAdresaTextField;
	}
	private JLabel getLblTelefon() {
		if (lblTelefon == null) {
			lblTelefon = new JLabel("Telefon :");
			lblTelefon.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblTelefon.setBounds(10, 135, 62, 14);
		}
		return lblTelefon;
	}
	private JTextField getTextField_2() {
		if (dobTelefonTextField == null) {
			dobTelefonTextField = new JTextField();
			dobTelefonTextField.setEditable(false);
			dobTelefonTextField.setBounds(79, 134, 122, 20);
			dobTelefonTextField.setColumns(10);
		}
		return dobTelefonTextField;
	}
	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setLayout(new BorderLayout(0, 0));
			panel_5.add(getDobavljacProizvodilist(), BorderLayout.CENTER);
		}
		return panel_5;
	}
	private JList getDobavljacProizvodilist() {
		if (dobavljacProizvodilist == null) {
			dobavljacProizvodilist = new JList();
		}
		return dobavljacProizvodilist;
	}
	private JLabel getLblObavetenje() {
		if (lblObavetenje == null) {
			lblObavetenje = new JLabel("Obave\u0161tenje :");
			lblObavetenje.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblObavetenje.setBounds(10, 176, 92, 14);
		}
		return lblObavetenje;
	}
	private JTextField getDobObavestenjetextField() {
		if (dobObavestenjetextField == null) {
			dobObavestenjetextField = new JTextField();
			dobObavestenjetextField.setEditable(false);
			dobObavestenjetextField.setBounds(10, 201, 191, 20);
			dobObavestenjetextField.setColumns(10);
		}
		return dobObavestenjetextField;
	}
}
