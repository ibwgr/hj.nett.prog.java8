package ch.ibw.kap_9.InterfAbstract;

import ch.ibw.kap_9.InterfAbstract.AbstractBase;
import ch.ibw.kap_9.InterfAbstract.InterfaceBase;

/**
 * Created by Nett on 11.10.2016.
 */
public class Kindklasse2 extends AbstractBase implements InterfaceBase {

    @Override
    public void print() {
        System.out.println("Kind 2");
    }

    @Override
    public void sayHallo() {
        System.out.println("SayHallo von Kind 2");
    }

    @Override
    public void printName() {
        System.out.println("Kind 2 aus Interface");
    }
}
