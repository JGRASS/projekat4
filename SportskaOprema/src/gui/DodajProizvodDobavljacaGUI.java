package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import nabavka.Dobavljac;

public class DodajProizvodDobavljacaGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblNazivProizvoda;
	private JTextField textField;
	private JLabel lblIdProizvoda;
	private JTextField textField_1;
	private JLabel lblCena;
	private JTextField textField_2;
	private JLabel lblKolicina;
	private JTextField textField_3;
	private JButton btnOk;
	private JButton btnOdustani;
	private JScrollPane scrollPane;
	private JList list;
    private Dobavljac c=new Dobavljac();

	/**
	 * Create the frame.
	 */
	public DodajProizvodDobavljacaGUI(Dobavljac p) {
		setTitle("Dodaj proizvod");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 606, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNazivProizvoda());
		contentPane.add(getTextField());
		contentPane.add(getLblIdProizvoda());
		contentPane.add(getTextField_1());
		contentPane.add(getLblCena());
		contentPane.add(getTextField_2());
		contentPane.add(getLblKolicina());
		contentPane.add(getTextField_3());
		contentPane.add(getBtnOk());
		contentPane.add(getBtnOdustani());
		contentPane.add(getScrollPane());
		c=p;
		list.setListData(c.getProizvodi().toArray());
	}

	private JLabel getLblNazivProizvoda() {
		if (lblNazivProizvoda == null) {
			lblNazivProizvoda = new JLabel("Naziv proizvoda");
			lblNazivProizvoda.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNazivProizvoda.setBounds(21, 31, 123, 14);
		}
		return lblNazivProizvoda;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(147, 30, 109, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblIdProizvoda() {
		if (lblIdProizvoda == null) {
			lblIdProizvoda = new JLabel("ID proizvoda");
			lblIdProizvoda.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblIdProizvoda.setBounds(21, 85, 123, 14);
		}
		return lblIdProizvoda;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(147, 84, 109, 20);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JLabel getLblCena() {
		if (lblCena == null) {
			lblCena = new JLabel("Cena");
			lblCena.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblCena.setBounds(23, 136, 46, 14);
		}
		return lblCena;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setBounds(147, 135, 109, 20);
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	private JLabel getLblKolicina() {
		if (lblKolicina == null) {
			lblKolicina = new JLabel("Kolicina");
			lblKolicina.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblKolicina.setBounds(21, 192, 89, 14);
		}
		return lblKolicina;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setBounds(147, 191, 109, 20);
			textField_3.setColumns(10);
		}
		return textField_3;
	}
	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("OK");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {		
					GUIKontroler.dodajProizvodDobavljaca(textField.getText(),
							textField_1.getText(), textField_2.getText(), 
							textField_3.getText(),c);
					dispose();
				}
			});
			btnOk.setBounds(191, 238, 89, 23);
		}
		return btnOk;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnOdustani.setBounds(290, 238, 89, 23);
		}
		return btnOdustani;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(297, 31, 282, 204);
			scrollPane.setViewportView(getList());
		}
		return scrollPane;
	}
	private JList getList() {
		if (list == null) {
			list = new JList();
		}
		return list;
	}
}
