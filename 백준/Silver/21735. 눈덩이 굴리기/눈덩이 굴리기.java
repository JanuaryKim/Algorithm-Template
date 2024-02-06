import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n, m, maxSnow = 0;
    static int[] ground;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] splNM = bf.readLine().split(" ");
        n = Integer.parseInt(splNM[0]);
        m = Integer.parseInt(splNM[1]);
        ground = Arrays.stream(bf.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        dfs(0, -1,1);
        System.out.println(maxSnow);
    }

    private static void dfs(int curSecond, int pos, int curSnow){

        if(curSecond == m){ //대회의 시간만큼 눈덩이를 모두 굴린 경우
            if(curSnow > maxSnow) maxSnow = curSnow;
            return;
        }

        if(pos + 1 < n) {
            dfs(curSecond + 1, pos + 1, curSnow + ground[pos + 1]); // +1칸으로 눈덩이를 굴린 경우
        }

        if(pos + 2 < n) {
            dfs(curSecond + 1, pos + 2, (curSnow / 2) + ground[pos + 2]); // +2칸으로 눈덩이를 던진 경우
        }

        if(curSnow > maxSnow){
            maxSnow = curSnow;
        }
    }
}