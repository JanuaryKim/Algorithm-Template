import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] dis = new int[n-1];
        int[] price = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n-1; i++) {
            dis[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }


        int min = price[0];
        int sum = dis[0] * min;
        for (int i = 1; i < n-1; i++) {
            if (min > price[i]) {
                min = price[i];
            }

            sum += dis[i] * min;
        }

        System.out.println(sum);
    }
}
