import java.util.*;
import java.lang.*;
import java.io.*;

public class PostOffice {
	static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
	
	static int V, P;
	static int[] prefDis, vs;
	static int[][] D, minSum;
	static final int INFINITY = 1000000000;
	
	public static int distance(int i, int j) {
		return Math.abs(i-j);
	}
	
	public static int sumInRange(int i, int j, int s, int e) {
		int sum = 0;
		for(int k=s+1; k<e; k++) {
			sum += Math.min(D[i][k], D[j][k]);
		}
		return sum;
	}
	
	public static int place(int i, int P) {
		if(P == 0) {
			int bc = (i!=V-1)?D[i][V-1]:0;
			return bc;
		}
		else {
			int sum = INFINITY;
			for(int j = i+1; j<V; j++) {
				int dp = place(j, P-1) + minSum[i][j];
				sum = Math.min(sum, dp);
			}
			return sum;
		}
	}
	
	public static void main(String[] args) {
		FastReader f = new FastReader();
		V = f.nextInt();
		P = f.nextInt();
		vs = new int[V];
		prefDis = new int[V+1];  prefDis[0] = 0;
		D = new int[V][V];
		minSum = new int[V][V];
		for(int i=0; i<V; i++) {
			vs[i] = f.nextInt();
		}
		for(int i=1; i<=V; i++) {
			prefDis[i] = prefDis[i-1]+distance(vs[0], vs[i-1]);
		}

		for(int i=0; i<V; i++) {
			for(int j=0; j<V; j++) {
				D[i][j] = (i!=j)?distance(vs[i], vs[j]):INFINITY;
			}
		}
		
		for(int i=0; i<V; i++) {
			for(int j=i+2; j<V; j++) {
				minSum[i][j] = sumInRange(i, j, i, j);
			}
		}
		int min = INFINITY;
		for(int i=0; i<V; i++) {
			min = Math.min(min, place(i, P-1)+prefDis[i+1]);
		}
		System.out.println(min);
		
	}
}
