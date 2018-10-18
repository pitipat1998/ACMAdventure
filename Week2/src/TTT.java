import java.util.*;
import java.lang.*;
import java.io.*;

public class TTT {
	
	static int count = 0;
	static Set<String> uniques = new HashSet<>();
	
	public static boolean isEnded(char[][] board) {
		int count = 0;
		for(int i=0; i<board.length; i++) {
			int xC = 0;
			int oC = 0;
			for(char x : board[i]) {
				if(x == 'x') xC++;
				else if(x == 'o') oC++;
			}
			if(xC == 3 || oC == 3) return true;
			count += xC + oC;
		}
		
		for(int i=0; i<board.length; i++) {
			int xC = 0;
			int oC = 0;
			for(int j=0; j<board.length; j++) {
				char x = board[j][i];
				if(x == 'x') xC++;
				else if(x == 'o') oC++;
			}
			if(xC == 3 || oC == 3) return true;
		}
		
		int xC = 0;
		int oC = 0;
		for(int i=0; i<board.length; i++) {
			char x = board[i][i];
			if(x == 'x') xC++;
			else if(x == 'o') oC++;
		}
		if(xC == 3 || oC == 3) return true;
		
		xC = 0;
		oC = 0;
		for(int i=0; i<board.length; i++) {
			char x = board[board.length-1-i][i];
			if(x == 'x') xC++;
			else if(x == 'o') oC++;
		}
		if(xC == 3 || oC == 3) return true;
		
		return (count == 9)?true:false;
		
	}
	
	public static void next(char[][] board, char player) {
		
		if(isEnded(board)) {
			String a = " ";
			for(char[] row : board) {
				for(char x : row) {
					if(x == 0) a += " ";
					else a += x;
				}
			}
			if(!uniques.contains(a)) uniques.add(a);
			count++;
			return;
		}
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				if(board[i][j] == 0) {
					board[i][j] = player;
					if(player == 'x') next(board, 'o');
					else next(board, 'x');
					board[i][j] = 0;
				}
				//System.out.println('h');
			}
		}
	}
	
	public static void main(String[] args) {
		char[][] board = new char[3][3];
		next(board, 'o');
		System.out.println(uniques.size());
	}
}
