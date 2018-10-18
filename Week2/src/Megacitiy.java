import java.util.*;
import java.lang.*;
import java.io.*;

public class Megacitiy {
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

	public static boolean check(int pop, Pair<Double, Integer>[] D, int ind) {
		for(int i = 0; i<=ind; i++) {
			pop += D[i].right;
		}
		//System.out.println(pop);
		return (pop >= 1000000)?true:false;
	}
	
	public static void main(String[] args) {
		FastReader f = new FastReader();
		int C = f.nextInt();
		int TP = f.nextInt();
		Pair<Double, Integer>[] D = (Pair<Double, Integer>[]) new Pair[C];
		for(int i=0; i<C; i++) {
			D[i] = new Pair(Math.sqrt(Math.pow(f.nextInt(), 2)+Math.pow(f.nextInt(), 2)), f.nextInt());
		}
		Arrays.sort(D, (Pair<Double, Integer> a, Pair<Double, Integer> b) -> Double.compare(a.left, b.left));
		
		int hi = D.length;
		int lo = 0;
		Double r = null;
		while(hi > lo) {
			int m = lo + ((hi-lo)/2);
			//System.out.println(D[m].left);
			boolean chec = check(TP, D, m);
			if(chec) {
				r = D[m].left;
				hi = m;
			}
			else {
				lo = m+1;
			}
		}
		if (r != null)System.out.println(r);
		else System.out.println(-1);
	}
}