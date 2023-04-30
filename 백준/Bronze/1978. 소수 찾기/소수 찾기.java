import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        String[] inputArr = bf.readLine().split(" ");

        int result = 0;
        for (int i = 0; i < n; i++) {

            int value = Integer.parseInt(inputArr[i]);

            if(value == 1)
                continue;

            int limit = value/2;
            boolean check = true;
            for (int j = 2; j <= limit; j++) {
                if (value % j == 0) {
                    check = false;
                    break;
                }
            }

            if(check)
                result++;
        }

        System.out.println(result);
    }
}
