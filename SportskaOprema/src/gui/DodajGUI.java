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

import prodavnica.Proizvod;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

import javax.swing.JCheckBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodajGUI frame = new DodajGUI();
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
	public DodajGUI() {
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
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
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
						
						GUIKontroler.dodajProizvod(textField.getText(),textField_1.getText(),Double.parseDouble(textField_2.getText()),Integer.parseInt(textField_3.getText()));
						list.setListData(GUIKontroler.prikaziProizvode().toArray());
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						
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
			list.setBounds(257, 11, 344, 257);
		}
		return list;
	}
	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID");
			lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblId.setBounds(10, 32, 107, 28);
		}
		return lblId;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Naziv");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel.setBounds(129, 32, 107, 28);
		}
		return lblNewLabel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(10, 63, 113, 28);
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(129, 63, 113, 28);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Cena");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(10, 125, 107, 28);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Koli\u010Dina");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_2.setBounds(129, 122, 107, 35);
		}
		return lblNewLabel_2;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setBounds(10, 162, 113, 28);
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setBounds(129, 162, 113, 28);
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
				}
			});
		}
		return btnNewButton_2;
	}
}
