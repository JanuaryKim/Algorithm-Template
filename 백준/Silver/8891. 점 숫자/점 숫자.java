import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//문제에서 보여지는 차트에서 x = 1인 상태에서 y축으로만 변경되는 좌표의 점 점수들만 초기화 해두어 해당 좌표를 기준으로 점점수를 찾아냄
public class Main {
    static int[] height = new int[1000]; //범위를 일단 그냥 크게잡음... 더욱 명확하게 할 필요가 있음..
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());
        int[][] ptScores = new int[t][];

        for(int i = 0; i < t; i++){
            ptScores[i] = Arrays.stream(bf.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
        }

        init(); //초기화, y좌표인 height 의 값들을 초기화 해둠

        for(int i = 0; i < t; i++){
            int[] xy1 = getXY(ptScores[i][0]); //점 점수의 좌표 구함
            int[] xy2 = getXY(ptScores[i][1]); //점 점수의 좌표 구함

            int[] sumXY = new int[]{xy1[0] + xy2[0], xy1[1] + xy2[1]}; //좌표값을 합침
            System.out.println(getPtScore(sumXY));
        }
    }

    private static int getPtScore(int[] pt){
        int score = height[pt[1]]; //시작 기준 점수 (
        int x = 1;
        int add = pt[1] + 1;

        while(x != pt[0]){
            score += add++;
            x++;
        }
        return score;
    }
    private static int[] getXY(int ptScore){
        int y = 1;
        int x = 1;
        for(int i = 1; i < 1000; i++){
            if(height[i] == ptScore){ //찾고자 하였던 점섬수를 x가 1인 상태에서 바로 찾은 경우
                return new int[]{x,i};
            }
            else if(height[i] > ptScore){ //찾고자 하는 점점수가 x값이 1이 아닌 위치에 존재한 경우
                y = i-1;
                break;
            }
        }

        int num = height[y];
        while(num != ptScore){ // 기준 점수에서 우측 아래 대각선 방향으로 좌표를 이동시키며 찾고자 하는 점점수에 도달할때까지 반복
            x++;
            y--;
            num++;
        }
        return new int[]{x,y};
    }

    private static void init() {
        int num = 1;
        for(int i = 1; i < height.length; i++){ //x = 1, y = n 인 점점수는 1로 시작하여 +1씩 누적된 값만큼 차이값을 가짐
            height[i] = num;
            num = num + i;
        }
    }
}