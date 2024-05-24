import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        Long result = 0L;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Integer[] tips = new Integer[n];
        for(int i = 0; i < n; i++){
            tips[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(tips, (t1,t2) -> t2 - t1);

        for(int i = 0; i < n; i++){
            int realTip = tips[i] - ((i + 1) - 1);
            if(realTip <= 0) break;
            result+=realTip;
        }

        System.out.println(result);
    }
}
