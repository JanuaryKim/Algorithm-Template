import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //17484
    static int n,m;
    static int[][] map;
    static int result = Integer.MAX_VALUE;
    static int[] dirs = {-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] splNM = bf.readLine().split(" ");
        n = Integer.parseInt(splNM[0]);
        m = Integer.parseInt(splNM[1]);

        map = new int[n][m];
        for(int i = 0; i < n; i++){
            String[] splLine = bf.readLine().split(" ");
            for(int j = 0; j < splLine.length; j++){
                map[i][j] = Integer.parseInt(splLine[j]);
            }
        }
        for(int i = 0; i < m; i++){
            dfs(1, i, -2, map[0][i]);
        }
        System.out.println(result);
    }

    private static void dfs(int depth, int curIdx, int dir, int tempSum){

        if(depth >= n){
            if(tempSum < result){
                result = tempSum;
            }
            return;
        }

        for(int i = 0; i < 3; i++){
            if(dirs[i] == dir) continue; //같은 방향이라면
            int nextIdx = curIdx + dirs[i];
            if(nextIdx < 0 || nextIdx >= m) continue; //범위를 벗어난다면

            dfs(depth+1, nextIdx, dirs[i], tempSum+map[depth][nextIdx]);

        }

    }

}
