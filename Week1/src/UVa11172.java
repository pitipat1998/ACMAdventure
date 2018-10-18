import java.util.*;

public class UVa11172 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int i=0; i<t; i++) {
			int l = s.nextInt();
			int r = s.nextInt();
			if(l < r) System.out.println("<");
			else if(l > r) System.out.println(">");
			else System.out.println("=");
		}
		s.close();
	}
}
