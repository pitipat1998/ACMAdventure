import java.util.*;
import java.lang.*;
import java.io.*;

public class VanyaandLanterns {
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
	
	public static boolean check(double[] dis, int[] lambs, double d) {
		for(double di : dis) {
			if((d*2) < di) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		FastReader f = new FastReader();
		int L = f.nextInt();
		int len = f.nextInt();
		int[] lambs = new int[L];
		for(int i=0; i<L; i++) {
			lambs[i] = f.nextInt();
		}
		Arrays.sort(lambs);
		double[] dis = new double[L+1];
		for(int i=0; i<L-1; i++) {
			dis[i] = (double)lambs[i+1]-(double)lambs[i]; 
		}
		if(lambs[0] != 0) {
			dis[L-1] = ((double) lambs[0])*2;
		}
		if(lambs[L-1] != len) {
			dis[L] = ((double) len - (double) lambs[L-1])*2;
		}
		Arrays.sort(dis);
		
		int hi = dis.length;
		int lo = 0;
		double r = 0;
		while(hi > lo) {
			int m = lo + ((hi-lo)/2);
			boolean chec = check(dis, lambs, dis[m]/2);
			//System.out.println(dis[m]/2);
			if(chec) {
				r = dis[m]/2;
				hi = m;
			}
			else {
				lo = m+1;
			}
		}
		System.out.println(r);
		
	}
}
