package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import prodavnica.Kupac;
import prodavnica.Proizvod;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

import javax.swing.JCheckBox;

import nabavka.Dobavljac;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class DodajGUI extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JList list;
	private JLabel lblId;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JList list_1;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JList list_2;


	/**
	 * Create the frame.
	 */
	public DodajGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DodajGUI.class.getResource("/Icons/green-plus-hi.png")));
		setTitle("Dodavanje");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 632, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getTabbedPane(), BorderLayout.CENTER);
		contentPane.add(getPanel_3(), BorderLayout.SOUTH);
		GUIKontroler.osveziListuDobavljaca(list_2);
		GUIKontroler.osveziListuKupaca(list_1);
		GUIKontroler.osveziListuProizvoda(list);
	}

	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.addTab("Proizvod", null, getPanel(), null);
			tabbedPane.addTab("Kupac", null, getPanel_1(), null);
			tabbedPane.addTab("Dobavljac", null, getPanel_2(), null);
		}
		return tabbedPane;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getList_1());
			panel.add(getLblId());
			panel.add(getLblNewLabel());
			panel.add(getTextField());
			panel.add(getTextField_1());
			panel.add(getLblNewLabel_1());
			panel.add(getLblNewLabel_2());
			panel.add(getTextField_2());
			panel.add(getTextField_3());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getLblNewLabel_3());
			panel_1.add(getLblNewLabel_4());
			panel_1.add(getLblNewLabel_5());
			panel_1.add(getTextField_4());
			panel_1.add(getTextField_5());
			panel_1.add(getTextField_6());
			panel_1.add(getList_1_1());
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.add(getLblNewLabel_6());
			panel_2.add(getLblNewLabel_7());
			panel_2.add(getLblNewLabel_8());
			panel_2.add(getLblNewLabel_9());
			panel_2.add(getTextField_7());
			panel_2.add(getTextField_8());
			panel_2.add(getTextField_9());
			panel_2.add(getTextField_10());
			panel_2.add(getList_2());
		}
		return panel_2;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.add(getBtnNewButton());
			panel_3.add(getBtnNewButton_2());
			panel_3.add(getBtnNewButton_1());
		}
		return panel_3;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Dodaj");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(tabbedPane.getSelectedIndex()==0){
						if(GUIKontroler.proverIdProizvoda(textField.getText())){
						GUIKontroler.dodajProizvod(textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText());
						list.setListData(GUIKontroler.prikaziProizvode().toArray());
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						}
						else {
							textField.setText("ID vec zauzet");
						}
					}
					if(tabbedPane.getSelectedIndex()==1){
						if(GUIKontroler.proveriIdKupca(textField_4.getText())){
						GUIKontroler.dodajKupca(textField_4.getText(),textField_5.getText(),textField_6.getText());
						list_1.setListData(GUIKontroler.prikaziSveKupce().toArray());
						
						textField_4.setText("");
						textField_5.setText("");
						textField_6.setText("");
					}
						else{
							textField_4.setText("ID vec zauzet");
						}
					}
					if(tabbedPane.getSelectedIndex()==2){
						if(GUIKontroler.proveriIdDobavljaca(textField_7.getText())){
						GUIKontroler.dodajDobavljaca(textField_7.getText(),textField_8.getText(),textField_9.getText(),textField_10.getText());
						list_2.setListData(GUIKontroler.prikaziSveDobavljace().toArray());
						textField_7.setText("");
						textField_8.setText("");
						textField_9.setText("");
						textField_10.setText("");
						}else{
							textField_7.setText("ID vec zauzet");
						}
					}
				}
			});
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Odustani");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
		}
		return btnNewButton_1;
	}
	private JList getList_1() {
		if (list == null) {
			list = new JList();
			list.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					try {
						Proizvod p=(Proizvod)(list.getSelectedValue());
						textField.setText(p.getId());
						textField.setEditable(false);
						textField_1.setText(p.getNaziv());
						textField_1.setEditable(false);
						textField_2.setText(p.getCena()+"");
						textField_2.setEditable(false);
						textField_3.setText(p.getKolicina()+"");
						textField_3.setEditable(false);
					} catch (Exception e) {
						
						JOptionPane.showMessageDialog(contentPane,
								"Lista je prazna", "Greska",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			list.setFont(new Font("Tahoma", Font.PLAIN, 10));
			list.setBorder(new TitledBorder(null, "Asortiman:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			list.setBounds(206, 11, 395, 257);
		}
		return list;
	}
	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID");
			lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblId.setBounds(10, 41, 46, 28);
		}
		return lblId;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Naziv");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel.setBounds(10, 97, 46, 28);
		}
		return lblNewLabel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(66, 42, 113, 28);
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(66, 98, 113, 28);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Cena");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(10, 155, 46, 28);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Koli\u010Dina");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_2.setBounds(10, 210, 46, 35);
		}
		return lblNewLabel_2;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setBounds(66, 156, 113, 28);
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setBounds(66, 214, 113, 28);
			textField_3.setColumns(10);
		}
		return textField_3;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("Obrisi");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(tabbedPane.getSelectedIndex()==0){
						
							Proizvod p=(Proizvod)(list.getSelectedValue());
							
							GUIKontroler.izbrisiProizvod(p);
							list.setListData(GUIKontroler.prikaziProizvode().toArray());
						
						textField.setText("");
						textField.setEditable(true);
						textField_1.setText("");
						textField_1.setEditable(true);
						textField_2.setText("");
						textField_2.setEditable(true);
						textField_3.setText("");
						textField_3.setEditable(true);
                        
					}
					if(tabbedPane.getSelectedIndex()==1){
						Kupac p=(Kupac)(list_1.getSelectedValue());
						GUIKontroler.izbrisiKupca(p);
						list_1.setListData(GUIKontroler.prikaziSveKupce().toArray());
						
						textField_4.setText("");
						textField_4.setEditable(true);
						textField_5.setText("");
						textField_5.setEditable(true);
						textField_6.setText("");
						textField_6.setEditable(true); 
					}
					if(tabbedPane.getSelectedIndex()==2){
						Dobavljac p=(Dobavljac)(list_2.getSelectedValue());
						GUIKontroler.izbrisiDobavljaca(p);
						list_2.setListData(GUIKontroler.prikaziSveDobavljace().toArray());
						textField_7.setText("");
						textField_7.setEditable(true);
						textField_8.setText("");
						textField_8.setEditable(true);
						textField_9.setText("");
						textField_9.setEditable(true); 
						textField_10.setText("");
						textField_10.setEditable(true);
					}
				}
			});
		}
		return btnNewButton_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("ID");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_3.setBounds(10, 28, 80, 33);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("Ime");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_4.setBounds(10, 100, 80, 33);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("Potroseno novca");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_5.setBounds(10, 191, 94, 33);
		}
		return lblNewLabel_5;
	}
	private JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setBounds(114, 32, 101, 26);
			textField_4.setColumns(10);
		}
		return textField_4;
	}
	private JTextField getTextField_5() {
		if (textField_5 == null) {
			textField_5 = new JTextField();
			textField_5.setBounds(114, 104, 101, 26);
			textField_5.setColumns(10);
		}
		return textField_5;
	}
	private JTextField getTextField_6() {
		if (textField_6 == null) {
			textField_6 = new JTextField();
			textField_6.setBounds(114, 195, 101, 26);
			textField_6.setColumns(10);
		}
		return textField_6;
	}
	private JList getList_1_1() {
		if (list_1 == null) {
			list_1 = new JList();
			list_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
			list_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					try {
						Kupac p=(Kupac)(list_1.getSelectedValue());
						
						textField_4.setText(p.getId());
						textField_4.setEditable(false);
						textField_5.setText(p.getIme());
						textField_5.setEditable(false);
						textField_6.setText(p.getkolicinaNovca()+"");
						textField_6.setEditable(false);
					} catch (Exception e) {
						
						JOptionPane.showMessageDialog(contentPane,
								"Lista je prazna", "Greska",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			list_1.setBorder(new TitledBorder(null, "Kupci", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			list_1.setBounds(225, 11, 376, 263);
		}
		return list_1;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("ID");
			lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_6.setBounds(10, 14, 53, 37);
		}
		return lblNewLabel_6;
	}
	private JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("Ime");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_7.setBounds(10, 77, 53, 37);
		}
		return lblNewLabel_7;
	}
	private JLabel getLblNewLabel_8() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel("Adresa");
			lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_8.setBounds(10, 142, 53, 37);
		}
		return lblNewLabel_8;
	}
	private JLabel getLblNewLabel_9() {
		if (lblNewLabel_9 == null) {
			lblNewLabel_9 = new JLabel("Telefon");
			lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_9.setBounds(10, 203, 53, 45);
		}
		return lblNewLabel_9;
	}
	private JTextField getTextField_7() {
		if (textField_7 == null) {
			textField_7 = new JTextField();
			textField_7.setBounds(73, 19, 110, 29);
			textField_7.setColumns(10);
		}
		return textField_7;
	}
	private JTextField getTextField_8() {
		if (textField_8 == null) {
			textField_8 = new JTextField();
			textField_8.setBounds(73, 82, 110, 29);
			textField_8.setColumns(10);
		}
		return textField_8;
	}
	private JTextField getTextField_9() {
		if (textField_9 == null) {
			textField_9 = new JTextField();
			textField_9.setBounds(73, 147, 110, 29);
			textField_9.setColumns(10);
		}
		return textField_9;
	}
	private JTextField getTextField_10() {
		if (textField_10 == null) {
			textField_10 = new JTextField();
			textField_10.setBounds(73, 212, 110, 29);
			textField_10.setColumns(10);
		}
		return textField_10;
	}
	private JList getList_2() {
		if (list_2 == null) {
			list_2 = new JList();
			list_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
			list_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					try {
						Dobavljac p=(Dobavljac)(list_2.getSelectedValue());
						textField_7.setText(p.getDobavljacId());
						textField_7.setEditable(false);
						textField_8.setText(p.getIme());
						textField_8.setEditable(false);
						textField_9.setText(p.getAdresa());
						textField_9.setEditable(false);
						textField_10.setText(p.getTelefon());
						textField_10.setEditable(false);
					} catch (Exception e) {
						
						JOptionPane.showMessageDialog(contentPane,
								"Lista je prazna", "Greska",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			list_2.setBorder(new TitledBorder(null, "Dobavljaci", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			list_2.setBounds(193, 14, 408, 260);
		}
		return list_2;
	}
}
