import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int result = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputLine1 = bf.readLine().split(" ");
        int P = Integer.parseInt(inputLine1[0]);
        int N = Integer.parseInt(inputLine1[1]);

        int[] items = Arrays.stream(bf.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        Arrays.sort(items);

        for(int i = 0; i < N; i++){
            if(P >= 200) break;
            P += items[i];
            result++;
        }
        System.out.println(result);
    }
}
