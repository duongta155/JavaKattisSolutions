import java.util.*;
import java.io.*;

public class Reseto {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		//Scanner scan = new Scanner(new File("test.txt"));
		
		int N = scan.nextInt(), K = scan.nextInt(), count = 0;
		boolean[] arr = new boolean[N+1];
		for (int i = 0 ; i < arr.length; i++) {arr[i] = true;}
		for (int i = 2;i <= N; i++) {
			if (arr[i] == true && count != K) {
				arr[i] = false; count++;
				if (count == K) {
					System.out.println(i);
					break;
				} else {
					for (int j = 2*i; j <= N; j+=i) {
						if (arr[j] == true) {
							arr[j] = false;
							count++;
						}
						if (count == K) {
							System.out.println(j);
							break;
						}
					}
				}
			}
		}
	}
}
