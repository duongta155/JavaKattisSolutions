import java.io.*;
import java.util.*;

public class Simplicity {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		//Scanner scan = new Scanner(new File("test.txt"));
		
		String s = scan.next();
		HashSet<Character> ch = new HashSet<Character>();
		int[] count = new int[26];
		for (int i = 0;i < count.length; i++) {
			count[i] = 0;
		}
		for (int i = 0;i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
			ch.add(s.charAt(i));
		}
		if (ch.size() <= 2) {
			System.out.println("0");
		} else {
			ArrayList<Integer> c = new ArrayList<Integer>();
			for (int i = 0;i < count.length; i++) {
				if (count[i] != 0)
					c.add(count[i]);
			}
			Collections.sort(c);
			int numTimes = 1, sum = 0, index = 0;
			while (numTimes <= ch.size() - 2) {
				sum += c.get(index);
				index++;
				numTimes++;
			}
			System.out.println(sum);
		}
	}
}
