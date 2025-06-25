import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {

        int result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Queue<Character> q = new LinkedList<>();

        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(c == '('){
                q.add(c);
            }
            else{
                Character head = q.poll();
                if(head == null)
                    result++;
            }
        }

        System.out.println(result + q.size());
    }
}
