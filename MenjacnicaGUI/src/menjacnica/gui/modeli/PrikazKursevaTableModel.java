package menjacnica.gui.modeli;

import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import menjacnica.Kurs;

public class PrikazKursevaTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private String[] kolone = {"Sifra","Skraceni naziv","Prodajni","Srednji","Kupovni","Naziv"};
	private List<Kurs> kursevi;
	
	public PrikazKursevaTableModel(LinkedList<Kurs> kursevi) {
		if(kursevi==null)
			this.kursevi = new LinkedList<>();
		else
			this.kursevi = kursevi;
	}
	@Override
	public int getColumnCount() {
		return	kolone.length;
	}

	@Override
	public int getRowCount() {
		return kursevi.size();
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Kurs k = kursevi.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return k.getSifra();
		case 1:
			return k.getSkracenNaziv();
		case 2:
			return k.getProdajni();
		case 3: 
			return k.getSrednji();
		case 4:
			return k.getKupovni();
		case 5:
			return k.getNaziv();
		default:
			return "Nepoznato.";
		}
	}
	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}
	public void azurirajTabelu(List<Kurs> kursevi){
		this.kursevi = kursevi;
		fireTableDataChanged();
	}
	public Kurs vratiKurs(int index){
		return kursevi.get(index);
	}
}
