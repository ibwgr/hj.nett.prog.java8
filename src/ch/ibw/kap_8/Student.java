package ch.ibw.kap_8;

public class Student {

	/* ==========
     KONSTANTEN
     ==========
   */

	/** Diese Konstante symbolisiert das Studienfach
	 Mathematik */
	public static final int MATHEMATIKSTUDIUM = 1;

	/** Diese Konstante symbolisiert das Studienfach
	 Informatik */
	public static final int INFORMATIKSTUDIUM = 2;

	/** Diese Konstante symbolisiert das Studienfach
	 Architektur */
	public static final int ARCHITEKTURSTUDIUM = 3;

	/** Diese Konstante symbolisiert das Studienfach
	 der Wirtschaftswissenschaften */
	public static final int WIRTSCHAFTLICHESSTUDIUM = 4;

	/** Diese Konstante symbolisiert das Studienfach
	 Biologie */
	public static final int BIOLOGIESTUDIUM = 5;

	/** Diese Konstante symbolisiert das Studienfach
	 Geschichte */
	public static final int GESCHICHTSSTUDIUM = 6;

	/** Diese Konstante symbolisiert das Studienfach
	 Germanistik */
	public static final int GERMANISTIKSTUDIUM = 7;

	/** Diese Konstante symbolisiert das Studienfach
	 Politologie */
	public static final int POLITOLOGIESTUDIUM = 8;

	/** Diese Konstante symbolisiert das Studienfach
	 Physik */
	public static final int PHYSIKSTUDIUM = 9;

    public static final int WEIBLICH = 100;
    public static final int MAENNLICH = 101;

	private static int zaehler = 0;
	private String name;
	private int nummer;
	private int fach;
    private int geburtsjahr;
    private int geschlecht;

    public Student() {
        this(1970);
    }

    public Student(int geburtsjahr) {
        this.geburtsjahr = geburtsjahr;
        zaehler++;
    }

    public Student(String name, int nummer, int fach, int geburtsjahr) {
        this(geburtsjahr);
        this.name = name;
        this.nummer = nummer;
        this.fach = fach;
    }

    public Student(String name, int nummer, int fach, int geburtsjahr, int geschlecht) {
        this(geburtsjahr);
        this.name = name;
        this.nummer = nummer;
        this.fach = fach;
        this.geschlecht = geschlecht;
    }

    public static int getZaehler() {
        return zaehler;
    }

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
		if(!validateNummer()){
			this.nummer = alteNummer;
		}
	}

	public boolean validateNummer() {
		return ((nummer >= 10000) && (nummer <= 99999) && (nummer % 2 != 0));
	}

	public int getFach() {
		return fach;
	}

	public void setFach(int fach) {
		this.fach = fach;
	}

    public int getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(int geschlecht) {
        this.geschlecht = geschlecht;
    }

    @Override
	public String toString() {
        String res = name + " (" + nummer + ")";

        switch(geschlecht){
            case WEIBLICH:
                res += " ist weiblich und";
                break;
            case MAENNLICH:
                res += " ist männlich und ";
                break;
            default:
                res += " hat kein definiertes Geschlecht ";
        }

		switch (fach){
			case MATHEMATIKSTUDIUM:
			    res += " ein Mathematikstudent";
				break;
            case INFORMATIKSTUDIUM:
                res += " ein Informatikstudent";
                break;
            case ARCHITEKTURSTUDIUM:
                res += " angehender Architekt.";
                break;
            case WIRTSCHAFTLICHESSTUDIUM:
                res += " ein Wirtschaftswissenschaftler.";
                break;
            case BIOLOGIESTUDIUM:
                res += " Biologie ist seine Staerke.";
                break;
            case GESCHICHTSSTUDIUM:
                res += " sollte Geschichte nicht mit Geschichten verwechseln.";
                break;
            case GERMANISTIKSTUDIUM:
                res += " wird einmal Germanist gewesen geworden sein.";
                break;
            case POLITOLOGIESTUDIUM:
                res += " kommt bestimmt einmal in den Bundestag.";
                break;
            case PHYSIKSTUDIUM:
                res += " studiert schon relativ lange Physik.";
                break;
            default:
                res += " keine Angabe zum Studium";
		}
		return res;
	}
	
	
}
