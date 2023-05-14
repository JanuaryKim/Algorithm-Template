import java.io.*;
import java.util.LinkedList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String inputs = bf.readLine();

        int result = 0;
        int steel = 0;
        char preChar = '-';
        for (int i = 0; i < inputs.length(); i++) {
            char ch = inputs.charAt(i);
            if(ch == '(')
                steel++;
            else{
                steel--;
                if (preChar == '(') {
                    result += steel;
                } else {
                    result+=1;
                }
            }
            preChar = ch;
        }
        System.out.println(result);
    }
}
