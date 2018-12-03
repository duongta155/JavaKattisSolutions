import java.util.*;
import java.io.*;

public class LostIsCloseToLose {
    //Edit Distance: Find the mimimum way to convert string s1 to string s2 by inserting, removing or replacing characters
    public static int EditDist(String s1, String s2, int m, int n) {
        int[][] sub = new int[m+1][n+1];
        if (s1.length() != 0) {
        		if (s2.length() != 0) {
        			for (int i = 0;i <= m; i++) {
        	            for (int j = 0; j <= n; j++) {
        	                if (i == 0) sub[i][j] = j;
        	                else if (j == 0) sub[i][j] = i;
        	                else if (s1.charAt(i-1) == s2.charAt(j-1)) {
        	                		sub[i][j] = sub[i-1][j-1];
        	                }
        	                else 
        	                    sub[i][j] = 1 + min(sub[i-1][j], sub[i-1][j-1], sub[i][j-1]);
        	            }
        	        }
        		}
        }
        return sub[m][n];
    }
    
    //Find the minimum
    public static int min(int n1, int n2, int n3) {
        if (n1 <= n2 && n1 <= n3) return n1;
        if (n2 <= n1 && n2 <= n3) return n2;
        return n3;
    }
    
    //Longest Common Subsequence: Find the longest common substring between two strings
    static int max(int a, int b) {
		return (a > b)? a : b;
	}
	
	static int lcsTab(char[] X, char[] Y, int m, int n, ArrayList<String> index) {
		int[][] L = new int[m+1][n+1];
		for (int i = 0 ;i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) L[i][j] = 0;
				else if (X[i-1] == Y[j-1]) {
					L[i][j] = 1 + L[i-1][j-1];
					index.add(i+""+j);
				}
				else L[i][j] = max(L[i-1][j], L[i][j-1]);
			}
		}
		return L[m][n];
	}
	
	//Swap Function
	static boolean swap(ArrayList<String> index, String s1, String s2) {
		boolean[] num = new boolean[s1.length()];
		int res = (int)Math.abs(s1.length() - lcsTab(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length(), index));
		if (res == 1) {
			for (int i = 0;i < num.length; i++) {
				num[i] = false;
			}
			for (int i = 0;i < index.size(); i++) {
				String temp = index.get(i);
				if (temp.charAt(0) == temp.charAt(1)) {
					num[Character.getNumericValue(temp.charAt(0)) - 1] = true;
				}
			}
			
			int first = -1, second = -1;
			for (int i = 0;i < num.length; i++) {
				if (num[i] == false && first == -1) {
					first = i;
				}
				else if (num[i] == false && first != -1) {
					second = i;
				}
			}
			//s1 swap
			char[] ch = s1.toCharArray();
			char te = ch[first];
			ch[first] = ch[second];
			ch[second] = te;
			StringBuilder s11 = new StringBuilder("");
			for (int i = 0; i < ch.length; i++) {
				s11.append(ch[i]);
			}
			if (s11.toString().equalsIgnoreCase(s2)) return true;
		}
		return false;
	}
    
    //Driver Method
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        // Scanner scan = new Scanner(new File("test.txt"));
        
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        ArrayList<String> words = new ArrayList<String>();
        
        while (scan.hasNext()) {
            String temp = scan.next();
            temp = temp.replaceAll("\\\\r", " ");
            temp = temp.replaceAll("\\\\n", " ");
            Scanner scan2 = new Scanner(temp);
            while (scan2.hasNext()) {
                String temp2 = scan2.next();
                if (temp2.equals("***")) {
                    break;
                } else {
                    temp2 = temp2.replaceAll("[^a-zA-Z]", "").toLowerCase();
                    if (!words.contains(temp2)) {
                        ArrayList<String> tempK = new ArrayList<String>();
                        for (int i = 0; i < words.size(); i++) {
                            if ((int)Math.abs(temp2.length()-words.get(i).length()) <= 1) {
                            		ArrayList<String> index = new ArrayList<String>();
                            	    int result = EditDist(temp2, words.get(i), temp2.length(), words.get(i).length());
                                if (result == 1) {
                                    ArrayList<String> a = map.get(words.get(i));
                                    if (a == null) {
                                        a = new ArrayList<String>();
                                        a.add(temp2);
                                        map.put(words.get(i), a);
                                    } else {
                                        a.add(temp2);
                                        map.put(words.get(i), a);
                                    }
                                    tempK.add(words.get(i));
                                }
                                else if (temp2.length() == words.get(i).length() && swap(index, temp2, words.get(i))) {	//Swap one
                                	 	ArrayList<String> a = map.get(words.get(i));
                                     if (a == null) {
                                         a = new ArrayList<String>();
                                        a.add(temp2);
                                         map.put(words.get(i), a);
                                     } else {
                                         a.add(temp2);
                                         map.put(words.get(i), a);
                                     }
                                     tempK.add(words.get(i));
                                }
                            }
                        }
                        words.add(temp2);
                        map.put(temp2, tempK);
                    }
                }
            }
        }
        
        Collections.sort(words);
        String result = "";
        for (int i = 0; i < words.size(); i++) {
            ArrayList<String> res = map.get(words.get(i));
            if (res != null && res.size() != 0) {
                Collections.sort(res);
                result += words.get(i) + ": ";
                for (int j = 0; j < res.size(); j++) {
                    if (j != res.size() - 1)
                        result += res.get(j) + " ";
                    else
                        result += res.get(j);
                }
                result += "\n";
            }
        }
        if (result.length() == 0) System.out.println("***");
        else System.out.println(result);
    }
}