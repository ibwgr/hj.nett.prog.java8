package ch.ibw.xml;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;

/**
 * Created by Nett on 20.12.2016.
 */
public class XmlBaReader {

    private File xmlFile = null;
    private DocumentBuilderFactory docBuilderFactory = null;
    private DocumentBuilder docBuilder = null;
    private Document doc = null;

    public XmlBaReader(String path) {
        xmlFile = new File(path);
        docBuilderFactory = DocumentBuilderFactory.newInstance();
        parseDocument();
    }

    public Document parseDocument(){
        try {
            docBuilder = docBuilderFactory.newDocumentBuilder();
            doc = docBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }

    public Element getElement(String name){
        Element element = null;

        System.out.println("AktuellerPfad: " + getApplcatonPath());
        writeLogFile();
        NodeList nList = doc.getElementsByTagName("Configuration");
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("CharactName : "
                        + eElement
                        .getElementsByTagName("CharactName")
                        .item(0)
                        .getTextContent());
                System.out.println("CharactValue : "
                        + eElement
                        .getElementsByTagName("CharactValue")
                        .item(0)
                        .getTextContent());
            }
        }

        return  element;
    }

    private void writeLogFile(){
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("C:/temp/log.txt"));
            writer.write(getApplcatonPath());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getApplcatonPath(){
        CodeSource codeSource = XmlTest.class.getProtectionDomain().getCodeSource();
        File rootPath = null;
        try {
            rootPath = new File(codeSource.getLocation().toURI().getPath());
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rootPath.getParentFile().getPath();
    }//end of getApplcatonPath()
}
