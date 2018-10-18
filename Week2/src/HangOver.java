import java.util.*;
import java.io.*;
import java.lang.*;

public class HangOver {
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
	
	public static void main(String[] args) {
		FastReader f = new FastReader();
		double c;
		while((c = f.nextDouble()) != 0.00) {
			double sum = 0;
			int count = 0;
			double d = 2.0;
			while(sum < c) {
				sum += 1.0/d;
				count++;
				d++;
			}
			System.out.println(count + " card(s)");
		}
	}
	
}
