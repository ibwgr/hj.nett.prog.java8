package ch.ibw.io;

import java.io.*;
public class PrintWriting {
  public static void main(String[] args) throws IOException {
      BufferedReader in = new BufferedReader(
                                   new InputStreamReader(System.in));
      PrintWriter p  = new PrintWriter(System.out);
      PrintWriter pf = new PrintWriter(System.out,true);
      pf.print(1);
      pf.print('a');
      in.readLine();                // Enter-Taste druecken
      pf.println();
      in.readLine();                // Enter-Taste druecken
      pf.println("pf ist fertig!");
      p.print(3.2);
      p.print(true);
      p.println();
      p.println("p ist fertig!");
      in.readLine();                // Enter-Taste druecken
      p.flush();
  }
}
