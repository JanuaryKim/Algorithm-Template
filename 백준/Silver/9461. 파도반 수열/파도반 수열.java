import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());
        int[] inputs = new int[t];

        for (int i = 0; i < t; i++) {
            inputs[i] = Integer.parseInt(bf.readLine());
        }

        long[] arr = new long[101];

        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;
        arr[6] = 3;

        for (int i = 7; i < 101; i++) {
            arr[i] = arr[i-1] + arr[i-5];
        }

        for (int i = 0; i < inputs.length; i++) {
            System.out.println(arr[inputs[i]]);
        }
    }
}
