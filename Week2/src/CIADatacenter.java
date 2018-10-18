import java.util.*;
import java.lang.*;
import java.io.*;

public class CIADatacenter {
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
	
	public static boolean check(int n, int d, int c, int e, int t) {
		long sum = 0;
		int q = n/t;
		int r = n%t;
		if(r == 0 || (long)d*(long)q >= c) {
			sum += Math.min((long)c, (long)d*(long)q)*(long)t;
		}
		else {
			sum += (long)d*(long)q*(long)t;
			if((long)d*(long)(q+1) >= c) {
				sum -= (long)d*(long)q*(long)r;
				sum += (long)c*(long)r;
			}
			else {
				sum += (long)d*(long)r;
			}
		}
		return (sum >= e)?true:false;
	}
	
	public static int bSearch(int x, int y, int lo, int hi) {
		int res = lo;
		while(lo <= hi) {
			int m = lo + ((hi-lo)/2);
			long z = (long)x*(long)m;
			if(z >= y) {
				res = m;
				hi = m-1;
			}
			else {
				lo = m+1;
			}
		}
		return res;
	}
	
	public static int bSearch(int lo, int hi, int n, int d, int c, int e) {
		int res = hi;
		while(lo <= hi) {
			int m = lo + ((hi-lo)/2);
			if(check(n, d, c, e, m)) {
				res = m;
				hi = m-1;
			}
			else {
				lo = m+1;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		FastReader f = new FastReader();
		int A = f.nextInt();
		int B = f.nextInt();
		int C = f.nextInt();
		
		if(A >= B) {
			int low = 1;
			int up = C;
			int res = bSearch(B, C, low, up);
			System.out.println(res + " " + res);
		}
		else {
			int low = 1;
			int up = C;
			int resD = bSearch(A, C, low, up);
			low = 1;
			up = resD;
			int resC = bSearch(low, up, resD, A, B, C);
			System.out.println(resD + " " + resC);
		}
		
	}
}