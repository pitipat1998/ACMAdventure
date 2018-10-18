import java.util.*;
import java.lang.*;
import java.io.*;

public class GettingThrough {
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
	
	static class Triplet{
		int l, c, r;
		public Triplet(int l, int c, int r) {
			this.l = l;
			this.c = c;
			this.r = r;
		}
	}
	
	static double distance(Triplet p1, Triplet p2) {
		double dx = p1.l-p2.l, dy = p1.c-p2.c;
		return Math.sqrt((dx*dx) + (dy*dy))-p1.r-p2.r;
	}
	
	static HashMap<Integer, Integer> map = new HashMap<>();
	static int T, W, S, SI;
	public static void main(String[] args) {
		FastReader f = new FastReader();
		T = f.nextInt();
		for(int t=0; t<T; t++) {
			W = f.nextInt();
			S = f.nextInt();
			SI = 0;
			Triplet[] P = new Triplet[3*S];
			for(int s=0; s<S; s++) {
				P[SI++] = new Triplet(f.nextInt(), f.nextInt(), f.nextInt());
			}
			for(int s=0; s<S; s++) {
				Triplet tri = P[s];
				P[SI++] = new Triplet(0, tri.c, 0);
				P[SI++] = new Triplet(W, tri.c, 0);
			}
			
		}
		
	}
}
