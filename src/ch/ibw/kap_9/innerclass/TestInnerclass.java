package ch.ibw.kap_9.innerclass;

/**
 * Created by Nett on 11.10.2016.
 */
public class TestInnerclass {

    public static void main(String[] args) {

        InnerClassDemo printer = new InnerClassDemo();
        printer.setName("Nett");
        printer.setVorname("Hans-Jürg");
        System.out.println(printer.toString());
    }
}
