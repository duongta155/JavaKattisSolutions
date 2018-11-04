//*********************************************************************************************
// AboveAverage.java                                                Author: Duong Ta  
//
// Solving the Above Average problem
//*********************************************************************************************

import java.util.*;
import java.io.*;
import java.text.*;

public class AboveAverage
{
  public static void main(String[] args) throws IOException
  {
    Scanner scan = new Scanner(System.in);
    //Scanner scan = new Scanner(new File("test.txt"));
    DecimalFormat fmt = new DecimalFormat("0.000");
    int C = scan.nextInt();
    
    //Read input and deal with the number of test cases
    for (int i = 0 ; i < C; i++)
    {
      int N = scan.nextInt();
      int sum = 0;
      int[] grade = new int[N];
      for (int j = 0; j < N; j++)
      {
        grade[j] = scan.nextInt();
        sum += grade[j];
      }
      int average = sum / N;
      int count = 0;
      for (int j = 0; j < N; j++)
      {
        if (grade[j] > average)
          count++;
      }
      System.out.println(fmt.format((double)(count*100)/N) + "%");
    }
  }
}
