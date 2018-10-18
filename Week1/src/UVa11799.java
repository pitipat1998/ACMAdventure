import java.util.*;
import java.lang.*;
import java.io.*;
public class UVa11799 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for(int j=0; j<T; j++) {
			int N = s.nextInt();
			int maxV = Integer.MIN_VALUE;
			for(int i=0; i<N; i++) {
				int v = s.nextInt();
				if(v > maxV) maxV = v;
			}
			System.out.println("Case " + (j+1) + ": " + maxV);
		}
		s.close();
	}
}
