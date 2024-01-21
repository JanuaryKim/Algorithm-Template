import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        long result = Long.MIN_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] spl = br.readLine().split(" ");
        int n = Integer.parseInt(spl[0]);
        int k = Integer.parseInt(spl[1]);
        spl = br.readLine().split(" ");
        int[] shareCards = new int[n];
        int[] teamCards = new int[n];

        for(int i = 0; i < n; i++) shareCards[i] = Integer.parseInt(spl[i]);
        spl = br.readLine().split(" ");
        for(int i = 0; i < n; i++) teamCards[i] = Integer.parseInt(spl[i]);
        // -- 입력 소스 --
        
        Integer[] highSum = new Integer[n];
        Arrays.fill(highSum, Integer.MIN_VALUE);
        for(int i = 0; i < teamCards.length; i++){
            for(int j = 0; j < shareCards.length; j++){
                int sum = teamCards[i] * shareCards[j];
                highSum[i] = highSum[i] < sum ? sum : highSum[i];
            }
        }
        Arrays.sort(highSum, (i1,i2) -> i2-i1);
        System.out.println(highSum[k]);
    }
}