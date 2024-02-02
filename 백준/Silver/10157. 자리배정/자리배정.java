import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int C, R, K;
	static int[][] map;
	static int[] dr= {0, 1, 0, -1}; 
	static int[] dc= {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		map = new int[C][R];
		
		for (int r = 0; r < C; r++) {
			for (int c = 0; c < R; c++) {
				map[r][c] = 0;
			}
		}
		
		int r=0, c=0, dir=0, num=1;
		
		while(num != K) {
			if(K>C*R) {
				System.out.println(0);
				return;
			}
			
			map[r][c] = num;
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			if(nr<0 || nr>= C || nc<0 || nc>=R || map[nr][nc] != 0) {
				dir++;
				if(dir==4)
					dir = 0;
				nr = r + dr[dir];
				nc = c + dc[dir];
			}		
			r = nr;
			c = nc;
			num++;		
		}
		System.out.println((r+1)+" "+(c+1));	
	}
}