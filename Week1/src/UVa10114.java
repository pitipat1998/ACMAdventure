import java.util.*;
import java.lang.*;
import java.io.*;
public class UVa10114 {
	static class Pair<T, V>{
		T left;
		V right;
		public Pair(T left, V right) {
			this.left = left;
			this.right = right;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] arr = s.readLine().trim().split(" ");
			int du = Integer.parseInt(arr[0]);
			double down = Double.parseDouble(arr[1]);
			double amount = Double.parseDouble(arr[2]);
			int rec = Integer.parseInt(arr[3]);
			if(du < 0) break;
			Pair<Integer, Double>[] pairs = (Pair<Integer, Double>[]) new Pair[rec];
			for(int i=0; i < rec; i++) {
				String[] dep = s.readLine().trim().split(" ");
				pairs[i] = new Pair<>(Integer.parseInt(dep[0]), Double.parseDouble(dep[1]));
			}
			int curi = 0;
			double currenDep = pairs[0].right;
			double car = amount+down;
			int months = 0;
			car = car - (car*(currenDep));
			curi++;
			for(int i=1; i<=du; i++) {
				System.out.println(amount + " " + car);
				if(curi < rec && i == pairs[curi].left) {
					currenDep = pairs[curi].right;
					curi++;
				}
				amount -= down;
				car = car - (car*(currenDep));
				//System.out.println(amount + " " + car);
				if(amount < car) {
					System.out.println(amount + " " + car);
					months++;
					break;
				}
				months++;
			}
			if(months == 1) {
				System.out.println("1 month");
			}
			else {
				System.out.println(months + " months");
			}
		}
		s.close();
	}
}
