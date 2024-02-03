import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean[][] map;
    static int r,c;
    static int[] dr = {-1,1,0,0}; //상하좌우
    static int[] dc = {0,0,-1,1}; //상하좌우
    static int curRbR, curRbC;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] splInput = bf.readLine().split(" ");
        r = Integer.parseInt(splInput[0]);
        c = Integer.parseInt(splInput[1]);
        map = new boolean[r][c];
        int k = Integer.parseInt(bf.readLine());
        for(int i = 0; i < k; i++){
            String[] strPt = bf.readLine().split(" ");
            map[Integer.parseInt(strPt[0])][Integer.parseInt(strPt[1])] = true;
        }

        String[] splRb = bf.readLine().split(" ");
        curRbR = Integer.parseInt(splRb[0]);
        curRbC = Integer.parseInt(splRb[1]);
        map[curRbR][curRbC] = true; //시작위치 방문 위치로 체크
        int[] dirs = Arrays.stream(bf.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray(); // 1상 2하 3좌 4우
        int curDirIdx = 0;

        int dirCtn = 0; //방향 전환 횟수
        while(dirCtn < 4){
            if(!move(dirs[curDirIdx], curRbR, curRbC)){ //이동 안되면
                dirCtn++; //방향 전환 횟수 증가
            }
            else{ //이동 됬으면
                dirCtn = 0;
            }
            curDirIdx++;
            if(curDirIdx == 4){
                curDirIdx = 0;
            }
        }
        System.out.println(curRbR + " " + curRbC);
    }

    private static boolean move(int curDir, int curR, int curC){
        boolean move = false; //현재 이동방향으로 이동을 한번이라도 했는지 체크 
        while(true){
            //다음 좌표를 구해보고
            int nextR = curR + dr[curDir-1];
            int nextC = curC + dc[curDir-1];

            if(nextR >= 0 && nextR < r && nextC >= 0 && nextC < c && !map[nextR][nextC]){ //갈 수 있는 좌표라면
                curR = nextR;
                curC = nextC;
                map[nextR][nextC] = true;
                move = true;
            }
            else{
                break;
            }
        }
        curRbR = curR;
        curRbC = curC;

        return move;
    }
}
