package ch.ibw.pizzastore;

/**
 * Created by Nett on 15.10.2016.
 */
public class PizzaStore {

    public static void main(String[] args) {

        Zutat z1 = new Zutat(Zutaten.TEIG, 200);
        Zutat z2 = new Zutat(Zutaten.MOZZARELLA, 60);
        Zutat z3 = new Zutat(Zutaten.TOMATENSAUCE, 100);
        Zutat z4 = new Zutat(Zutaten.OLIVENOEL, 6);
        Zutat z5 = new Zutat(Zutaten.SCHINKEN, 30);
        Zutat z6 = new Zutat(Zutaten.PILZ, 15);
        Zutat z7 = new Zutat(Zutaten.PEPERONI, 25);
        Zutat z8 = new Zutat(Zutaten.ARTISCHOCKEN, 80);

        Zutat[] zutatenMargherita = new Zutat[]{z1,z2,z3,z4};

        PizzaMargherita margherita = new PizzaMargherita(zutatenMargherita, PizzaMargherita.GROSS);

        System.out.println("Eine " + margherita.getGroesse() + " PizzaMargherita kostet " + margherita.getPreis() + " Fr. und hat " + margherita.getNaehrwert() + " kCal");

        PizzaMargherita margheritaKlein = new PizzaMargherita(zutatenMargherita, PizzaMargherita.KLEIN);

        System.out.println("Eine " + margheritaKlein.getGroesse() + " PizzaMargherita kostet " + margheritaKlein.getPreis() + " Fr. und hat " + margheritaKlein.getNaehrwert() + " kCal");


    }
}
