//*********************************************************************************************
// DiceGame.java                                                Author: Duong Ta  
//
// Solving the dice problem
//*********************************************************************************************

import java.util.*;
import java.io.*;

public class DiceGame
{
  public static void main(String[] args) throws IOException
  {
    //Set up Scanner object and create two arrays to hold the numeric values of both players
    Scanner scan = new Scanner(System.in);
    int size = 4;
    int[] e = new int[size];
    int[] g = new int[size];
    
    //Insert each value of each player into the array
    for (int i = 0; i < size; i++)
      g[i] = scan.nextInt();
    for (int i = 0; i < size; i++)
      e[i] = scan.nextInt();
    
    //compute the sum
    int sumG = 0;
    int sumE = 0;
    for (int i = 0; i < size; i++)
      sumG += g[i];
    for (int i = 0; i < size; i++)
      sumE += e[i];
      
    //Compare the sum and print out the winner
    if (sumG == sumE)
      System.out.println("Tie");
      else
        if (sumG > sumE)
          System.out.println("Gunnar");
          else
            System.out.println("Emma");
  }
}
      