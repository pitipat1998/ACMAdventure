import java.util.*;
import java.lang.*;
import java.io.*;

public class AGGRCOW {
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
	
	public static boolean check(int[] len, int ran, int cow) {
		int c = 0;
		int d = 0;
		for(int l : len) {
			d += l;
			if(d >= ran) {
				c++;
				d = 0;
			}
		}
		//System.out.println(c + " .");
		return (c >= cow-1)?true:false;
	}

	public static void main(String[] args) {
		FastReader f = new FastReader();
		int t = f.nextInt();
		for(int k=0; k<t; k++) {
			int N = f.nextInt();
			int C = f.nextInt();
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = f.nextInt();
			}
			Arrays.sort(arr);
			int[] len = new int[N-1];
			for(int i=0; i<N-1; i++) {
				len[i] = arr[i+1]-arr[i];
			}
			
			int hi = arr[N-1];
			int lo = 0;
			int res = 0;
			while(hi>lo) {
				int m = lo+((hi-lo)/2);
				boolean chec = check(len, m, C);
				if(chec) {
					res = m;
					lo = m+1;
				}
				else {
					hi = m;
				}
			}
			System.out.println(res);
		}
	}
}
