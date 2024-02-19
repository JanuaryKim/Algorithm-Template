import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dx = {0, 1, 0, -1}; // 상 우 하 좌
    static int[] dy = {1, 0, -1, 0}; // 상 우 하 좌
    public static void main(String[] args) throws IOException {
        StringBuilder result = new StringBuilder();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());

        for(int i = 0; i < t; i++){
            result.append(getResult(bf.readLine()));
            if(i != t-1)
                result.append("\n");
        }
        System.out.println(result);
    }

    private static int getResult(String command){
        int dir = 0; // 0 1 2 3 상 우 하 좌
        int x = 0, y = 0;
        int maxX = 0, minX = 0, maxY = 0, minY = 0;

        for(int j = 0; j < command.length(); j++){

            char com = command.charAt(j);
            if(com == 'L'){
                dir -= 1;
                if(dir < 0)
                    dir = 3;
            }
            else if(com == 'R'){
                dir += 1;
                if(dir > 3)
                    dir = 0;
            }
            else if(com == 'F'){
                x += dx[dir];
                y += dy[dir];
            }
            else if(com == 'B'){
                x -= dx[dir];
                y -= dy[dir];
            }
            if(x > maxX)
                maxX = x;
            if(y > maxY)
                maxY = y;
            if(x < minX)
                minX = x;
            if(y < minY)
                minY = y;
        }

        return (Math.abs(minX) + maxX) * (Math.abs(minY) + maxY);
    }
}
