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
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        int[] holes = new int[n];

        for (int i = 0; i < n; i++) {
            holes[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(holes);
        int curHole = holes[0];
        int tapeCtn = 1;
        for (int i = 0; i < n; i++) {

            if (curHole + l <= holes[i]) {
                tapeCtn++;
                curHole = holes[i];
            }
        }
        System.out.println(tapeCtn);
    }
}
