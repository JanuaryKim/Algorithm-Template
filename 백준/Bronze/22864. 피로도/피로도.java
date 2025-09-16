import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strABCD = br.readLine().split(" ");
        int A = Integer.parseInt(strABCD[0]); //피로도
        int B = Integer.parseInt(strABCD[1]); //성과
        int C = Integer.parseInt(strABCD[2]); //휴식
        int M = Integer.parseInt(strABCD[3]); //맥스 피로도

        int hour = 0;
        int tired = 0;
        int achieve = 0;

        while(hour < 24) {
            hour++;
            if((tired + A) <= M) { //일한다
                tired += A;
                achieve += B;
            }
            else {
                tired = Math.max(tired - C, 0);

            }
        }
        System.out.println(achieve);
    }
}
