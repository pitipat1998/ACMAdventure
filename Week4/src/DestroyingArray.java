import java.io.*;
import java.util.*;
import java.lang.*;

public class DestroyingArray {
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
	static int MAXN = 100;
	static int[] sizes = new int[MAXN];
	static int[] nodes = new int[MAXN];
	static long[] sums = new long[MAXN];
	static int[] D = new int[MAXN];
	static Set<Integer> visited = new HashSet<>();
	static long[] result = new long[MAXN]; static int ri = 0;
	
	public static int root(int v) {
		if(nodes[v] != v) nodes[v] = root(nodes[v]);
		return nodes[v];
	}
	
	public static int find(int v) {
		return root(v);
	}
	
	public static void union(int u, int v) {
		int ru = root(u);
		int rv = root(v);
		if(sums[ru] > sums[rv]) {
			nodes[rv] = ru;
			sums[ru] += sums[rv];
		}
		else {
			nodes[ru] = rv;
			sums[rv] += sums[ru];
		}
	}
	
	public static void main(String[] args) {
		FastReader f = new FastReader();
		int N = f.nextInt();
		for(int i=0; i<N; i++) {
			sums[i] = f.nextInt();
			nodes[i] = i;
			sizes[i] = 1;
		}
		for(int i=0; i<N; i++) {
			D[i] = f.nextInt();
		}
		long max = 0;
		result[ri++] = 0;
		for(int i=N-1; i>0; i--) {
			int d = D[i]-1;
			if(visited.isEmpty()) {
				max = sums[d];
			}
			else {
				int rd;
				if(visited.contains(d+1) && find(d) != find(d+1)) {
					union(d, d+1);
					rd = root(d);
					if(sums[rd] > max) max = sums[rd];
				}
				if(visited.contains(d-1) && find(d) != find(d-1)) {
					union(d, d-1);
					rd = root(d);
					if(sums[rd] > max) max = sums[rd];
				}
				if(!visited.contains(d+1) && !visited.contains(d-1)) {
					if(sums[d] > max) max = sums[d];
				}
			}
			visited.add(d);
			result[ri++] = max;
		}
		for(int i=ri-1; i>=0; i--) {
			System.out.println(result[i]);
		}
	}
}