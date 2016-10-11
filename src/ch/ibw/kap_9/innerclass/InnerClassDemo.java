package ch.ibw.kap_9.innerclass;

/**
 * Created by Nett on 11.10.2016.
 */
public class InnerClassDemo {

    private String name;
    private String vorname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    @Override
    public String toString() {
        PrintData data = new PrintData();
        return data.print();
    }

    public class PrintData{

        public String print(){
            return vorname + " " + name;
        }
    }
}
