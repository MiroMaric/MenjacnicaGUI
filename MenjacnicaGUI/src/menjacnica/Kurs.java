package menjacnica;

public class Kurs {
	private int sifra;
	private String skracenNaziv;
	private double prodajni;
	private double srednji;
	private double kupovni;
	private String naziv;
	
	public Kurs(int sifra, String skracenNaziv, double prodajni, double srednji, double kupovni, String naziv) {
		setSifra(sifra);
		setKupovni(kupovni);
		setNaziv(naziv);
		setSkracenNaziv(skracenNaziv);
		setProdajni(prodajni);
		setSrednji(srednji);
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
		if(skracenNaziv!=null && skracenNaziv.length()<5)
			this.skracenNaziv = skracenNaziv;
		else
			throw new RuntimeException("Skracen naziv valute mora biti unet i manji od 5 karaktera.");
	}

	public double getProdajni() {
		return prodajni;
	}

	public void setProdajni(double prodajni) {
		if(prodajni>0)
			this.prodajni = prodajni;
		else
			throw new RuntimeException("Prodajni kurs mora biti unet kao i veci od nule");
	}

	public double getSrednji() {
		return srednji;
	}

	public void setSrednji(double srednji) {
		if(srednji>0)
			this.srednji = srednji;
		else
			throw new RuntimeException("Srednji kurs mora biti unet kao i veci od nule");
	}

	public double getKupovni() {
		return kupovni;
	}

	public void setKupovni(double kupovni) {
		if(kupovni>0)
			this.kupovni = kupovni;
		else
			throw new RuntimeException("Kupovni kurs mora biti unet kao i veci od nule");
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		if(naziv!=null)
			this.naziv = naziv;
		else
			throw new RuntimeException("Naziv mora biti unet");
	}
	
}
