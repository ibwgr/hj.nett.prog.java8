package ch.ibw.PizzaDb;

import ch.ibw.pizzaAbstract.Zutat;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nett on 07.11.2016.
 */
public class DbConnectionTest {

    @Test
    public void selectRezeptDetails_CheckIfEqualIngredients_ReturnsTrue(){

        Zutat z1 = new Zutat("Teig", 200, 333, 3.0);
        Zutat z2 = new Zutat("Mozzarella", 60, 244, 2.5);
        Zutat z3 = new Zutat("Tomatensauce", 100, 20, 1.2);
        Zutat z4 = new Zutat("Olivenoel", 6, 819, 1.0);
        Zutat z5 = new Zutat("Schinken", 30, 145, 1.5);
        Zutat z6 = new Zutat("Pilz", 15, 60, 1.2);
        Zutat z7 = new Zutat("Peperoni", 25, 40, 0.8);
        Zutat z8 = new Zutat("Artischocken", 80, 47, 0.9);

        Zutat[] zutatenMargherita = new Zutat[]{z1,z2,z3,z4};

        DbConnection fakeDb = new FakeDbConnection("Fake",zutatenMargherita);

        Zutat[] zutaten = fakeDb.selectRezeptDetails("Margherita");

        boolean gleich = vergleichen(zutatenMargherita, zutaten);
        Assert.assertTrue(gleich);

    }

    @Test
    public void getAllProducts() throws Exception {

    }

    @Test
    public void getRezepte() throws Exception {

    }

    @Test
    public void insertCommand() throws Exception {

    }

    private boolean vergleichen(Zutat[] expected, Zutat[] actual){

        for(int i = 0; i > expected.length; i++){
            if(!expected[i].equals(actual[i])){
                return false;
            }
        }
        return true;
    }
}