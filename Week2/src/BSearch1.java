import java.util.*;
import java.lang.*;
import java.io.*;

public class BSearch1 {
	
	public static int bSearch(int[] arr, int x) {
		int start = 0;
		int end = arr.length;
		int index = -1;
		while(start < end) {
			int p = (start+end)/2;
			if(arr[p] == x) {
				index = p;
				end = p;
			}
			else if(arr[p] < x) {
				start = p+1;
			}
			else {
				end = p;
				
			}
		}
		return index;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		String[] NQ = s.readLine().split(" ");
		int N = Integer.parseInt(NQ[0]);
		int Q = Integer.parseInt(NQ[1]);
		String[] arr = s.readLine().split(" ");
		int[] arr2 = new int[N];
		for(int i=0; i<N; i++) {
			arr2[i] = Integer.parseInt(arr[i]);
		}
		for(int i=0; i<Q; i++) {
			int x = Integer.parseInt(s.readLine());
			System.out.println(bSearch(arr2,x));
		}
		
	}
}
