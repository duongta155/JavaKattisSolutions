//*********************************************************************************************
// SecretMessage.java                                                Author: Duong Ta  
//
// Solving the Secret Message problem
//*********************************************************************************************

import java.util.*;
import java.io.*;

public class SecretMessage
{
  public static void main(String[] args) throws IOException
  {
    //Set up and declare variables, arrays
    Scanner scan = new Scanner(System.in);
    int n = 0;
    n = scan.nextInt();
    String[] L = new String[n];
    for (int i = 0; i < n; i++)
      L[i] = scan.next(); 
    int[] M = new int[n];
    
    //Make a table using 2D array, rotate the table and print out the secret message
    for (int i = 0; i < n; i++)
    {
      int j = 0;
      boolean execute = true;
      while (execute)
      {
        if (L[i].length() <= (int)(Math.pow(j, 2)))
        {
          M[i] = (int)(Math.pow(j, 2));
          execute = false;
        }
        j++;
      }
      execute = true;
      j = 0;
      
      int k = (int)(Math.sqrt(M[i]));
      char[][] table = new char[k][k];
      int count = 0;
      for (int row = 0; row < k; row++)
      {
        for (int column = 0; column < k; column++)
        {
          if (count < L[i].length())
          {
            table[row][column] = L[i].charAt(count);
            count++;
          }
          else
            table[row][column] = '*';
        }
      }
      
      int row = k - 1;
      int column = 0;
      char[][] RoTable = new char[k][k];
      for (int r = 0; r < k; r++)
      {
        for (int c = 0; c < k; c++)
        {
          RoTable[r][c] = table[row][column];
          row--;
        }
        column++;
        row = k - 1;
      }
      
      for (int r = 0; r < k; r++)
      {
        for (int c = 0; c < k; c++)
        {
          if (RoTable[r][c] != '*')
            System.out.print(RoTable[r][c]);
        }
      }
      System.out.println();
    }
  }
}