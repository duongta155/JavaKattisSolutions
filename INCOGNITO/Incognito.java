import java.io.*;
import java.util.*;

public class Incognito {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		//Scanner scan = new Scanner(new File("test.txt"));
		
		int T = scan.nextInt();
		for (int i = 0; i < T; i++) {
			int n = scan.nextInt();
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			ArrayList<String> cate = new ArrayList<String>();
			for (int j = 0;j < n;j++) {
				scan.next();
				String s = scan.next();
				if (map.containsKey(s)) {
					map.put(s, map.get(s) + 1);
				} else {
					cate.add(s);
					map.put(s, 2);
				}
			}
			int sum = 1;
			for (int j = 0;j < cate.size(); j++) {
				sum *= map.get(cate.get(j));
			}
			System.out.println(sum-1);
		}
		
	}
}
