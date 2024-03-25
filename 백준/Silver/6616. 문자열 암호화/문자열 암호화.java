import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//개선 버전
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            int n = Integer.parseInt(bf.readLine());
            if(n == 0) break;
            if(sb.length() != 0) sb.append("\n");
            String setStr = bf.readLine().replaceAll(" ", "").toUpperCase();

            char[] chars = new char[setStr.length()];

            int idx = 0;
            for(int i = 0; i < n; i++){ 
                for(int j = i; j < setStr.length(); j+=n){
                    chars[j] = setStr.charAt(idx++);
                }
            }
            sb.append(new String(chars));
        }
        System.out.println(sb);
    }
}
