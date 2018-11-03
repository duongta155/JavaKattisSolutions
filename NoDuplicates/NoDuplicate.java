//*********************************************************************************************
// NoDuplicate.java                                                Author: Duong Ta  
//
// Solving the No Dup problem
//*********************************************************************************************

import java.util.*;
import java.io.*;

public class NoDuplicate
{
  public static void main(String[] args) throws IOException
  {
    //set up and declare variables
    String s = "";
    Scanner scan = new Scanner(System.in);
    //Scanner scan = new Scanner(new File("test.txt"));
    s = scan.nextLine();
    int wc = 0;
    
    //count the words and create an array to hold each word
    for (int i = 0; i < s.length(); i++)
    {
      if (s.charAt(i) == ' ')
         wc++;
    }
    wc++;
    String[] w = new String[wc];
    
    //insert each word into the array
    int j = 0;
    for (int i = 0; i < s.length(); i++)
    {
      if (s.charAt(i) != ' ')
         w[j] += s.charAt(i);
      else
         j++;
    }
    
    //check the repetition
    boolean repeat = false;
    for (int i = 0; i < wc; i++)
    {
      for (int k = 0; k < wc; k++)
      {
        if (i != k)
        {
          if(w[i].equalsIgnoreCase(w[k]))
            repeat = true;
        }
      }
    }
    
    //Print out 
    if (repeat)
      System.out.println("no");
    else
      System.out.println("yes");
  }
}