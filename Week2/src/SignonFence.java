import java.util.*;
import java.lang.*;
import java.io.*;

public class SignonFence {
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
	
	public static int findMin(int[] arr, int lo, int hi) {
		int min = Integer.MAX_VALUE;
		for(int i=lo; i<=hi; i++) {
			if(arr[i] < min) min = arr[i];
		}
		return min;
	}
	
	public static int findMax(int[] arr, int lo, int hi) {
		int max = Integer.MIN_VALUE;
		for(int i=lo; i<=hi; i++) {
			if(arr[i] > max) max = arr[i];
		}
		return max;
	}
	
	public static boolean isFitted (int[] arr, int lo, int hi, int h, int w) {
		int count = 0;
		for(int i=lo; i<=hi; i++) {
			if(h <= arr[i]) {
				count++;
				if(count == w) return true;
			}
			else count = 0;
		}
		return (count == w)?true:false;
	}
	
	public static void main(String[] args) {
		FastReader f = new FastReader();
		int F = f.nextInt();
		int[] arr = new int[F];
		for(int i=0; i<F; i++) {
			arr[i] = f.nextInt();
		}
		int Q = f.nextInt();
		for(int q=0; q<Q; q++) {
			int lo = f.nextInt()-1;
			int hi = f.nextInt()-1;
			int w = f.nextInt();
			int r = findMax(arr, lo, hi);
			int l = findMin(arr, lo, hi);
			int res = l;
			
			while(r >= l) {
				int m = l + ((r-l)/2);
				//System.out.println(m);
				boolean fitted = isFitted(arr, lo, hi, m, w);
				if(fitted) {
					res = m;
					l = m+1;
				}
				else {
					r = m-1;
				}
			}
			System.out.println(res);
		}
		
	}
}
