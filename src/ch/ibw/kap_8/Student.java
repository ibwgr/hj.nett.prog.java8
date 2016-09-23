package ch.ibw.kap_8;

public class Student {
	
	private String name;
	private int nummer;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNummer() {
		return nummer;
	}
	public void setNummer(int nummer) {
		int alteNummer = this.nummer;
		this.nummer = nummer;
		if(!valideteNummer()){
			this.nummer = alteNummer;
		}		
		this.nummer = nummer;
	}

	public boolean valideteNummer(){
		return ((nummer >= 10000) && (nummer <= 99999) && (nummer % 2 != 0));
	}
	@Override
	public String toString() {
		return name + " (" + nummer + ")"; 
	}
	
	
}
