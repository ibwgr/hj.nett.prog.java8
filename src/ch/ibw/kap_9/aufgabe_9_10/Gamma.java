package ch.ibw.kap_9.aufgabe_9_10;

/**
 * Created by Nett on 11.10.2016.
 */
public class Gamma extends Alpha{

    private Beta beta = new Beta(8);;

    public Gamma(int nummerAlpha, int nummerBeta) {
        super(nummerAlpha);
        System.out.println("Konstruktor Gamma nach Super-Konstrukator");
      //  beta = new Beta(nummerBeta);
    }
}
