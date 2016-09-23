package ch.ibw.kap_5;

public class MainAdresse {

	public static void main(String[] args) {
	
		Adresse[] adressen = new Adresse[10];
		
		Adresse adresse1 = new Adresse();
		adresse1.setWohnort("Grüsch");
		adresse1.setPostleitzahl(7214);
		adresse1.setName("Paul Berger");
		adresse1.setStrasse("Bahnhofstrasse");
		adressen[0] = adresse1;
		
		Adresse adresse2 = new Adresse();
		adresse2.setWohnort("Landquart");
		adresse2.setPostleitzahl(7302);
		adresse2.setName("Hans Meier");
		adresse2.setStrasse("Hauptstrasse");
		adressen[1] = adresse2;
		
		Adresse adresse3 = new Adresse();
		adresse3.setWohnort("Chur");
		adresse3.setPostleitzahl(7000);
		adresse3.setName("Anna Huber");
		adresse3.setStrasse("Nebenstrasse");
		adressen[2] = adresse3;
		
		for (int i = 0; i < adressen.length; i++) {
			if(adressen[i] != null){
				System.out.println(adressen[i].getName() + "\n" + adressen[i].getStrasse() 
						+ "\n" + adressen[i].getPostleitzahl() + " " + adressen[i].getWohnort() + "\n");
			}	
		}
		
		for (Adresse adresse : adressen) {
			if(adresse != null){
				System.out.println(adresse);
			}
		}
		
		Person person1 = new Person();
		person1.firstName ="Sepp";
		person1.lastName = "Müller";
	}

}
