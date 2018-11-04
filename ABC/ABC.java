//*********************************************************************************************
// ABC.java                                                Author: Duong Ta  
//
// Solving the Secret Message problem
//*********************************************************************************************

import java.util.*;
import java.io.*;

public class ABC
{
  public static void main(String[] args) throws IOException
  {
    Scanner scan = new Scanner(System.in);
    //Scanner scan = new Scanner(new File("test.txt"));
    int[] num = new int[3];
    for (int i = 0; i < 3; i++)
    {
      num[i] = scan.nextInt();
    }
    
    int min = num[0];
    int max = num[0];
    int mid = num[0];
    String l = scan.next();
    char[] c = l.toCharArray();
    
    //find the min and max of three numbers
    for (int i = 0; i < 3; i++)
    {
      if (num[i] < min)
        min = num[i];
    }
    for (int i = 0; i < 3; i++)
    {
      if (num[i] > max)
        max = num[i];
    }
    
    for (int i = 0; i < 3; i++)
    {
      if ((num[i] != min) && (num[i] != max))
        mid = num[i];
    }
    
    //Arrange following the order of ABC
    int[] order = new int[3];
    for (int i = 0; i < 3; i++)
    {
      if (l.charAt(i) == 'A')
        order[i] = min;
      if (l.charAt(i) == 'B')
        order[i] = mid;
      if (l.charAt(i) == 'C')
        order[i] = max;
    }
    
    //Print out
    for (int i = 0; i < 3; i++)
    {
      if (i != 2)
        System.out.print(order[i] + " ");
      else
        System.out.print(order[i]);
    }
  }
}
