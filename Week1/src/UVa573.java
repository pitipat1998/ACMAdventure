import java.util.*;
import java.lang.*;
import java.io.*;
public class UVa573 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			int H = s.nextInt();
			if(H == 0) break;
			int U = s.nextInt();
			int D = s.nextInt();
			double F = U * s.nextInt()/100.0;
			double pos = 0;
			double dis = U;
			int day = 0;
			while(pos <= H && pos >= 0) {
				day++;
				pos += dis;
				if(pos > H) break;
				pos -= D;
				if(pos < 0) break;
				if(dis-F >= 0) dis -= F;
			}
			if(pos > H) System.out.println("success on day " + day);
			else if (pos < 0) System.out.println("failure on day " + day);
		}
		s.close();
	}
}
