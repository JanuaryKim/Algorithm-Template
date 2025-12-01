import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] jn = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int j = jn[0];
        int n = jn[1];

        String[] questions = new String[n];
        for(int i = 0; i < n; i++) {
            questions[i] = br.readLine();
        }

        for(int i = 0; i < n; i++) {
            String line = questions[i];
            int sum = 0;
            for(int z = 0; z < line.length(); z++){
                char c = line.charAt(z);
                if(c >= 'A' && c <= 'Z') sum += 4;
                else if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) sum += 2;
                else sum += 1;
            }

            if(sum <= j) result++;
        }

        System.out.println(result);
    }
}
