import java.util.*;
import java.io.*;
import java.lang.*;

public class DNASorting {
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
	
	static class Pair{
		String s;
		int c;
		public Pair(String s, int c) {
			this.s = s;
			this.c = c;
		}
	}
	
	public static int inversions(String s) {
		int count = 0;
		for(int i=0; i<s.length(); i++) {
			char x = s.charAt(i);
			for(int j=i+1; j<s.length(); j++) {
				char y = s.charAt(j);
				if(x > y) count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		FastReader f = new FastReader();
		int n = f.nextInt(), m = f.nextInt();
		Pair[] P = new Pair[m];
		for(int i=0; i<m; i++) {
			String s = f.nextLine();
			int inv = inversions(s);
			P[i] = new Pair(s, inv);
		}
		Arrays.sort(P, new Comparator<Pair>(){
			public int compare(Pair p1, Pair p2) {
				return p1.c-p2.c;
			}
		});
		for(Pair p : P) {
			System.out.println(p.s);
		}
	}
	
}
