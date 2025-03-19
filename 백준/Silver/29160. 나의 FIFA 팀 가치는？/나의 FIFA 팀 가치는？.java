import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        int result = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = bf.readLine().split(" ");

        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int currentYear = 1;

        Map<Integer, PriorityQueue<Integer>> athleteMap = new HashMap<>();

        for(int i = 1; i <= 11; i++){
            athleteMap.put(i, new PriorityQueue<>(Comparator.reverseOrder()));
        }

        for(int i = 0; i < n; i++){
            String[] inputLine = bf.readLine().split(" ");
            int p = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            athleteMap.get(p).add(w);
        }


        while(currentYear <= k){
            //차감
            for(int i = 1; i <= 11; i++){
                PriorityQueue<Integer> pq = athleteMap.get(i);
                Integer maxW = pq.poll();
                if(maxW == null){
                    continue;
                }
                if(maxW > 0) pq.add(--maxW);
                else pq.add(maxW);
            }
            currentYear++;
        }

        //총합 구하기
        for(int i = 1; i <= 11; i++){
            PriorityQueue<Integer> pq = athleteMap.get(i);
            if(pq.size() > 0)
            {
                result += pq.poll();
            }
        }
        System.out.println(result);
    }
}
