import java.util.*;
import java.io.*;

public class ExamRedistribution2 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		//Scanner scan = new Scanner(new File("test.txt"));
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		int T = scan.nextInt();
		int max = 0;
		for (int i = 0; i < T; i++) {
			int temp = scan.nextInt();
			a.add(temp);
			if (temp > max) max = temp;
		}
		
		int index = a.indexOf(max);
		int sum = 0;
		String result = (index+1) + " ";
		if (index != a.size() -1) {
			for (int i = index + 1; i < a.size(); i++) {
				sum += a.get(i);
				result += (i+1) + " ";
			}
		}
		for (int i = 0 ; i < index; i++) {
			sum += a.get(i);
			result += (i+1) + " ";
		}
		
		if (sum < max) System.out.println("impossible");
		else System.out.println(result);
	}
}
