import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bf.readLine().split(" ");	// 참가자 수
        int jimin = Integer.parseInt(inputs[1]);    // 김지민 번호
        int hansoo = Integer.parseInt(inputs[2]);	// 임한수 번호
        int count = 0;

        while(jimin != hansoo) {
            jimin = (jimin + 1) / 2;
            hansoo = (hansoo + 1) / 2;
            count  ++;
        }
        System.out.println(count);
    }
}
