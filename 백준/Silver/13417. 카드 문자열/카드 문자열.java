import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(bf.readLine());
            String[] splCards = bf.readLine().split(" ");

            Deque<String> dq = new LinkedList<>();
            dq.add(splCards[0]);
            for (int j = 1; j < n; j++) {
                if(dq.peek().compareTo(splCards[j]) >= 0)
                    dq.addFirst(splCards[j]);
                else
                    dq.addLast(splCards[j]);
            }
            dq.stream().forEach(s->sb.append(s));
            if(i != t -1) sb.append("\n");
        }

        System.out.println(sb);
    }

}