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

        int[] pk = new int[m];
        int[] se = new int[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            pk[i] = Integer.parseInt(st.nextToken());
            se[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pk);
        Arrays.sort(se);

        if (se[0] * 6 < pk[0]) {
            System.out.println(n * se[0]);
            return;
        } else {
            int pkPrice = ((n/6) * pk[0]);
            int sePrice = (n%6) * se[0];

            if (sePrice > pk[0]) {
                sePrice = pk[0];
            }
            System.out.println(pkPrice + sePrice);
        }

    }
}
