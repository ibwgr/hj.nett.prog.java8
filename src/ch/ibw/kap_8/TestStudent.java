package ch.ibw.kap_8;

public class TestStudent {
	
	public static void main(String[] args){
		
		Student studi1 = new Student();
		studi1.setName("Meier");
		studi1.setNummer(70615);
        studi1.setFach(Student.BIOLOGIESTUDIUM);
        studi1.setGeschlecht(Student.MAENNLICH);
        System.out.println(studi1);

        Student studi3 = new Student(1985);
        studi3.setName("Müller");
        studi3.setNummer(19783);
        studi3.setFach(Student.INFORMATIKSTUDIUM);
        studi3.setGeschlecht(Student.WEIBLICH);
        System.out.println(studi3);

        Student studi2 = new Student("Huber",15315, Student.MATHEMATIKSTUDIUM, 1968);
        System.out.println(studi2);

        Student studi4 = new Student("Berger", 62871, Student.PHYSIKSTUDIUM,1988, Student.WEIBLICH);
        System.out.println(studi4);

        System.out.println("Anzahl Studenten: " + Student.getZaehler());
    }

}
