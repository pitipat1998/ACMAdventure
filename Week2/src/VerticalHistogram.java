import java.util.*;
import java.io.*;
import java.lang.*;

public class VerticalHistogram {
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
		int[] alp = new int['Z'+1];
		int max = 0;
		for(int k=0; k<4; k++) {
			//System.out.println("hi");
			String s = f.nextLine();
			for(int i=0; i<s.length(); i++) {
				char x = s.charAt(i);
				if(x >= 'A' && x<= 'Z') {
					alp[x]++;
					if(alp[x] > max) max = alp[x];
				}
			}
		}
		for(int i=max; i>0; i--) {
			//System.out.println("yo");
			for(int j='A'; j<='Z'; j++) {
				//System.out.println(l);
				if(alp[j] == i) {
					alp[j]--;
					if(j != 'Z') {
						System.out.print("* ");
					}
					else {
						System.out.print("*");
					}
				}
				else {
					if(j != 'Z') {
						System.out.print("  ");
					}
					else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
		
		for(int j='A'; j<='Z'; j++) {
			char l = (char)j;
			if(l != 'Z') {
				System.out.print(l+ " ");
			}
			else {
				System.out.print(l);
			}
		}
	}
	
}
