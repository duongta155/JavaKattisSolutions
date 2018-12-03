import java.util.*;
import java.io.*;

public class Darts {
	public static int point(int x, int y) {
		int p = 0;
		double sum = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		if (Math.abs(sum - 0) < Math.pow(10, -10) && sum <= 200) {
			p = 10;
		} else {
			if (Math.abs(sum % 20 - 0)  < Math.pow(10, -10) && sum <= 200) {
				p = 11 - (int)(sum / 20);
			} else if (sum <= 200) {
				p = 11 - ((int)(sum / 20) + 1);
			} else
				p = 0;
		}
		return p;
	}
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		//Scanner scan = new Scanner(new File("test.txt"));
		
		int T = scan.nextInt();
		for (int i = 0; i < T; i++) {
			int thr = scan.nextInt();
			int totalPoint = 0;
			for (int j = 0; j < thr; j++) {
				int x = scan.nextInt();
				int y = scan.nextInt();
				totalPoint += point(x, y);
			}
			System.out.println(totalPoint);
		}
	}

}
