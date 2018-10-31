import java.util.*;
import java.io.*;

public class Chess {
	public static boolean findRoute(int colS, int rowS, int colE, int rowE, int[][] chess) {
		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess[i].length; j++) {
				if (Math.abs(colE - j) == Math.abs(rowE - i) && Math.abs(colS - j) == Math.abs(rowS - i)) {
					chess[i][j] = 9;
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		//Scanner scan = new Scanner(new File("test.txt"));
		
		int T = scan.nextInt();
		for (int i = 0; i < T; i++) {
			char colS = scan.next().charAt(0);
			int cS = colS - 'A';
			int rowS = scan.nextInt();
			int rS = 8 - rowS;
			char colE = scan.next().charAt(0);
			int cE = colE - 'A';
			int rowE = scan.nextInt();
			int rE = 8 - rowE;
			int[][] chess = new int[8][8];
			chess[rS][cS] = 9;
			chess[rE][cE] = 9;
			
			//check cases
			if (colS == colE && rowS == rowE) System.out.println("0 " + colS + " " + rowS);
			else if (Math.abs(colE - colS) == Math.abs(rowE - rowS)) System.out.println("1 " + colS + " " + rowS + " " + colE + " "+ rowE);
			else if (findRoute(cS, rS, cE, rE, chess)) {
				for (int k = 0; k < chess.length; k++) {
					for (int j = 0; j < chess[k].length; j++) {
						if (chess[k][j] == 9) {
							if ((k != rS) && (k != rE) && (j != cS) && (j != cE))
								System.out.println("2 " + colS + " " + rowS + " " + (char)(j + 'A') + " " + (8 - k) + " " + colE + " " + rowE);
						}
					}
				}
			}
			else System.out.println("Impossible");
		}
	}
}
