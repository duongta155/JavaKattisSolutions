//*********************************************************************************************
// ACMTestScoring.java                                                Author: Duong Ta  
//
// Solving the ACM Test Scoring problem
//*********************************************************************************************

import java.util.*;
import java.io.*;

public class ACMTestScoring
{
  public static void main(String[] args) throws IOException
  {
    Scanner scan = new Scanner(System.in);
    //Scanner scan = new Scanner(new File("test.txt"));
    
    String s = "";
    int sum = 0, count = 0, n = 0, j = 0;
    while (scan.hasNextLine())
    {
      s += scan.nextLine() + "\n";
      n++;
    }
        
    Scanner textScan = new Scanner(s);
    String[][] han = new String[n-1][3];
    for (int i = 0; i < n-1; i++)
    {
      for (int k = 0; k < 3; k++)
        han[i][k] = textScan.next();
    }
    
    String text = "";
    for (int i = 0; i < n-1; i++)
    {
      if (han[i][j+2].equalsIgnoreCase("right"))
      {
        count++;
        sum += Integer.parseInt(han[i][j]);
        text = han[i][j+1];
        for (int k = 0; k < n-1; k++)
        {
          if ((han[k][j+1].equalsIgnoreCase(text)) && (han[k][j+2].equalsIgnoreCase("wrong")))
            sum += 20;
        }
      }
    }
    System.out.println(count + " " + sum);
  }
}