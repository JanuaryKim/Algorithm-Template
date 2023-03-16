import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] removeArr = new int[m];
        int removeIdx = 0;
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < m; i++) {
            removeArr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }
        int totalCtn = 0;
        while (removeIdx < m) {

            Iterator<Integer> iterator = deque.iterator();
            int ctn = 0;
            while (iterator.hasNext()) {
                int next = iterator.next();
                if (next == removeArr[removeIdx]) {
                    break;
                }
                ctn++;
            }



            int diff = deque.size() - ctn;
            if (ctn <= diff) {
                totalCtn += ctn;
                while (ctn > 0) {
                    deque.offerLast(deque.pollFirst());
                    ctn--;
                }

            } else {
                totalCtn += diff;
                while (diff > 0) {
                    deque.offerFirst(deque.pollLast());
                    diff--;
                }

            }

            deque.poll();
            removeIdx++;
        }

        System.out.println(totalCtn);
    }
}
