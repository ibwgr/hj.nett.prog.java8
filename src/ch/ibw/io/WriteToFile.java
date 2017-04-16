package ch.ibw.io;

import java.io.*;

/**
 * Created by Nett on 22.12.2016.
 */
public class WriteToFile {

    public static void main(String[] args) {
        System.out.println(args[0]);

        File file = new File(args[0]);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
     //   Reader keyboardReader = new InputStreamReader(System.in);
        BufferedWriter bufferedWriter = null;
     //   Writer writer = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file,true));
            //writer = new FileWriter(file,true);
            String c;
            while((c = bufferedReader.readLine()) != null){
                bufferedWriter.write(c);
        //        writer.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bufferedWriter != null){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
