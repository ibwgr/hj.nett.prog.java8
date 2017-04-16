package ch.ibw.io;

import java.util.Scanner;
import java.io.*;
public class Eingaben {
  public static void main (String[] args) {  
    Scanner in = new Scanner(System.in);
    int     i;
    double  d;
    boolean b;
    System.out.print("i = "); 
    i = in.nextInt();
    System.out.print("d = "); 
    d = in.nextDouble();
    System.out.print("b = "); 
    b = in.nextBoolean();
    System.out.println("i = " + i);
    System.out.println("d = " + d);
    System.out.println("b = " + b);
  }
}

