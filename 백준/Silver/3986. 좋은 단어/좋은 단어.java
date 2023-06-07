import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());


        List<String> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            list.add(bf.readLine());
        }


        int ctn = 0;
        for (int i = 0; i < n; i++) {

            String str = list.get(i);
            Stack<Character> queue = new Stack<>();
            int idx = 0;


            while (idx < str.length()) {
                char currentChar = str.charAt(idx);


                if (!queue.isEmpty() && queue.peek() == currentChar) {
                    queue.pop();
                } else {
                    queue.add(currentChar);
                }

                idx++;
            }

            if(!queue.isEmpty())
                continue;

            ctn++;
        }

        System.out.println(ctn);
    }
}
