//*********************************************************************************************
// Bus.java                                                Author: Duong Ta  
//
// Solving the Bus problem
//*********************************************************************************************

import java.util.*;
import java.io.*;

public class Bus
{
  public static void main(String[] args) throws IOException
  {
    int k = 0;
    int t = 0;
    Scanner scan = new Scanner(System.in);
    
    //Enter the number of the test cases
    //System.out.print("Enter the number of test cases: ");
    //Scanner scan = new Scanner(new File("test.txt"));
    t = scan.nextInt();
    
    //Enter for each case the number of stop times and print out the initial number of passengers
    for (int i = 1; i <= t; i++)
    {
      //System.out.print("Enter the number of stop times: ");
      k = scan.nextInt();
      System.out.println((int)(Math.pow(2, k) - 1));
    }
  }
}
