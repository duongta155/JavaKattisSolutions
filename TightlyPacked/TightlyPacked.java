import java.io.*;
import java.util.*;

public class TightlyPacked {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		//Scanner scan = new Scanner(new File("test.txt"));
		
		long num = scan.nextLong();
		long sq = (long) Math.ceil(Math.sqrt(num));
		long hMin = (long) Math.ceil(Math.sqrt(num)/Math.sqrt(2));
		long hMax = (long) Math.floor(Math.sqrt(2)*sq);
		long min = (long) (Math.pow(sq, 2) - num);
		
		long sqrt = (long) Math.sqrt(num);
		if (sqrt * sqrt == num) {
			System.out.println("0");
		} else {
			for (long i = hMin; i <= (long)Math.ceil((double)(hMin+hMax)/2); i++) {
				long result = (long)Math.ceil((double)num/i);
				if (i * result >= num && i*result - num < min) {
					min = i*result - num;
				}
			}
			System.out.println(min);
		}
	}
}
