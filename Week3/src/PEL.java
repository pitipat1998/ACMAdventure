import java.io.*;
import java.util.*;
import java.lang.*;

public class PEL {
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
	
	static int N, Q;
	static TreeMap<Integer, TreeMap<Integer, Integer>> ts = new TreeMap<>();
	
	private static void removeInterval(int l, int r) {
		ts.get(l).remove(r);
		if(ts.get(l).isEmpty()) ts.remove(l);
	}
	
	private static void addInterval(int l, int r, int k) {
		if(ts.containsKey(r)) {
			ts.get(r).put(l, k);
		}
		else {
			TreeMap<Integer, Integer> t = new TreeMap<>();
			t.put(l, k);
			ts.put(r, t);
			N -= r-l+1;
		}
	}
	
	public static void main(String[] args) {
		FastReader f = new FastReader();
		N = f.nextInt();
		Q = f.nextInt();
		for(int q=0; q<Q; q++) {
			int l = f.nextInt();
			int r = f.nextInt();
			int k = f.nextInt();
			if(ts.isEmpty()) {
				if(k == 1) {
					addInterval(l, r, k);
				}
			}
			else {
				int from = ts.ceilingKey(l);
				int to = ts.floorKey(r);
				for(Map.Entry<Integer, TreeMap<Integer, Integer>> ent : ts.subMap(from, to).entrySet()) {
					for(int ss : ent.getValue().keySet()) {
						removeInterval(ss, ent.getKey());
						if(ss < l) {
							addInterval(ss, l-1, 1);
						}
					}
				}
				if(k==1) addInterval(l, r, k);
			}
		}
	}
	
}
