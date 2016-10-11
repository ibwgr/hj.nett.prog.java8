package ch.ibw.kap_9.InterfAbstract;

import ch.ibw.kap_9.InterfAbstract.*;

import java.util.ArrayList;

/**
 * Created by Nett on 11.10.2016.
 */
public class TestAbstract {

    private static void printKind(InterfaceBase kind){
        kind.printName();
    }

    public static void main(String[] args) {

        Kindklasse1 kind1 = new Kindklasse1();
        Kindklasse2 kind2 = new Kindklasse2();
        Kindklasse3 kind3 = new Kindklasse3();
        Kindklasse4 kind4 = new Kindklasse4();

        kind1.print();
        kind2.print();
        kind3.print();
        kind4.print();

        System.out.println();

        AbstractBase[] kindArray = new AbstractBase[]{kind1,kind2,kind3,kind4};
        for(AbstractBase kind : kindArray){
            kind.print();
            kind.sayHallo();
        }

        System.out.println();

        ArrayList<InterfaceBase> itfbaseList = new ArrayList<>();

        itfbaseList.add(kind1);
        itfbaseList.add(kind2);
        itfbaseList.add(kind3);
        itfbaseList.add(kind4);

        for(InterfaceBase ibase : itfbaseList){
            ibase.printName();
        }

        printKind(kind1);

        printKind(new InterfaceBase() {
            @Override
            public void printName() {
                System.out.println("Hallo aus anonymer Klasse");
            }
        });

        printKind(new Kindklasse2());

    }
}
