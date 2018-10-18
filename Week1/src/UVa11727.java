import java.util.*;
import java.lang.*;
import java.io.*;
public class UVa11727 {
	public static void main(String[] args) throws IOException{
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(s.readLine());
			for(int i=0; i<K; i++) {
				String[] arr = s.readLine().split(" ");
				int[] intarr = new int[3];
				for(int j=0; j<3; j++) {
					intarr[j] = Integer.parseInt(arr[j]);
				}
				Arrays.sort(intarr);
				
				System.out.println("Case " + (i+1) +": " + intarr[1]);
			}
		s.close();
	}
}
