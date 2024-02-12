import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    static int[] height = new int[1000];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());
        int[][] ptScores = new int[t][];

        for(int i = 0; i < t; i++){
            ptScores[i] = Arrays.stream(bf.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
        }

        init();

        for(int i = 0; i < t; i++){
            int[] xy1 = getXY(ptScores[i][0]);
            int[] xy2 = getXY(ptScores[i][1]);

            int[] sumXY = new int[]{xy1[0] + xy2[0], xy1[1] + xy2[1]};
            System.out.println(getPtScore(sumXY));
        }

    }

    private static int getPtScore(int[] pt){

        int score = height[pt[1]]; //시작 기준 점수
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
            if(height[i] == ptScore){
                return new int[]{x,i};
            }
            else if(height[i] > ptScore){
                y = i-1;
                break;
            }
        }

        int num = height[y];
        while(num != ptScore){
            x++;
            y--;
            num++;
        }
        return new int[]{x,y};
    }

    private static void init() {
        int num = 1;

        for(int i = 1; i < height.length; i++){
            height[i] = num;
            num = num + i;
        }
    }
}