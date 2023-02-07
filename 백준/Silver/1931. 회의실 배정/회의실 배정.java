import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] meetings;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        meetings = new int[n][];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            meetings[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        Arrays.sort(meetings, (m1, m2) -> {
            if(m1[1] == m2[1])
            {
                return m1[0] - m2[0];
            }

            return m1[1] - m2[1];
        } );
        
        int ctn = 0;
        int preEnd = 0;
        for (int i = 0; i < n; i++) {
            if(meetings[i][0] >= preEnd)
            {
                ctn++;
                preEnd = meetings[i][1];
            }
        }
        System.out.println(ctn);
    }
}