import java.util.*;
import java.io.*;

public class HappyPrime {
	public static boolean isPrime(int n) {
		if (n <= 1) return false;
		else if (n <= 3) return true;
		else if (n % 2 == 0 || n % 3 == 0) return false;
		else {
			for (int i = 5; i*i <= n; i+=6) {
				if (n%i == 0 || n%(i+2) == 0)
					return false;
			}
		}
		return true;
	}
	
	public static void print(ArrayList<Integer> num) {
		Iterator<Integer> iter = num.iterator();
		System.out.print("The array is: ");
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
	}
	static ArrayList<Integer> num = new ArrayList<Integer>();
	public static boolean isHappy(int n, int[] arr) {
		if (arr[n] == 1) {
			Iterator<Integer> iter = num.iterator();
			while (iter.hasNext()) {
				int temp = iter.next();
				if (arr[temp] != 1) arr[temp] = 1;
			}
			num.clear();
			return true;
		} else if (arr[n] == 0) {
			num.clear();
			return false;
		} else {
			arr[n] = 0;
			num.add(n);
			int m = 0;
			while (n > 0) {
				m += (int)Math.pow(n%10, 2);
				n /= 10;
			}
			if (m == 1) arr[m] = 1;
			return isHappy(m, arr);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		//Scanner scan = new Scanner(new File("test.txt"));
		
		int T = scan.nextInt();
		int[] a = new int[10001];
		for (int i = 0; i < a.length; i++) {
			a[i] = -1;
		}
		for (int i = 0; i < T; i++) {
			int order = scan.nextInt();
			int num = scan.nextInt();
			if (isPrime(num) && isHappy(num, a)) {
				System.out.println(order + " " + num + " YES");
			} else
				System.out.println(order + " " + num + " NO");
		}
	}
}
