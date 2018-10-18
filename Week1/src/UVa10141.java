import java.util.*;
import java.lang.*;
import java.io.*;
public class UVa10141 {
	public static void main(String[] args) throws IOException {
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		String[] A = s.readLine().split(" ");
		int N = Integer.parseInt(A[0]);
		int P = Integer.parseInt(A[1]);
		int i = 0;
		while(true) {
			i++;
			if(N == 0 && P == 0) break;
			String highest = null;
			double comphighest = 0.0;
			double winprice = Double.MAX_VALUE;
			for(int j=0; j<N; j++) { s.readLine(); }
			for(int k=0; k<P; k++) {
				String name = s.readLine();
				String[] B = s.readLine().split(" ");
				double price = Double.parseDouble(B[0]);
				int r = Integer.parseInt(B[1]);
				for(int t=0; t<r; t++) { s.readLine(); }
				double compliance = (double)r/(double)N;
				if(compliance > comphighest) {
					highest = name;
					comphighest = compliance;
					winprice = price;
				}
				else if(compliance == comphighest) {
					if(price < winprice) {
						highest = name;
						comphighest = compliance;
						winprice = price;
					}
				}
			}
			A = s.readLine().split(" ");
			N = Integer.parseInt(A[0]);
			P = Integer.parseInt(A[1]);
			if(N != 0 && P != 0) {
				System.out.println("RFP #"+i);
				System.out.println(highest);
				System.out.println();
			}
			else {
				System.out.println("RFP #"+i);
				System.out.println(highest);
			}
			
			
		}
	}
}
