package ch.ibw.xml;

/**
 * Created by Nett on 21.12.2016.
 */
public class XmlTest {

    public static void main(String[] args) {

        XmlBaReader handler = new XmlBaReader("c:\\temp\\A2231E0305.xml");
        handler.getElement("");
    }
}
