package ch.ibw.kap_5;

public class Adresse {
	private String name;
	private String strasse;
	private int hausnummer;
	private int postleitzahl;
	private String wohnort;
	private String mail;
	private String kommentar;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getStrasse() {
		return strasse;
	}
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	
	public int getHausnummer() {
		return hausnummer;
	}
	public void setHausnummer(int hausnummer) {
		this.hausnummer = hausnummer;
	}
	
	public String getWohnort() {
		return wohnort;
	}	
	public void setWohnort(String wohnort) {
		this.wohnort = wohnort;
	}
	
	public String getMail() {
		return mail;
	}	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getKommentar() {
		return kommentar;
	}	
	public void setKommentar(String kommentar) {
		this.kommentar = kommentar;
	}
	public int getPostleitzahl() {
		return postleitzahl;
	}
	public void setPostleitzahl(int postleitzahl) {
		this.postleitzahl = postleitzahl;
	}
	@Override
	public String toString() {
		return this.getName() + "\n" + getStrasse() 
		+ "\n" + this.getPostleitzahl() + " " + this.getWohnort() + "\n";
	}
	

	
}
