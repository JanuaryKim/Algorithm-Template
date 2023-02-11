import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {

            int n = Integer.parseInt(bf.readLine());

            int[] score = new int[n+1]; //성적은 1부터 시작하기 때문에, 편의를 위해

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(bf.readLine());
                int paper = Integer.parseInt(st.nextToken());
                int meeting = Integer.parseInt(st.nextToken());
                score[paper] = meeting;
            }

            int passCtn = 1;
            int meetingOfUpperPaper = score[1];
            for (int j = 2; j <= n; j++) {

                if (meetingOfUpperPaper > score[j]) {
                    meetingOfUpperPaper = score[j];
                    passCtn++;
                }
            }

            sb.append(passCtn+"\n");
        }

        System.out.println(sb);
    }
}
