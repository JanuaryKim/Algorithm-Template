import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] strSize = bf.readLine().split(" ");

        int col = Integer.parseInt(strSize[1]);
        int row = Integer.parseInt(strSize[0]);

        int[][] map = new int[row][col];
        boolean[][] visited = new boolean[row][col];
        Queue<Integer[]> queue = new LinkedList<>();
        int pictureCtn = 0;
        int maxSize = 0;
        int tempSize = 0;


        for (int i = 0; i < row; i++) {

            String[] line = bf.readLine().split(" ");

            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 1 && visited[i][j] == false) {
                    pictureCtn++;
                    queue.add(new Integer[]{i, j});
                    tempSize = 0;
                    visited[i][j] = true;
                }

                while (!queue.isEmpty()) {

                    tempSize++;
                    Integer[] pos = queue.poll();

                    int top = pos[0] - 1;
                    int right = pos[1] + 1;
                    int down = pos[0] + 1;
                    int left = pos[1] - 1;

                    if (right < col && map[pos[0]][right] == 1 && visited[pos[0]][right] == false) {
                        visited[pos[0]][right] = true;
                        queue.add(new Integer[]{pos[0], right});
                    }

                    if (down < row && map[down][pos[1]] == 1 && visited[down][pos[1]] == false) {
                        visited[down][pos[1]] = true;
                        queue.add(new Integer[]{down, pos[1]});
                    }

                    if (top >= 0 && map[top][pos[1]] == 1 && visited[top][pos[1]] == false) {
                        visited[top][pos[1]] = true;
                        queue.add(new Integer[]{top, pos[1]});
                    }

                    if (left >= 0 && map[pos[0]][left] == 1 && visited[pos[0]][left] == false) {
                        visited[pos[0]][left] = true;
                        queue.add(new Integer[]{pos[0], left});
                    }

                }

                if(tempSize > maxSize)
                    maxSize = tempSize;
            }
        }

        System.out.println(pictureCtn);
        System.out.println(maxSize);
    }
}
