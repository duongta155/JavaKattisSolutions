//*********************************************************************************************
// DaylightSaving.java                                                Author: Duong Ta  
//
// Solving the Secret Message problem
//*********************************************************************************************

import java.util.*;
import java.io.*;

public class DaylightSaving
{
  public static void main(String[] args) throws IOException
  {
    Scanner scan = new Scanner(System.in);
    //Scanner scan = new Scanner(new File("test.txt"));
    
    int n = scan.nextInt();
    for (int i = 0; i < n; i++)
    {
      String s = scan.next();
      int D = scan.nextInt();
      int H = scan.nextInt();
      int M = scan.nextInt();
      
      if (s.equals("F"))
      {
        while (D - 60 > 0)
        {
          if (H == 23)
            H = 0;
          else
            H++;
          D -= 60;
        }
        if (M + D > 60)
        {
          if (H == 23)
          {
            H = 0;
            M -= (60 - D);
          }
          else
          {
            H++;
            M -= (60 - D);
          }
        }
        else
        {
          if (M + D == 60)
          {
            if (H == 23)
            {
              H = 0;
              M = 0;
            }
            else
            {
              H++;
              M = 0;
            }
          }
          else
            M += D;
        }
      }
      else
      {
        while (D - 60 > 0)
        {
          if (H == 0)
            H = 23;
          else
            H--;
          D -= 60;
        }
        if (M - D < 0)
        {
          if (H == 0)
          {
            H = 23;
            M += (60 - D);
          }
          else
          {
            H--;
            M += (60 - D);
          }
        }
        else
          M -= D;
      }
      System.out.println(H + " " + M);
    }
  }
}
    
          