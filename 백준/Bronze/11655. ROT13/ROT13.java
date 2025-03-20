import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer resultSb = new StringBuffer();
        char[] input = bf.readLine().toCharArray();
        for(int i = 0; i < input.length; i++){
            char c = input[i];
            if ((c >= 'a' && c <= 'z')) {
                char newC;
                if(c + 13 > 'z') newC = (char) ('a' + (13 - ('z' - c)) - 1);
                else newC = (char)(c + 13);
                resultSb.append(newC);
            }
            else if(c >= 'A' && c <= 'Z'){
                char newC;
                if(c + 13 > 'Z') newC = (char) ('A'+ (13 - ('Z' - c)) - 1);
                else newC = (char)(c + 13);
                resultSb.append(newC);
            }
            else{
                resultSb.append(c);
            }
        }

        System.out.println(resultSb);
    }
}
