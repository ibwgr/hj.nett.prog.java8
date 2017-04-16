package ch.ibw.leitungsnachweis2;

import java.io.*;

/**
 * Created by Hans-Jürg Nett on 24.01.2017.
 */
public class LineCounter {

    public static void main(String[] args) {
        int anzahl = 0;
        File inputFile = new File("myDirectory/songs.txt");
        File staticsFile = new File("myDirectory/statistics.txt");
        FileReader reader = null;
        BufferedReader bufReader = null;
        FileWriter writer = null;

        try {
            reader = new FileReader(inputFile);
            bufReader = new BufferedReader(reader);
            while (bufReader.readLine() != null){
                anzahl++;
            }
            writer = new FileWriter(staticsFile);
            writer.write("Anzahl gelesener Zeilen: " + anzahl);
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(bufReader != null) {
                    bufReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }if(writer!= null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
