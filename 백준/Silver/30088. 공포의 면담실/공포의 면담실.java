import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int result = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] timeSum = new int[n];
        int[][] timeList = new int[n][];

        for(int i = 0; i < n; i++){
            int[] team = Arrays.stream(bf.readLine().split(" ")).mapToInt(j -> Integer.parseInt(j)).toArray();
            int employCnt = team[0];

            timeList[i] = Arrays.copyOfRange(team,1, employCnt+1);

            for(int j = 1; j <= employCnt; j++){
                timeSum[i] += team[j];
            }

        }

//        System.out.println(Arrays.toString(timeSum));
        Arrays.sort(timeSum);
        for(int i = 0; i < n; i++){
            result += result + timeSum[i];
        }

        System.out.println(result);
    }
}
