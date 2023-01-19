import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        long[] trees = new long[n];
        long max = 0;
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if(max < trees[i])
                max = trees[i];
        }

        long left = 0;
        long right = max;
        while (left <= right) {

            long mid = (left+right) / 2;

            long sum = 0;
            for (int i = 0; i < trees.length; i++) {
                long diff = trees[i] - mid;
                sum += diff < 0 ? 0 : diff;
            }

            if(sum >= m)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}
