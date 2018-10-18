import java.util.*;
import java.lang.*;

public class UVa11498 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int K;
		while((K = s.nextInt()) != 0) {
			int N = s.nextInt(), M=s.nextInt();
			for(int i=0; i<K; i++) {
				int X = s.nextInt();
				int Y = s.nextInt();
				if(X > N && Y > M) System.out.println("NE");
				else if(X < N && Y > M) System.out.println("NO");
				else if(X < N && Y < M) System.out.println("SO");
				else if(X > N && Y < M) System.out.println("SE");
				else System.out.println("divisa");
			}
		}
		s.close();
	}
}
