import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringBuilder sb = new StringBuilder(input);

        int zero = 0;
        int one = 0;
        //0, 1 갯수 확인
        for(int i = 0; i < sb.length(); i++){
            char c = sb.charAt(i);

            if(c == '0') zero++;
            else one++;
        }

        zero /= 2;
        one /= 2;

        //one 제거
        while(one > 0) {
            for(int i = 0; i < sb.length(); i++){
                if(sb.charAt(i) == '1') {
                    sb.deleteCharAt(i);
                    one--;
                    break;
                }
            }
        }

        //one 제거
        while(zero > 0) {
            for(int i = sb.length() - 1; i >= 0; i--){
                if(sb.charAt(i) == '0') {
                    sb.deleteCharAt(i);
                    zero--;
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}
