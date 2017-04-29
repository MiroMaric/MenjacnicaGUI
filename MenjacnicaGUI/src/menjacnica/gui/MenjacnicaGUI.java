package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import menjacnica.Kurs;
import menjacnica.gui.modeli.PrikazKursevaTableModel;

import javax.swing.JTable;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.awt.Component;

public class MenjacnicaGUI extends JFrame {

	protected static final Component MenjacnicaGUI = null;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JButton btnObrisiKurs;
	private JButton btnDodajKurs;
	private JButton btnIzvrsiZamenu;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnHelp;
	private JPanel panel_1;
	private JScrollPane scrollPane_1;
	public static JTextArea textAreaStatus;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private JMenuItem mntmAbout;
	public static JTable table;
	private JPopupMenu popupMenu;
	private JMenuItem mntmDodajKurs;
	private JMenuItem mntmObrisiKurs;
	private JMenuItem mntmIzvrsiZamenu;
	public static LinkedList<Kurs> kursevi = new LinkedList<>();
	/**
	 * Create the frame.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenjacnicaGUI frame = new MenjacnicaGUI();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.addWindowListener(new WindowAdapter() {
						private Component frame;
						@Override
						public void windowClosing(WindowEvent e) {
							int odgovor = JOptionPane.showConfirmDialog(frame, "Da li zelite da zatvorite aplikaciju?", "Zatvaranje", JOptionPane.YES_NO_OPTION);
							if(odgovor == JOptionPane.YES_OPTION)
								System.exit(0);
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public MenjacnicaGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenjacnicaGUI.class.getResource("/coin.png")));
		setTitle("Menjacnica");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 720, 500);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
		contentPane.add(getPanel(), BorderLayout.EAST);
		contentPane.add(getPanel_1(), BorderLayout.SOUTH);
	}
	
	
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			addPopup(scrollPane, getPopupMenu_1());
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.setPreferredSize(new Dimension(180, 0));
			panel.add(getBtnObrisiKurs());
			panel.add(getBtnDodajKurs());
			panel.add(getBtnIzvrsiZamenu());
		}
		return panel;
	}
	private JButton getBtnObrisiKurs() {
		if (btnObrisiKurs == null) {
			btnObrisiKurs = new JButton("Obrisi kurs");
			btnObrisiKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PrikazKursevaTableModel model = (PrikazKursevaTableModel)table.getModel();
					if(table.getSelectedRow()!=-1){
						ObrisiKursGUI.otvoriObrisiKursGUI();
						int sifra = (int)model.getValueAt(getTable().getSelectedRow(),0);
						String skracenNaziv = (String)model.getValueAt(getTable().getSelectedRow(),1);
						double prodajni = (double)model.getValueAt(getTable().getSelectedRow(),2);
						double srednji = (double)model.getValueAt(getTable().getSelectedRow(),3);
						double kupovni = (double)model.getValueAt(getTable().getSelectedRow(),4);
						String naziv = (String)model.getValueAt(getTable().getSelectedRow(),5);
						ObrisiKursGUI.podesiPoljaObrisiKursGui(sifra, skracenNaziv, prodajni, srednji, kupovni, naziv);
					}
					else{
						JOptionPane.showMessageDialog(MenjacnicaGUI, "Morate prvo selektovati kurs koji zelite da obrisete",
								"Greksa", JOptionPane.OK_OPTION);
					}
				}
			});
			btnObrisiKurs.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnObrisiKurs.setBounds(10, 53, 160, 23);
		}
		return btnObrisiKurs;
	}
	private JButton getBtnDodajKurs() {
		if (btnDodajKurs == null) {
			btnDodajKurs = new JButton("Dodaj kurs");
			btnDodajKurs.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					DodajKursGUI.otvoriDodajKurs();
				}
			});
			btnDodajKurs.setForeground(Color.BLACK);
			btnDodajKurs.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnDodajKurs.setBounds(10, 19, 160, 23);
		}
		return btnDodajKurs;
	}
	private JButton getBtnIzvrsiZamenu() {
		if (btnIzvrsiZamenu == null) {
			btnIzvrsiZamenu = new JButton("Izvrsi zamenu");
			btnIzvrsiZamenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnIzvrsiZamenu.setBounds(10, 87, 160, 23);
		}
		return btnIzvrsiZamenu;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmOpen());
			mnFile.add(getMntmSave());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 2), "STATUS", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setPreferredSize(new Dimension(0, 100));
			panel_1.setLayout(new BorderLayout(0, 0));
			panel_1.add(getScrollPane_1(), BorderLayout.CENTER);
		}
		return panel_1;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setViewportView(getTextAreaStatus());
		}
		return scrollPane_1;
	}
	private JTextArea getTextAreaStatus() {
		if (textAreaStatus == null) {
			textAreaStatus = new JTextArea();
			textAreaStatus.setEditable(false);
		}
		return textAreaStatus;
	}
	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
			mntmOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String fajl = "Ucitan fajl: ";
					JFileChooser fc = new JFileChooser();
					int o = fc.showOpenDialog(MenjacnicaGUI);
					if(o==JFileChooser.APPROVE_OPTION){
						File f = fc.getSelectedFile();
						fajl += f.getAbsolutePath();
					}
					if(fajl!="Ucitan fajl: ")
						textAreaStatus.append(fajl+"\n");
				}
			});
			mntmOpen.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
			mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		}
		return mntmOpen;
	}
	private JMenuItem getMntmSave() {
		if (mntmSave == null) {
			mntmSave = new JMenuItem("Save");
			mntmSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String fajl = "Sacuvan fajl: ";
					JFileChooser fc = new JFileChooser();
					int o = fc.showSaveDialog(MenjacnicaGUI);
					if(o==JFileChooser.APPROVE_OPTION){
						File f = fc.getSelectedFile();
						fajl+=f.getAbsolutePath();
					}
					if(fajl!="Sacuvan fajl: ")
						textAreaStatus.append(fajl+"\n");
				}
			});
			mntmSave.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
			mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		}
		return mntmSave;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int odgovor = JOptionPane.showConfirmDialog(MenjacnicaGUI, "Da li zelite da zatvorite aplikaciju?",
							"Zatvaranje",JOptionPane.YES_NO_CANCEL_OPTION);
					if(odgovor == JOptionPane.YES_OPTION)
						System.exit(0);
				}
			});
			mntmExit.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		}
		return mntmExit;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(MenjacnicaGUI, "Domaci zadatak: MenjacnicaGUI\nMiro Maric 1031/16\n2017", "About",JOptionPane.INFORMATION_MESSAGE);
				}
			});
			mntmAbout.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/DetailsView.gif")));
		}
		return mntmAbout;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new PrikazKursevaTableModel(null));
			
		}
		
		return table;
	}
	private JPopupMenu getPopupMenu_1() {
		if (popupMenu == null) {
			popupMenu = new JPopupMenu();
			popupMenu.add(getMntmDodajKurs());
			popupMenu.add(getMntmObrisiKurs());
			popupMenu.add(getMntmIzvrsiZamenu());
		}
		return popupMenu;
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	private JMenuItem getMntmDodajKurs() {
		if (mntmDodajKurs == null) {
			mntmDodajKurs = new JMenuItem("Dodaj kurs");
			mntmDodajKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				getBtnDodajKurs().doClick();
				}
			});
		}
		return mntmDodajKurs;
	}
	private JMenuItem getMntmObrisiKurs() {
		if (mntmObrisiKurs == null) {
			mntmObrisiKurs = new JMenuItem("Obrisi kurs");
			mntmObrisiKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					getBtnObrisiKurs().doClick();
				}
			});
		}
		return mntmObrisiKurs;
	}
	private JMenuItem getMntmIzvrsiZamenu() {
		if (mntmIzvrsiZamenu == null) {
			mntmIzvrsiZamenu = new JMenuItem("Izvrsi zamenu");
		}
		return mntmIzvrsiZamenu;
	}
	public static void azurirajTabelu(){
		PrikazKursevaTableModel model = (PrikazKursevaTableModel) table.getModel();
		model.azurirajTabelu(kursevi);
	}
	public static void obrisiKurs(int index){
		if(index!=-1)
			kursevi.remove(index);
	}
}
