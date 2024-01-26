import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int result = 0;
        String line = bf.readLine();
        char pre = line.charAt(0);
        int bCtn = 0, rCtn = 0;
        if(pre == 'B') bCtn++;
        else rCtn++;

        for(int i = 1; i < line.length(); i++){
            char c = line.charAt(i);
            if(c == pre) continue;
            else{
                if(c == 'B'){
                    bCtn++;
                }
                else{
                    rCtn++;
                }
                pre = c;
            }
        }

        result = Math.min(bCtn , rCtn);
        System.out.println(result+1);
    }
}
