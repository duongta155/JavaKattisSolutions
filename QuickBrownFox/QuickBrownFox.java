import java.io.*;
import java.util.*;

public class QuickBrownFox {
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		//Scanner scan = new Scanner(new File("test.txt"));
		
		int n = scan.nextInt();
		scan.nextLine();
		for (int t = 0; t < n; t++) {
			String s = "";
			boolean[] mark = new boolean[26];
			if (scan.hasNext()) {
				s = scan.nextLine().toLowerCase().trim();
				for (int i = 0 ; i < s.length(); i++) {
					char c = s.charAt(i);
					if ((c >= 'a') && (c <= 'z')) {
						if (mark[c-'a'] != true)
							mark[c-'a'] = true;
					}
				}
			}
			String result = "missing ";
			boolean keep = true;
			for (int j = 0; j < mark.length; j++) {
				if (mark[j] == false) {
					keep = false;
					result += (char)(j + 97) + "";
				}
			}
			if (keep)
				System.out.println("pangram");
			else
				System.out.println(result);
		}
	}

}
