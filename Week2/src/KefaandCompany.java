import java.util.*;
import java.lang.*;
import java.io.*;

public class KefaandCompany {
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
	
	static class Pair<K, V> {
		K left;
		V right;
		public Pair(K left, V right) {
			this.left = left;
			this.right = right;
		}
	}

	
	public static void main(String[] args) {
		FastReader f = new FastReader();
		int F = f.nextInt();
		int dif = f.nextInt();
		Pair<Long, Long>[] P = (Pair<Long, Long>[]) new Pair[F];
		for(int i=0; i<F; i++) {
			P[i] = new Pair((long) f.nextInt(), (long) f.nextInt());
		}
		Arrays.sort(P, (Pair<Long, Long> a, Pair<Long, Long> b) -> Long.compare(a.left, b.left));
		long max = Long.MIN_VALUE;
		long sum = 0;
		int l = 0;
		int r = 0;
		while(l < P.length && r < P.length) {
			if(P[r].left - P[l].left < dif) {
				sum += P[r].right;
				r++;
			}
			else {
				sum -= P[l].right;
				l++;
			}
			if(sum > max) max = sum;
		}
		System.out.println(max);
	}
}