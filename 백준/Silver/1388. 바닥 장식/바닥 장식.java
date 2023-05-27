import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] floor = new char[N][M];
        String line;
        for (int i = 0; i < N; i++) {
            line = bf.readLine();
            for (int j = 0; j < M; j++) {
                floor[i][j] = line.charAt(j);
            }
        }

        int cnt = 0;
        int tmp;
        //'-'일때 tmp 증가, '|' 만나면 cnt 증가시키고 tmp 초기화
        for (int i = 0; i < N; i++) {
            tmp = 0;
            for (int j = 0; j < M; j++) {

                if (floor[i][j] == '-') {
                    tmp++;

                }
                if (floor[i][j] == '|' && tmp != 0) {
                    cnt++;
                    tmp = 0;
                }
            }
            if (tmp != 0) cnt++;
        }
   
        for (int i = 0; i < M; i++) {
            tmp = 0;
            for (int j = 0; j < N; j++) {
                if (floor[j][i] == '|') {
                    tmp++;

                }
                if (floor[j][i] == '-' && tmp != 0) {
                    cnt++;
                    tmp = 0;
                }
            }
            if (tmp != 0) cnt++;
        }
        System.out.println(cnt);
    }
}