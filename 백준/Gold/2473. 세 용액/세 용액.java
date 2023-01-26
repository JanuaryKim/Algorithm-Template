import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long min = Long.MAX_VALUE;
        long[] result = new long[3];

        for (int i = 0; i < n - 2; i++) {
            int left = i;
            int mid = i+1;
            int right = n-1;

            while (mid < right) {

                long sum = arr[left] + arr[mid] + arr[right];
                long absSum = Math.abs(sum);
                if (absSum < min) {
                    min = absSum;
                    result[0] = arr[left];
                    result[1] = arr[mid];
                    result[2] = arr[right];
                }

                if (sum > 0) {
                    right--;
                } else if(sum == 0){
                    break;
                }
                else{
                    mid++;
                }
            }
        }
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }
}
