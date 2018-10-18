import java.util.*;
import java.io.*;
import java.lang.*;

public class Parlindrome {
	
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
	
	static int N;
	static String s, rev;
	static int[][] count;
	
	public static String reverse(String s) {
		StringBuilder sb = new StringBuilder();
		for(int i=s.length()-1; i>=0; i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		FastReader f = new FastReader();
		N = f.nextInt();
		s = f.nextLine();
		rev = reverse(s);
		count = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				count[i][j] = (s.charAt(i-1) == rev.charAt(j-1))?1+count[i-1][j-1]:Math.max(count[i-1][j], count[i][j-1]);
			}
		}
		System.out.println(N-count[N][N]);
	}
}
