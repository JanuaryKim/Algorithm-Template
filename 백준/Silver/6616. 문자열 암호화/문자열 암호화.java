import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

            int firstIdx = 0;
            int idx = 0;
            int insertIdx = 0;
            while(idx < setStr.length()){
                chars[insertIdx] = setStr.charAt(idx);

                idx++;
                insertIdx += n;
                while(insertIdx < setStr.length() && idx < setStr.length()){

                    chars[insertIdx] = setStr.charAt(idx);
                    idx++;
                    insertIdx += n;
                }
                insertIdx = ++firstIdx;
            }
            sb.append(new String(chars));
        }
        System.out.println(sb);
    }
}
