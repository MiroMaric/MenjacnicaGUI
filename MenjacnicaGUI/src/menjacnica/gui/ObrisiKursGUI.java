package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import menjacnica.Kurs;
import menjacnica.gui.modeli.PrikazKursevaTableModel;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;

public class ObrisiKursGUI extends JFrame {

	private JPanel contentPane;
	private static JTextField textFieldSifra;
	private JLabel label;
	private JLabel label_1;
	private static JTextField textFieldNaziv;
	private JLabel label_2;
	private static JTextField textFieldKupovni;
	private  static JTextField textFieldProdajni;
	private JLabel label_3;
	private JLabel label_4;
	private static JTextField textFieldSrednji;
	private static JTextField textFieldSkracen;
	private JLabel label_5;
	private JButton btnObrisi;
	private JButton btnOdustani;
	private JCheckBox chckbxNewCheckBox;

	/**
	 * Launch the application.
	 */
	public static void otvoriObrisiKursGUI(){
			ObrisiKursGUI frame = new ObrisiKursGUI();
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			frame.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					frame.dispose();
				}
			});
	}

	/**
	 * Create the frame.
	 */
	public ObrisiKursGUI() {
		setResizable(false);
		setTitle("Obrisi kurs");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTextFieldSifra());
		contentPane.add(getLabel());
		contentPane.add(getLabel_1());
		contentPane.add(getTextFieldNaziv());
		contentPane.add(getLabel_2());
		contentPane.add(getTextFieldKupovni());
		contentPane.add(getTextFieldProdajni());
		contentPane.add(getLabel_3());
		contentPane.add(getLabel_4());
		contentPane.add(getTextFieldSrednji());
		contentPane.add(getTextFieldSkracen());
		contentPane.add(getLabel_5());
		contentPane.add(getBtnObrisi());
		contentPane.add(getBtnOdustani());
		contentPane.add(getChckbxNewCheckBox());
	}
	
	private JTextField getTextFieldSifra() {
		if (textFieldSifra == null) {
			textFieldSifra = new JTextField();
			textFieldSifra.setEditable(false);
			textFieldSifra.setColumns(10);
			textFieldSifra.setBounds(10, 36, 200, 30);
		}
		return textFieldSifra;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Sifra");
			label.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label.setBounds(10, 11, 200, 14);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("Naziv");
			label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_1.setBounds(224, 11, 200, 14);
		}
		return label_1;
	}
	private JTextField getTextFieldNaziv() {
		if (textFieldNaziv == null) {
			textFieldNaziv = new JTextField();
			textFieldNaziv.setEditable(false);
			textFieldNaziv.setColumns(10);
			textFieldNaziv.setBounds(224, 36, 200, 30);
		}
		return textFieldNaziv;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("Kupovni kurs");
			label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_2.setBounds(224, 77, 200, 14);
		}
		return label_2;
	}
	private JTextField getTextFieldKupovni() {
		if (textFieldKupovni == null) {
			textFieldKupovni = new JTextField();
			textFieldKupovni.setEditable(false);
			textFieldKupovni.setColumns(10);
			textFieldKupovni.setBounds(224, 103, 200, 30);
		}
		return textFieldKupovni;
	}
	private JTextField getTextFieldProdajni() {
		if (textFieldProdajni == null) {
			textFieldProdajni = new JTextField();
			textFieldProdajni.setEditable(false);
			textFieldProdajni.setColumns(10);
			textFieldProdajni.setBounds(10, 103, 200, 30);
		}
		return textFieldProdajni;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("Prodajni kurs");
			label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_3.setBounds(10, 78, 200, 14);
		}
		return label_3;
	}
	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("Srednji kurs");
			label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_4.setBounds(10, 145, 200, 14);
		}
		return label_4;
	}
	private JTextField getTextFieldSrednji() {
		if (textFieldSrednji == null) {
			textFieldSrednji = new JTextField();
			textFieldSrednji.setEditable(false);
			textFieldSrednji.setColumns(10);
			textFieldSrednji.setBounds(10, 170, 200, 30);
		}
		return textFieldSrednji;
	}
	private JTextField getTextFieldSkracen() {
		if (textFieldSkracen == null) {
			textFieldSkracen = new JTextField();
			textFieldSkracen.setEditable(false);
			textFieldSkracen.setColumns(10);
			textFieldSkracen.setBounds(224, 170, 200, 30);
		}
		return textFieldSkracen;
	}
	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("Skracen naziv");
			label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_5.setBounds(224, 144, 200, 14);
		}
		return label_5;
	}
	private JButton getBtnObrisi() {
		if (btnObrisi == null) {
			btnObrisi = new JButton("Obrisi");
			btnObrisi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int red = MenjacnicaGUI.table.getSelectedRow();
					if(red!=-1){
						String sifra = textFieldSifra.getText();
						String kupovni = textFieldKupovni.getText();
						String naziv = textFieldNaziv.getText();
						String prodajni = textFieldProdajni.getText();
						String skracenNaziv = textFieldSkracen.getText();
						String srednji = textFieldSrednji.getText();
						MenjacnicaGUI.obrisiKurs(red);
						String tekst = "Obrisan je kurs. Sifra kurs. Sifra kursa je: " + sifra + ", naziv: " + naziv + ",prodajni kurs: " + prodajni
								+ ", kupovni: " + kupovni + ", srednji: " + srednji + ", skracen naziv: " + skracenNaziv;
							MenjacnicaGUI.textAreaStatus.append(tekst+"\n");
						MenjacnicaGUI.azurirajTabelu();
						textFieldKupovni.setText("");textFieldNaziv.setText("");textFieldProdajni.setText("");
						textFieldSifra.setText("");textFieldSkracen.setText("");textFieldSrednji.setText("");
						dispose();
					}
				}
			});
			btnObrisi.setEnabled(false);
			btnObrisi.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnObrisi.setBounds(10, 250, 200, 30);
		}
		return btnObrisi;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnOdustani.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnOdustani.setBounds(224, 250, 200, 30);
		}
		return btnOdustani;
	}
	private JCheckBox getChckbxNewCheckBox() {
		if (chckbxNewCheckBox == null) {
			chckbxNewCheckBox = new JCheckBox("Zaista obrisi kurs");
			chckbxNewCheckBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(chckbxNewCheckBox.isSelected())
						btnObrisi.setEnabled(true);
					else
						btnObrisi.setEnabled(false);
					
				}
			});
			chckbxNewCheckBox.setBounds(10, 220, 200, 23);
		}
		return chckbxNewCheckBox;
	}
	public static void podesiPoljaObrisiKursGui(int sifra, String skracenNaziv, double prodajni, double srednji, double kupovni, String naziv){
		textFieldSifra.setText(sifra+"");
		textFieldKupovni.setText(kupovni+"");
		textFieldNaziv.setText(naziv);
		textFieldProdajni.setText(prodajni+"");
		textFieldSkracen.setText(skracenNaziv+"");
		textFieldSrednji.setText(srednji+"");
	}
}
