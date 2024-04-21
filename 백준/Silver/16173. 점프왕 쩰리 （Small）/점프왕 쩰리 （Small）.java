import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//16173
public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[][] map = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            String[] splLine = bf.readLine().split(" ");
            for(int j = 0; j < splLine.length; j++){
                map[i][j] = Integer.parseInt(splLine[j]);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            int moveCnt = map[pos[0]][pos[1]];
            if(moveCnt == -1){
                System.out.println("HaruHaru");
                return;
            }

            //아래로 이동
            int nextRow = pos[0] + moveCnt;
            int nextCol = pos[1];
            if(nextRow < n && !visited[nextRow][nextCol]) {
                queue.add(new int[]{nextRow, nextCol});
                visited[nextRow][nextCol]= true;
            }
            //우로 이동
            nextRow = pos[0];
            nextCol = pos[1] + moveCnt;
            if(nextCol < n && !visited[nextRow][nextCol]){
                queue.add(new int[]{nextRow, nextCol});
                visited[nextRow][nextCol]= true;
            }
        }
        System.out.println("Hing");
    }

}
