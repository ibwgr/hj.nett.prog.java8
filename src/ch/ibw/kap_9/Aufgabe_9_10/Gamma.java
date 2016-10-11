package ch.ibw.kap_9.Aufgabe_9_10;

/**
 * Created by Nett on 11.10.2016.
 */
public class Gamma extends Alpha{

    private Beta beta = null;

    public Gamma(int nummerAlpha, int nummerBeta) {
        super(nummerAlpha);
        beta = new Beta(nummerBeta);
    }
}
