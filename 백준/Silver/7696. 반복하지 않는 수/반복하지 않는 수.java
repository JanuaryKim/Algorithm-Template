import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] dp = new int[1000001];
        while (true) {
            int n = Integer.parseInt(bf.readLine());
            if(n == 0) break;
            if(dp[n] != 0) {
                sb.append(dp[n] + "\n");
                continue;
            }

            int cnt = 0;
            int num = 0;
            int[] repeat = new int[10];
            boolean check = true;
            while(cnt < n){
                num++;
                int value = num;

                while(value != 0){
                    int remain = value % 10;
                    repeat[remain]++;
                    if(repeat[remain] > 1) {
                        check = false;
                        break;
                    }
                    value = value / 10;
                }

                if(check) {
                    cnt++;
                    dp[cnt] = num;

                }

                check = true;
                Arrays.fill(repeat, 0);
            }

            sb.append(num+"\n");
        }

        if(sb.length() > 1)
            sb = sb.delete(sb.length() -1, sb.length());
        System.out.println(sb);
    }
}
