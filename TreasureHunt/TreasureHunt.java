import java.util.*;
import java.io.*;
public class TreasureHunt {
	private static char[][] graph;
	private static int r = 0, c = 0, count = 0;
	
	//constructor
	TreasureHunt(char[][] matrix) {
		graph = new char[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				graph[i][j] = matrix[i][j];
			}
		}
	}
	//Recursion Solve method
	public static void TH(int row, int column, boolean[][] check) {
		String result = row + "" + column;
		if ((row > r-1) || (column > c-1) || (row < 0) || (column < 0))
			System.out.println("Out");
		else if (check[row][column]) {
			System.out.println("Lost");
		}
		else if (graph[row][column] == 'T')
			System.out.println(count);
		else {
			if (graph[row][column] == 'E') {
				check[row][column] = true;
				count++;
				TH(row, column + 1, check);
			}
			else if (graph[row][column] == 'W') {
				check[row][column] = true;
				count++;
				TH(row, column - 1, check);
			}
			else if (graph[row][column] == 'S') {
				check[row][column] = true;
				count++;
				TH(row + 1, column, check);
			}
			else if (graph[row][column] == 'N') {
				check[row][column] = true;
				count++;
				TH(row - 1, column, check);
			}
		}

	}
	
	//Driver method
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		//Scanner scan = new Scanner(new File("test.txt"));
		
		r = scan.nextInt(); c = scan.nextInt();
		scan.nextLine();
		char[][] matrix = new char[r][c];
		boolean[][] check = new boolean[r][c];
		String s = "";
		for (int i = 0; i < r; i++) {
			s = scan.nextLine();
			for (int j = 0; j < c; j++) {
				matrix[i][j] = s.charAt(j);
				check[i][j] = false;
			}
		}
		TreasureHunt th = new TreasureHunt(matrix);
		th.TH(0, 0, check);
	}
}
