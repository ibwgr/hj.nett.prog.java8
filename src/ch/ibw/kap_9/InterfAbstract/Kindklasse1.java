package ch.ibw.kap_9.InterfAbstract;

import ch.ibw.kap_9.InterfAbstract.AbstractBase;
import ch.ibw.kap_9.InterfAbstract.InterfaceBase;

/**
 * Created by Nett on 11.10.2016.
 */
public class Kindklasse1 extends AbstractBase implements InterfaceBase {

    @Override
    public void print() {
        System.out.println("Kind 1");
    }

    @Override
    public void printName() {
        System.out.println("Kind 1 aus Interface");
    }
}
