//*********************************************************************************************
// QuadrantSelection.java                                                Author: Duong Ta  
//
// Solving the quadrant selection problem
//*********************************************************************************************

import java.util.*;
import java.io.*;

public class QuadrantSelection
{
  public static void main(String[] args) throws IOException
  {
    Scanner scan = new Scanner(System.in);
    //Scanner scan = new Scanner(new File("test.txt"));
    
    int x = scan.nextInt();
    int y = scan.nextInt();
    if ((x > 0) && (y > 0))
      System.out.println("1");
      else
      if ((x < 0) && (y > 0))
        System.out.println("2");
        else
        if ((x < 0) && (y < 0))
          System.out.println("3");
          else
            System.out.println("4");
  }
}