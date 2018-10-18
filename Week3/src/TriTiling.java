import java.util.*;
import java.lang.*;
import java.io.*;

public class TriTiling {
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
	
	static int[] arr = new int[30+1];
	
	public static int fill(int top, int mid, int bot, int N, HashMap<String, Integer> u) {
		if(top > N ||  mid > N || bot > N) return 0;
		String s = String.valueOf(N-top)+String.valueOf(N-mid)+String.valueOf(N-bot);
		if(u.containsKey(s)) return u.get(s);
		if(top == N && mid == N && bot == N) {
			return 1;
		}
		int count = 0;
		if(top == mid && mid == bot) {
			count += fill(top+2, mid+2, bot+2, N, u) + (2*fill(top+1, mid+1, bot+2, N, u));
		}
		else {
			count += fill(top+1, mid+1, bot, N, u) + fill(top+2, mid+2, bot+2, N, u);
		}
		u.put(s, count);
		return count;
			
	}
	
	public static void main(String[] args) {
		FastReader f = new FastReader();
		int N;
		while((N = f.nextInt()) != -1) {
			HashMap<String, Integer> u = new HashMap<String, Integer>();
			System.out.println(fill(0, 0, 0, N, u));
		}
	}
}