//*********************************************************************************************
// Autori.java                                                Author: Duong Ta  
//
// Solving the Autori problem
//*********************************************************************************************

import java.util.*;
import java.io.*;

public class Autori
{
  public static void main (String[] args) throws IOException
  {
    Scanner scan = new Scanner(System.in);
    //Scanner scan = new Scanner(new File("test.txt"));
    
    String s = scan.nextLine();
    for (int i = 0; i < s.length(); i++)
    {
      if ((s.charAt(i) >= 'A') && (s.charAt(i) <= 'Z'))   
        System.out.print(s.charAt(i)); 
    }
  }
}
