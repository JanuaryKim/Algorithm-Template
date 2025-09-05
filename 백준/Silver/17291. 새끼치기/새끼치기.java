import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] wormCnt = new long[21];

        wormCnt[1] = 1;
        wormCnt[2] = 2;
        wormCnt[3] = 4;
        wormCnt[4] = 7;
        wormCnt[5] = 14;

        for(int i = 6; i <= n; i++){
            wormCnt[i] = wormCnt[i-1] * 2;
            if(i % 2 == 0) wormCnt[i] -= (wormCnt[i-4] + wormCnt[i-5]); //됨

        }
        System.out.println(wormCnt[n]);
    }
}
