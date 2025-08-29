import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] jooeon = Arrays.stream(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
        int[] professor = Arrays.stream(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();

        Arrays.sort(jooeon);
        Arrays.sort(professor);

        int winCnt = 0;
        int start = n - 1;
        for(int i = n - 1; i >= 0; i--) {
            int proCard = professor[i];
            int tempStart = start;
            for(int j = start; j >= 0; j--) {
                tempStart = j;
                if(jooeon[j] < proCard) {
                    winCnt++;
                    break;
                }
            }

            if(tempStart == 0)
                break;
            else
                start = tempStart - 1;
        }

        if(winCnt >= ((n+1) / 2))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
