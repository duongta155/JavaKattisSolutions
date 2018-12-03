import java.io.*;
import java.util.*;

public class TextureAnalysis {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		//Scanner scan = new Scanner(new File("test.txt"));
		
		int num = 1;
		while (scan.hasNextLine()) {
			String s = scan.nextLine();
			if (s.equalsIgnoreCase("END")) break;
			else if (s.length() == 1) {
				System.out.println(num + " EVEN");
				num++;
			}
			else {
				int countStar = 0;
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) == '*') {
						countStar++;
					}
				}
				int count = (s.length() - countStar) / (countStar - 1);
				int prevIndex = 0;
				boolean cont = true;
				if (countStar == 2) {
					System.out.println(num + " EVEN");
				} else {
					for (int i = 0;i < s.length(); i++) {
						if (i != 0 && s.charAt(i) == '*') {
							if (i - 1 - prevIndex != count) {
								System.out.println(num + " NOT EVEN");
								cont = false;
								break;
							}
							prevIndex = i;
						}
					}
					if (cont == true) System.out.println(num + " EVEN");
				}
				num++;
			}
		}
	}
}
