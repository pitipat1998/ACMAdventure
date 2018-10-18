import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RoadtoSchool {
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
		int N;
		while((N = f.nextInt()) != 0) {
			int min = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				double v = ((double)f.nextInt()*1000.0)/3600.0;
				int t =	f.nextInt();
				if(t < 0) continue;
				int d = (int) Math.ceil(4500.0/v) + t;
				if(d < min) min = d;
			}
			System.out.println(min);
			
		}
	}
}
