import java.util.*;
import java.lang.*;
import java.io.*;

public class FillTiles {
	
	static int w = 10;
	static int count = 0;
	
	public static void fill(int top, int bot) {
		//System.out.println(top + " " + bot);
		if(top > w && bot > w) return;
		if(top == bot && top == w) {
			count++;
			return;
		}
		else if(top == bot) {
			fill(top+1, bot+1);
			fill(top+2, bot+2);
			fill(top+2, bot+2);
//			fill(top+2, bot+1);
//			fill(top+1, bot+2);
		}
//		else if(top > bot){
//			fill(top+1, bot+2);
//			fill(top, bot+2);
//		}
//		else if(bot > top) {
//			fill(top+2, bot+1);
//			fill(top+2, bot);
//		}
		
	}
	
	public static void main(String[] args) {
		int top = 0;
		int bot = 0;
		fill(top, bot);
		System.out.println(count);
	}
}
