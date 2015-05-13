package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import nabavka.Dobavljac;
import net.miginfocom.swing.MigLayout;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JList;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import prodavnica.Proizvod;

import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
/**
 * preko ovog prozora vrsimo nabavljanje novih proizvoda
 *
 */
public class Naruci extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JList listProizvodi;
	private JPanel panel_1;
	private JScrollPane scrollPane_1;
	private JList listDobavljaci;
	private JLabel lblId;
	private JTextField textFieldID;
	private JLabel lblNewLabel;
	private JTextField textFieldNaziv;
	private JLabel lblNewLabel_1;
	private JTextField textFieldCena;
	private JLabel lblNewLabel_2;
	private JTextField textFieldKolicina;
	private JButton btnNewButton;
	private double racun=0;

	
	/**
	 * Create the frame.
	 */
	public Naruci(double tekuci) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Naruci.class.getResource("/Icons/order-online-2.png")));
		setTitle("Naruci");
		setResizable(false);
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				GUIKontroler.osveziListuDobavljaca(listDobavljaci);
				
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 514, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.EAST);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
		racun=tekuci;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new MigLayout("", "[grow]", "[][][][][][][][][][]"));
			panel.add(getLblId(), "cell 0 0");
			panel.add(getTextFieldID(), "cell 0 1,growx");
			panel.add(getLblNewLabel(), "cell 0 2");
			panel.add(getTextFieldNaziv(), "cell 0 3,growx");
			panel.add(getLblNewLabel_1(), "cell 0 4");
			panel.add(getTextFieldCena(), "cell 0 5,growx");
			panel.add(getLblNewLabel_2(), "cell 0 6");
			panel.add(getTextFieldKolicina(), "cell 0 7,growx");
			panel.add(getBtnNewButton(), "cell 0 9,alignx center");
		}
		return panel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getListProizvodi());
			scrollPane.setColumnHeaderView(getPanel_1());
		}
		return scrollPane;
	}
	private JList getListProizvodi() {
		if (listProizvodi == null) {
			listProizvodi = new JList();
			listProizvodi.setFont(new Font("Tahoma", Font.PLAIN, 10));
			listProizvodi.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					try {
						Proizvod p=(Proizvod)(listProizvodi.getSelectedValue());
						
						textFieldNaziv.setText(p.getNaziv());
						textFieldNaziv.setEditable(false);
						textFieldCena.setText(p.getCena()+"");
						textFieldCena.setEditable(false);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(contentPane,
								"Lista je prazna", "Greska",
								JOptionPane.ERROR_MESSAGE);
					}
					
				}
			});
		}
		return listProizvodi;
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
			scrollPane_1.setViewportView(getListDobavljaci());
		}
		return scrollPane_1;
	}
	private JList getListDobavljaci() {
		if (listDobavljaci == null) {
			listDobavljaci = new JList();
			listDobavljaci.setFont(new Font("Tahoma", Font.PLAIN, 10));
			listDobavljaci.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					try {
						Dobavljac p=(Dobavljac)(listDobavljaci.getSelectedValue());
						listProizvodi.setListData(p.getProizvodi().toArray());
					} catch (Exception e) {
						JOptionPane.showMessageDialog(contentPane,
								"Lista je prazna", "Greska",
								JOptionPane.ERROR_MESSAGE);
					}
					
					
				}
			});
		}
		return listDobavljaci;
	}
	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID");
		}
		return lblId;
	}
	private JTextField getTextFieldID() {
		if (textFieldID == null) {
			textFieldID = new JTextField();
			textFieldID.setColumns(10);
		}
		return textFieldID;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Naziv");
		}
		return lblNewLabel;
	}
	private JTextField getTextFieldNaziv() {
		if (textFieldNaziv == null) {
			textFieldNaziv = new JTextField();
			textFieldNaziv.setColumns(10);
		}
		return textFieldNaziv;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Cena");
		}
		return lblNewLabel_1;
	}
	private JTextField getTextFieldCena() {
		if (textFieldCena == null) {
			textFieldCena = new JTextField();
			textFieldCena.setColumns(10);
		}
		return textFieldCena;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Kolicina");
		}
		return lblNewLabel_2;
	}
	private JTextField getTextFieldKolicina() {
		if (textFieldKolicina == null) {
			textFieldKolicina = new JTextField();
			textFieldKolicina.setColumns(10);
		}
		return textFieldKolicina;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Naruci");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						Proizvod c=(Proizvod)(listProizvodi.getSelectedValue());
						if(Integer.parseInt(textFieldKolicina.getText())<=c.getKolicina()){
							if((Double.parseDouble(textFieldCena.getText())*Integer.parseInt(textFieldKolicina.getText()))<racun){
						GUIKontroler.naruciProizvod((Dobavljac)(listDobavljaci.getSelectedValue()),textFieldID.getText(),textFieldCena.getText(),textFieldNaziv.getText(),textFieldKolicina.getText());
						dispose();
							}
							else {
								JOptionPane.showMessageDialog(contentPane,
										"Nemate dovoljno novca na racunu", "Greska",
										JOptionPane.ERROR_MESSAGE);
							}
						}
						else{
							JOptionPane.showMessageDialog(contentPane,
									"Dobavljac nema zeljenu kolicinu proizvoda", "Greska",
									JOptionPane.ERROR_MESSAGE);
						}
					} catch (NumberFormatException e) {
						GUIKontroler.prikaziGresku();
					} catch (HeadlessException e) {
						GUIKontroler.prikaziGresku();
					}
				}
			});
		}
		return btnNewButton;
	}
}
