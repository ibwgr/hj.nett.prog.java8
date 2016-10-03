package ch.ibw.kap_8;

/**
 * Created by Nett on 01.10.2016.
 */
public class Mensch {

    private static int gesamtZahl = 0;

    private int nummer;
    private String vornamen ;
    private String nachname ;
    private int alter;
    private boolean maennlich;

    public Mensch(int nummer, String vornamen, String nachname, int alter, boolean geschlecht) {
        this.nummer = nummer;
        this.vornamen = vornamen;
        this.nachname = nachname;
        this.alter = alter;
        this.maennlich = geschlecht;
        gesamtZahl++;
        nummer = gesamtZahl;
    }

    public int getAlter(){
        return alter;
    }

    public void setAlter(int alter){
        this.alter = alter;
    }

    public boolean isMaennlich() {
        return maennlich;
    }

    public boolean aelterAls(Mensch mensch){
        return this.alter > mensch.alter;
    }

    @Override
    public String toString() {
        String sex = "Weiblich";
        if(maennlich){
            sex = "Männlich";
        }
        return "Vorname:\t" + vornamen + "\nNachname:\t" + nachname + "\nAlter:\t" + alter +"\nGeschlecht:\t" + sex;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mensch mensch = (Mensch) o;

        if (nummer != mensch.nummer) return false;
        if (alter != mensch.alter) return false;
        if (maennlich != mensch.maennlich) return false;
        if (vornamen != null ? !vornamen.equals(mensch.vornamen) : mensch.vornamen != null) return false;
        return nachname != null ? nachname.equals(mensch.nachname) : mensch.nachname == null;

    }

    @Override
    public int hashCode() {
        int result = nummer;
        result = 31 * result + (vornamen != null ? vornamen.hashCode() : 0);
        result = 31 * result + (nachname != null ? nachname.hashCode() : 0);
        result = 31 * result + alter;
        result = 31 * result + (maennlich ? 1 : 0);
        return result;
    }


}
