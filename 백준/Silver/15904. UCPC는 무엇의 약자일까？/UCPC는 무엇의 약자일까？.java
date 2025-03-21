import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();

        int idx = 0;
        char[] UCPC = new char[]{'U','C','P','C'};

        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == UCPC[idx]){
                idx++;
                if(idx == 4) break;
            }
        }
        if(idx == 4) System.out.println("I love UCPC");
        else System.out.println("I hate UCPC");
    }
}
