import java.util.*;
import java.lang.*;
import java.io.*;

public class TheTriangle {
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
	
	public static void main(String[] args) {
		FastReader f = new FastReader();
		int N = f.nextInt();
		int[][] tri = new int[N][];
		for(int i=1; i<=N; i++) {
			int[] r = new int[i];
			for(int j=0; j<i; j++) {
				r[j] = f.nextInt();
			}
			tri[i-1] = r;
		}
		
		int[][] memo = new int[N][];
		memo[N-1] = tri[N-1];
		for(int i=N-1; i>0; i--) {
			int[] r = tri[i-1];
			int[] p = memo[i];
			int[] t = new int[i];
			for(int j=0; j<i; j++) {
				int x = r[j];
				//System.out.println(x);
				//System.out.println(p[j] + " " + p[j+1]);
				int m = (int) Math.max(x+p[j], x+p[j+1]);
				t[j] = m;
			}
			memo[i-1] = t;
		}
		System.out.println(memo[0][0]);
	}
}
