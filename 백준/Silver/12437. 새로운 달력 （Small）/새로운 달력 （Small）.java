import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int t;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());
        for (int k = 1; k <= t; k++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int res = 0, tmp = 0;
            for (int i = 0; i < a; i++) {
                res += (b + tmp) / c;
                if ((b + tmp) % c != 0) {
                    res++;
                    tmp = (b + tmp) % c;
                } else {
                    tmp = 0;
                }
            }
            System.out.println("Case #" + k + ": " + res);
        }
        br.close();
    }
}