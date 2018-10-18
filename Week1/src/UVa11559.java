import java.util.*;
import java.lang.*;
import java.io.*;

public class UVa11559 {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			int N = s.nextInt();
			int B = s.nextInt();
			int H = s.nextInt();
			int W = s.nextInt();
			int minP = Integer.MAX_VALUE;
			for(int i=0; i<H; i++) {
				int p = s.nextInt();
				for(int j=0; j < W; j++) {
					int a = s.nextInt();
					if(a >= N) {
						int totP = p*N;
						if(totP <= B && totP < minP) minP = totP;
					}
				}
			}
			String result = (minP != Integer.MAX_VALUE)?String.valueOf(minP):"stay home";
			System.out.println(result);
			
		}
		s.close();
	}
	
}
