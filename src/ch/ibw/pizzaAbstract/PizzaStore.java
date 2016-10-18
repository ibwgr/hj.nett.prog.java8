package ch.ibw.pizzaAbstract;

import ch.ibw.pizzaInterface.IPizza;
import ch.ibw.pizzaInterface.MargheritaInterface;
import ch.ibw.pizzaInterface.NapolitanaInterface;
import ch.ibw.pizzaInterface.QuattroStagioniInterface;

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
        Zutat[] zutatenNapolitana = new Zutat[]{z1,z2,z3,z4,z7};
        Zutat[] zutatenQuattroStagioni = new Zutat[]{z1, z2, z3, z4, z5, z6, z7, z8};

        Pizza margherita = new MargheritaAbstract(zutatenMargherita, "Margherita", MargheritaAbstract.GROSS);
        Pizza margheritaKlein = new MargheritaAbstract(zutatenMargherita,"Margherita", MargheritaAbstract.KLEIN);
        Pizza quattroStagione = new QuattroStagioniAbstract(zutatenQuattroStagioni, "QuattroStagoni");
        Pizza napolitana = new QuattroStagioniAbstract(zutatenNapolitana, "Napolitana");

        Pizza[] pizzas = new Pizza[]{margherita, margheritaKlein,quattroStagione,napolitana};

        System.out.println("Pizzas mit abstracter Class");

        for(Pizza pizza : pizzas){

            String groesse = "";
            if(pizza instanceof MargheritaAbstract){
                groesse = ((MargheritaAbstract) pizza).getGroesse() + " ";
            }
            System.out.println("Eine " + groesse + pizza.getClass().getSimpleName() + " kostet " + pizza.getPreis() + " Fr. und hat " + pizza.getNaehrwert() + " kCal");
        }

        IPizza margheritaI = new MargheritaInterface(zutatenMargherita, IPizza.GROSS);
        IPizza margheritaKleinI = new MargheritaInterface(zutatenMargherita, IPizza.KLEIN);
        IPizza quattroStagioneI = new QuattroStagioniInterface(zutatenQuattroStagioni);
        IPizza napolitanaI = new NapolitanaInterface(zutatenNapolitana);

        IPizza[] pizzasI = new IPizza[]{margheritaI, margheritaKleinI,quattroStagioneI,napolitanaI};

        System.out.println();
        System.out.println("Pizzas mit Interface");

        for(IPizza pizza : pizzasI){

            String groesse = "";
            if(pizza instanceof MargheritaInterface){
                groesse = ((MargheritaInterface) pizza).getGroesse() + " ";
            }
            System.out.println("Eine " + groesse + pizza.getClass().getSimpleName() + " kostet " + pizza.getPreis() + " Fr. und hat " + pizza.getNaehrwert() + " kCal");
        }
    }
}
