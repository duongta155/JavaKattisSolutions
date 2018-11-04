//*********************************************************************************************
// TakeTwoStones.java                                                Author: Duong Ta  
//
// Solving the take two stones problem
//*********************************************************************************************

import java.util.*;
import java.io.*;

public class TakeTwoStones
{
  public static void main(String[] args) throws IOException
  {
    Scanner scan = new Scanner(System.in);
    //Scanner scan = new Scanner(new File("test.txt"));
    
    int x = scan.nextInt();
    if ((x%2) == 0)
      System.out.println("Bob");
      else
        System.out.println("Alice");
  }
}
