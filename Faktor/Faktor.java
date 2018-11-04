//*********************************************************************************************
// Faktor.java                                                Author: Duong Ta  
//
// Solving the Faktor problem
//*********************************************************************************************

import java.util.*;
import java.io.*;

public class Faktor
{
  public static void main (String[] args) throws IOException
  {
    Scanner scan = new Scanner(System.in);
    //Scanner scan = new Scanner(new File("test.txt"));
    
    int A = scan.nextInt();
    int I = scan.nextInt();
    System.out.println(A*(I-1)+1);
  }
}

