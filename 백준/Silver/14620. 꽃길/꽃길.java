import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] map;
    static int minCost = Integer.MAX_VALUE;
    static boolean[][] visited;
    static Point[] seedCenter = new Point[3];
    static int n;
    static int[] cy = {-1, 1, 0, 0}; //상, 하, 좌, 우
    static int[] cx = {0,0, -1, 1}; //상, 하, 좌, 우
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] splLine = bf.readLine().split(" ");
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(splLine[j]);
            }
        }

        dfs(0,  0);

        System.out.println(minCost);

    }

    private static void dfs(int seedIdx, int curCost) {


        if(seedIdx >= 3){
            if(curCost < minCost){
                minCost = curCost;
            }
            return;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(checkPossiblePlant(i,j)){ //심기 가능한가?

                    int cost = plant(true, seedIdx,i, j);
                    dfs(seedIdx+1, curCost + cost);
                    plant(false, seedIdx, i, j);
                    //심는다. (visited 체크), 중심좌표 저장
                    //재귀
                    //뽑는다. (visited 체크 해제), 중신좌표 지우기
                }

            }
        }
    }

    private static boolean checkPossiblePlant(int y, int x) {

//        System.out.println("체킹 : "  + y + " , " + x);
        boolean result = true;

        if(y >= n || x >= n || y < 0 || x < 0|| visited[y][x])
        {

            return false;
        }

        for(int i = 0; i < 4; i++){
            int aroundY = y + cy[i];
            int aroundX = x + cx[i];

            if(aroundY >= n || aroundX >= n || aroundY < 0 || aroundX < 0 || visited[aroundY][aroundX]){
                return false;
            }
        }

        return result;
    }

    private static int plant(boolean plant, int seedIdx, int y, int x) {

//        System.out.println(seedIdx + " 번째 "+ y + " , " + x);
        int cost = 0;

        visited[y][x] = plant;
        cost += map[y][x];
        for(int i = 0; i < 4; i++){
            int aroundY = y + cy[i];
            int aroundX = x + cx[i];

            visited[aroundY][aroundX] = plant;
            cost += map[aroundY][aroundX];
        }
        seedCenter[seedIdx] = new Point(y,x);
        return cost;
    }


    private static class Point{
        int y, x;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
