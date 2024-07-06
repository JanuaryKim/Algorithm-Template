import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//18110
public class Main {
    public static void main(String[] args) throws IOException {
        long result = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        if(n == 0) {
            System.out.println(0);
            return;
        }
        int[] level = new int[n];
        for(int i = 0; i < n; i++){
            level[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(level);

        int validCnt = 0;
        int exceptCnt = Math.round((float)n * ((float)15/100));


        for(int i = 0 + exceptCnt; i < n - exceptCnt; i++){
            validCnt++;
            result += level[i];
        }

        result = Math.round((double)result / (double)validCnt);
        System.out.println(result);
    }
}
