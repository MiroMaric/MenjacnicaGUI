package menjacnica;

public class Kurs {
	private int sifra;
	private String skracenNaziv;
	private double prodajni;
	private double srednji;
	private double kupovni;
	private String naziv;
	
	public Kurs(int sifra, String skracenNaziv, double prodajni, double srednji, double kupovni, String naziv) {
		this.sifra = sifra;
		this.skracenNaziv = skracenNaziv;
		this.prodajni = prodajni;
		this.srednji = srednji;
		this.kupovni = kupovni;
		this.naziv = naziv;
	}

	public int getSifra() {
		return sifra;
	}

	public void setSifra(int sifra) {
		this.sifra = sifra;
	}

	public String getSkracenNaziv() {
		return skracenNaziv;
	}

	public void setSkracenNaziv(String skracenNaziv) {
		this.skracenNaziv = skracenNaziv;
	}

	public double getProdajni() {
		return prodajni;
	}

	public void setProdajni(double prodajni) {
		this.prodajni = prodajni;
	}

	public double getSrednji() {
		return srednji;
	}

	public void setSrednji(double srednji) {
		this.srednji = srednji;
	}

	public double getKupovni() {
		return kupovni;
	}

	public void setKupovni(double kupovni) {
		this.kupovni = kupovni;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
}
