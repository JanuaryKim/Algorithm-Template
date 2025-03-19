import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        int result = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] solveCnt = new int[5];
        int n = Integer.parseInt(bf.readLine());
        solveCnt = Arrays.stream(bf.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(int i = 1; i <= 5; i++){
            map.put(i, new PriorityQueue<>());
        }

        for(int i = 0; i < n; i++){
            String[] input = bf.readLine().split(" ");
            int k = Integer.parseInt(input[0]);
            int t = Integer.parseInt(input[1]);
            map.get(k).add(t);
        }

        for(int i = 0; i < 5; i++){
            if(solveCnt[i] == 0) continue;
            int preTime = 0;
            int tempCnt = solveCnt[i];
            while(tempCnt > 0){
                tempCnt--;
                PriorityQueue<Integer> tempQ = map.get(i+1);
                int time = tempQ.poll();
                if(preTime != 0) result += time - preTime;
                result += time;
                preTime = time;
            }

            if(i < 4) result += 60;
        }
        System.out.println(result);
    }
}
