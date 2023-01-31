import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int max = 0;
    static boolean[][] checked;
    static int[] dx = new int[]{0,0,-1,1}; //상하좌우시 x(column) 변화량
    static int[] dy = new int[]{-1,1,0,0}; //상하좌우시 y(row) 변화량
    static int n, m;
    static int[][][] specialPosition = { //ㅗ,ㅜ,ㅓ,ㅏ 순서대로 중심 좌표 기준으로 각 점마다의 row, col 좌표 변화량
            {{-1,0},{0,-1},{0,1}},
            {{0,-1},{1,0},{0,1}},
            {{0,-1},{-1,0},{1,0}},
            {{0,1},{-1,0},{1,0}}
    }; //ㅏ,ㅓ,ㅗ,ㅜ 도형의 상하좌우의 변화량

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        map = new int[n][m];
        checked = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                checked[i][j] = true;
                dfs(i, j, 0, map[i][j]);
                checked[i][j] = false;
                special(i, j);
            }
        }

        System.out.println(max);
    }

    //ㅓ를 제외한 도형
    static void dfs(int row, int col, int depth, int sum) {

        if (depth == 3) {
            if (sum > max) {
                max = sum;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {

            int nCol = col + dx[i];
            int nRow = row + dy[i];

            if (nCol >= 0 && nRow >= 0 && nCol < m && nRow < n) {
                if (!checked[nRow][nCol]) {
                    checked[nRow][nCol] = true;
                    dfs(nRow, nCol, depth+1, sum+map[nRow][nCol]);
                    checked[nRow][nCol] = false;
                }
            }
        }
    }

    static void special(int row, int col) {

        for (int[][] positions : specialPosition) {
            boolean check = true;

            int sum = map[row][col];
            for (int[] pos : positions) {

                int newRow = row + pos[0];
                int newCol = col + pos[1];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                    sum += map[newRow][newCol];
                }
                else {
                    check = false;
                    break;
                }
            }

            if (check) {
                if(sum > max)
                    max = sum;
            }
        }
    }
}