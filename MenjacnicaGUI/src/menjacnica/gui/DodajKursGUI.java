package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import menjacnica.Kurs;
import menjacnica.gui.modeli.PrikazKursevaTableModel;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;

public class DodajKursGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSifra;
	private JTextField textFieldNaziv;
	private JTextField textFieldProdajni;
	private JTextField textFieldKupovni;
	private JTextField textFieldSrednji;
	private JTextField textFieldSkracenNaziv;
	private JButton btnNewButton;
	private JButton btnOdustani;
	private JLabel lblNewLabel;
	private JLabel lblNaziv;
	private JLabel lblProdajniKurs;
	private JLabel lblKupovniKurs;
	private JLabel lblSrednjiKurs;
	private JLabel lblSkracenNaziv;
	public static void otvoriDodajKurs(){
		DodajKursGUI frame = new DodajKursGUI();
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
	public DodajKursGUI() {
		setResizable(false);
		setTitle("DodajKurs");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTextFieldSifra());
		contentPane.add(getTextFieldNaziv());
		contentPane.add(getTextFieldProdajni());
		contentPane.add(getTextFieldKupovni());
		contentPane.add(getTextFieldSrednji());
		contentPane.add(getTextFieldSkracenNaziv());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnOdustani());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNaziv());
		contentPane.add(getLblProdajniKurs());
		contentPane.add(getLblKupovniKurs());
		contentPane.add(getLblSrednjiKurs());
		contentPane.add(getLblSkracenNaziv());
	}
	private JTextField getTextFieldSifra() {
		if (textFieldSifra == null) {
			textFieldSifra = new JTextField();
			textFieldSifra.setBounds(10, 40, 200, 30);
			textFieldSifra.setColumns(10);
		}
		return textFieldSifra;
	}
	private JTextField getTextFieldNaziv() {
		if (textFieldNaziv == null) {
			textFieldNaziv = new JTextField();
			textFieldNaziv.setColumns(10);
			textFieldNaziv.setBounds(224, 40, 200, 30);
		}
		return textFieldNaziv;
	}
	private JTextField getTextFieldProdajni() {
		if (textFieldProdajni == null) {
			textFieldProdajni = new JTextField();
			textFieldProdajni.setColumns(10);
			textFieldProdajni.setBounds(10, 107, 200, 30);
		}
		return textFieldProdajni;
	}
	private JTextField getTextFieldKupovni() {
		if (textFieldKupovni == null) {
			textFieldKupovni = new JTextField();
			textFieldKupovni.setColumns(10);
			textFieldKupovni.setBounds(224, 107, 200, 30);
		}
		return textFieldKupovni;
	}
	private JTextField getTextFieldSrednji() {
		if (textFieldSrednji == null) {
			textFieldSrednji = new JTextField();
			textFieldSrednji.setColumns(10);
			textFieldSrednji.setBounds(10, 174, 200, 30);
		}
		return textFieldSrednji;
	}
	private JTextField getTextFieldSkracenNaziv() {
		if (textFieldSkracenNaziv == null) {
			textFieldSkracenNaziv = new JTextField();
			textFieldSkracenNaziv.setColumns(10);
			textFieldSkracenNaziv.setBounds(224, 174, 200, 30);
		}
		return textFieldSkracenNaziv;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Dodaj");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String sifra = textFieldSifra.getText();
					String naziv = textFieldNaziv.getText();
					String prodajni = textFieldProdajni.getText();
					String kupovni = textFieldKupovni.getText();
					String srednji = textFieldSrednji.getText();
					String skracenNaziv = textFieldSkracenNaziv.getText();
					String tekst = "Sifra proizvoda je: "+sifra+", naziv: "+naziv+",prodajni kurs: "+prodajni+", kupovni: "+kupovni+", srednji: "+
									srednji+", skracen naziv: "+skracenNaziv;
					Kurs k = new Kurs(Integer.parseInt(sifra), skracenNaziv, Double.parseDouble(prodajni),Double.parseDouble(srednji),
									Double.parseDouble(kupovni),naziv);
					MenjacnicaGUI.kursevi.add(k);
					MenjacnicaGUI.textAreaStatus.append(tekst+"\n");
					azurirajTabelu();
					dispose();
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnNewButton.setBounds(10, 227, 200, 30);
		}
		return btnNewButton;
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
			btnOdustani.setBounds(224, 227, 200, 30);
		}
		return btnOdustani;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Sifra");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel.setBounds(10, 15, 200, 14);
		}
		return lblNewLabel;
	}
	private JLabel getLblNaziv() {
		if (lblNaziv == null) {
			lblNaziv = new JLabel("Naziv");
			lblNaziv.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNaziv.setBounds(224, 15, 200, 14);
		}
		return lblNaziv;
	}
	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs");
			lblProdajniKurs.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblProdajniKurs.setBounds(10, 82, 200, 14);
		}
		return lblProdajniKurs;
	}
	private JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni kurs");
			lblKupovniKurs.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblKupovniKurs.setBounds(224, 81, 200, 14);
		}
		return lblKupovniKurs;
	}
	private JLabel getLblSrednjiKurs() {
		if (lblSrednjiKurs == null) {
			lblSrednjiKurs = new JLabel("Srednji kurs");
			lblSrednjiKurs.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblSrednjiKurs.setBounds(10, 149, 200, 14);
		}
		return lblSrednjiKurs;
	}
	private JLabel getLblSkracenNaziv() {
		if (lblSkracenNaziv == null) {
			lblSkracenNaziv = new JLabel("Skracen naziv");
			lblSkracenNaziv.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblSkracenNaziv.setBounds(224, 148, 200, 14);
		}
		return lblSkracenNaziv;
	}
	public void azurirajTabelu(){
		PrikazKursevaTableModel model = (PrikazKursevaTableModel) MenjacnicaGUI.table.getModel();
		model.azurirajTabelu(MenjacnicaGUI.kursevi);
	}
}
