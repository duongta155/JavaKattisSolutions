//**********************************************************************
//  blackfriday.java                            Author: Duong Ta
//
//  Solving the blackfriday problem on Kattis
//**********************************************************************

import java.util.*;
import java.io.*;

public class blackfriday
{
  public static void main(String[] args) throws IOException
  {
    Scanner scan = new Scanner(System.in);   
    //Scanner scan = new Scanner(new File("test.txt"));
     
    int n = scan.nextInt();
    //fill the array with one number randomly from 1 to 6
    int[] array = new int[n];
    for (int i = 0; i < n; i++)
    {
       array[i] = scan.nextInt();
    }
    
    //Create an array called count to count the occurence times of those numbers
    int size = 6;
    int[] count = new int[size];
    for (int i = 0; i < n; i++)
    {
      for (int j = 0; j < size; j++)
      {
        if (array[i] == j + 1)
           count[j]++;
      }
    }
    
    //Find the highest unique number that appears one time and has the highest value
    int i = 0;
    int max = 0;
    while (i < size)
    {
      if ((count[i] == 1) && ((i + 1) > max))
         max = i + 1;
      i++;
    }
    if (max != 0)
    {
      for (int k = 0; k < n; k++)
      {
         if (array[k] == max)
           System.out.println(k + 1);
      }
    }
    else
      System.out.println("None");
  }
}
      