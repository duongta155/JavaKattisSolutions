import java.util.*;
import java.io.*;

public class MilestoneCounter {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		//Scanner scan = new Scanner(new File("test.txt"));
		
		int StoneSaw = scan.nextInt(), StoneTot = scan.nextInt();
		ArrayList<Long> timeSpace = new ArrayList<Long>();
		long prev = scan.nextLong(), curr = scan.nextLong(); 
		for (int i = 2; i < StoneSaw; i++) {
			timeSpace.add(curr-prev);
			prev = curr;
			curr = scan.nextLong();
		}
		timeSpace.add(curr-prev);
		
//		//Print the time space
//		for (int i = 0;i < timeSpace.size(); i++) {
//			System.out.print(timeSpace.get(i) + " ");
//		}
		
		ArrayList<Long> dist = new ArrayList<Long>();
		long dist1 = scan.nextLong(), dist2 = scan.nextLong();
		for (int i = 2;i < StoneTot; i++) {
			dist.add(dist2 - dist1);
			dist1 = dist2;
			dist2 = scan.nextLong();
		}
		dist.add(dist2 - dist1);
		
//		//print the distance
//		System.out.println();
//		for (int i = 0;i < dist.size(); i++) {
//			System.out.print(dist.get(i) + " ");
//		}
//		System.out.println();
//		System.out.println("The result is: ");
		
		if (StoneSaw == 2) {
			ArrayList<Long> a = new ArrayList<Long>();
			for (int i = 0; i < dist.size(); i++) {
				if (!a.contains(dist.get(i))) a.add(dist.get(i));
			}
			Collections.sort(a);
			System.out.println(a.size());
			for (int i = 0;i < a.size(); i++) {
				if (i != a.size()-1)
					System.out.print(a.get(i) + " ");
				else
					System.out.print(a.get(i));
			}
		} else {
			ArrayList<String> a = new ArrayList<String>();
			boolean check = true;
			String s = "";
			for (int i = timeSpace.size() - 1; i < dist.size(); i++) {
				long v = dist.get(i) / timeSpace.get(timeSpace.size() - 1);
				for (int j = 0; j < timeSpace.size(); j++) {
					long res = v * timeSpace.get(j);
					if (res != dist.get(i-timeSpace.size()+1 + j)) {
						check = false;
						break;
					}
					s += dist.get(i-timeSpace.size()+1 + j) + " ";
				}
				if (check) {
					if (!a.contains(s)) {
						a.add(s);
					}
				}
				s = "";
				check = true;
			}
			ArrayList<Long> distance = new ArrayList<Long>();
			for (int i = 0; i < a.size(); i++) {
				String[] temp = a.get(i).split(" ");
				long tempNum = Long.parseLong(temp[0]);
				if (!distance.contains(tempNum))
					distance.add(tempNum);
			}
			Collections.sort(distance);
			System.out.println(a.size());
			for (int i = 0; i < distance.size(); i++) {
				if (i != distance.size()-1)
					System.out.print(distance.get(i) + " ");
				else
					System.out.print(distance.get(i));
			}
		}
	}
}
