import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][] map;
	static int n;
	public static void main(String[] args) throws  IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(bf.readLine());
		map = new char[n][n];
		
		for(int i = 0; i < n; i++) {
			String line = bf.readLine();
			for(int j = 0; j < n; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		boolean headFind = false;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == '*') { //머리 발견
					int hRow = i + 1;
					int hCol = j;
					sb.append((hRow+1) + " " + (hCol+1) + "\n");
					sb.append(getArmLeng(true, hRow, hCol) + " ");
					sb.append(getArmLeng(false, hRow, hCol) + " ");
					int bodyLeng = getBodyLeng(hRow, hCol);
					sb.append(bodyLeng + " ");
					sb.append(getLegLeng(true, hRow + bodyLeng, hCol) + " ");
					sb.append(getLegLeng(false, hRow + bodyLeng, hCol));
					headFind = true;
					break;
				}
				if(headFind) break;
			}			
			if(headFind) break;
		}
		
		System.out.println(sb);
	}
	
	public static int getArmLeng(boolean left, int hRow, int hCol) {
		int leng = 0;
		if(left) {
			for(int i = hCol - 1; i >= 0; i--) {
				if(map[hRow][i] == '*')
					leng++;
				else
					break;
			}
		}
		else {
			
			for(int i = hCol + 1; i < n; i++) {
				if(map[hRow][i] == '*')
					leng++;
				else
					break;
			}
		}
		return leng;
	}

	public static int getLegLeng(boolean left, int bodyEndRow, int bodyEndCol) {
		int leng = 0;
		if(left) {
			for(int i = bodyEndRow + 1; i < n; i++) {
				if(map[i][bodyEndCol-1] == '*')
					leng++;
				else
					break;
			}
		}
		else {
			for(int i = bodyEndRow + 1; i < n; i++) {
				if(map[i][bodyEndCol+1] == '*')
					leng++;
				else
					break;
			}
		}
		
		return leng;
	}
	public static int getBodyLeng(int hRow, int hCol) {
		int leng = 0;
		for(int i = hRow + 1; i < n; i++) {
			if(map[i][hCol] == '*') {
				leng++;
			}
			else
				break;
		}
		return leng;
	}
}

