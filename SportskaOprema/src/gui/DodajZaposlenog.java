package gui;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * prozor preko kog se vrsi dodavanje novog zaposlenog
 *
 */
public class DodajZaposlenog extends JFrame {

	private JPanel contentPane;
	private JLabel lblIme;
	private JLabel lblPrezime;
	private JTextField textField_imeZaposlenog;
	private JTextField textField_prezimeZaposlenog;
	private JLabel lblPol;
	private JLabel lblIdzaposlenog;
	private JLabel lblAdresa;
	private JLabel lblBrTelefona;
	private JTextField textField_Adresa;
	private JTextField textField_brtelefona;
	private JButton btnUnesiNovogZaposlenog;
	private JButton btnOdustani;
	private JTextField textField_Id_Zaposlenog;
	private JComboBox<String> comboBox;
	
	/**
	 * Create the frame.
	 */
	public DodajZaposlenog() {
		setResizable(false);
		setTitle("Dodavanje zaposlenog");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		contentPane.add(getLblIme());
		contentPane.add(getLblPrezime());
		contentPane.add(getTextField_imeZaposlenog());
		contentPane.add(getTextField_prezimeZaposlenog());
		contentPane.add(getLblPol());
		contentPane.add(getLblIdzaposlenog());
		contentPane.add(getComboBox());
		contentPane.add(getTextField_Id_Zaposlenog());
		contentPane.add(getLblAdresa());
		contentPane.add(getLblBrTelefona());
		contentPane.add(getTextField_Adresa());
		contentPane.add(getTextField_brtelefona());
		contentPane.add(getBtnUnesiNovogZaposlenog());
		contentPane.add(getBtnOdustani());
		
	}

	private JLabel getLblIme() {
		if (lblIme == null) {
			lblIme = new JLabel("Ime:");
			lblIme.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblIme;
	}
	private JLabel getLblPrezime() {
		if (lblPrezime == null) {
			lblPrezime = new JLabel("Prezime:");
			lblPrezime.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblPrezime;
	}
	private JTextField getTextField_imeZaposlenog() {
		if (textField_imeZaposlenog == null) {
			textField_imeZaposlenog = new JTextField();
			textField_imeZaposlenog.setColumns(10);
		}
		return textField_imeZaposlenog;
	}
	private JTextField getTextField_prezimeZaposlenog() {
		if (textField_prezimeZaposlenog == null) {
			textField_prezimeZaposlenog = new JTextField();
			textField_prezimeZaposlenog.setColumns(10);
		}
		return textField_prezimeZaposlenog;
	}
	private JLabel getLblPol() {
		if (lblPol == null) {
			lblPol = new JLabel("Pol:");
			lblPol.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblPol;
	}
	private JLabel getLblIdzaposlenog() {
		if (lblIdzaposlenog == null) {
			lblIdzaposlenog = new JLabel("ID_Zaposlenog:");
			lblIdzaposlenog.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblIdzaposlenog;
	}

	private JLabel getLblAdresa() {
		if (lblAdresa == null) {
			lblAdresa = new JLabel("Adresa:");
			lblAdresa.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblAdresa;
	}
	private JLabel getLblBrTelefona() {
		if (lblBrTelefona == null) {
			lblBrTelefona = new JLabel("Br. Telefona:");
			lblBrTelefona.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblBrTelefona;
	}
	private JTextField getTextField_Adresa() {
		if (textField_Adresa == null) {
			textField_Adresa = new JTextField();
			textField_Adresa.setColumns(10);
		}
		return textField_Adresa;
	}
	private JTextField getTextField_brtelefona() {
		if (textField_brtelefona == null) {
			textField_brtelefona = new JTextField();
			textField_brtelefona.setColumns(10);
		}
		return textField_brtelefona;
	}
	private JButton getBtnUnesiNovogZaposlenog() {
		if (btnUnesiNovogZaposlenog == null) {
			btnUnesiNovogZaposlenog = new JButton("Unesi Novog Zaposlenog");
			btnUnesiNovogZaposlenog.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						GUIKontroler.dodajZaposlenog(getTextField_imeZaposlenog().getText(),getTextField_prezimeZaposlenog().getText(), getComboBox().getSelectedItem().toString(),
								getTextField_brtelefona().getText(), getTextField_Id_Zaposlenog().getText(),getTextField_Adresa().getText());
						dispose();
					} catch (Exception e) {
						GUIKontroler.prikaziGresku();
					}

				}
			});
		}
		return btnUnesiNovogZaposlenog;
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
	
	private JTextField getTextField_Id_Zaposlenog() {
		if (textField_Id_Zaposlenog == null) {
			textField_Id_Zaposlenog = new JTextField();
			textField_Id_Zaposlenog.setColumns(10);
		}
		return textField_Id_Zaposlenog;
	}
	private JComboBox<String> getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox<String>();
			comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"musko", "zensko"}));
		}
		return comboBox;
	}
}
