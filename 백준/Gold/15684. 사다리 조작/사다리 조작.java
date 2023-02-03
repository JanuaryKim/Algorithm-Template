import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] line;
    static int n;
    static int m;
    static int h;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken()); //세로선
        m = Integer.parseInt(st.nextToken()); //존재하는 가로 선 갯수
        h = Integer.parseInt(st.nextToken()); //세로 선마다 가로선을 놓을 수 있는 갯수

        line = new int[h+1][n+1]; //편의를 위해 +1씩

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            line[a][b] = 1;
            line[a][b+1] = -1;
        }

        if (m == 0) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i <= 3; i++) {
            if (dfs(0, i)) {
                System.out.println(result);
                return;
            }
        }
        System.out.println(result);
    }

    static boolean dfs(int depth, int maxLine) {

        if (depth == maxLine) {
            if (check()) {
                result = depth;
                return true;
            }
            return false;
        }

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j < n; j++) {

                if(line[i][j-1] == 1 ||line[i][j] != 0 || line[i][j+1] != 0)
                    continue;

                line[i][j] = 1;
                line[i][j+1] = -1;

                if (dfs(depth + 1, maxLine)) {
                    return true;
                }
                line[i][j] = 0;
                line[i][j+1] = 0;
            }
        }
        return false;
    }

    static boolean check() {

        for (int i = 1; i <= n; i++) {
            int index = i;
            int level = 1;
            while (level <= h) {

                if (line[level][index] == 1) {
                    index++;
                } else if (line[level][index] == -1) {
                    index--;
                }

                level++;
            }

            if (index != i) {
                return false;
            }
        }
        return true;
    }
}
