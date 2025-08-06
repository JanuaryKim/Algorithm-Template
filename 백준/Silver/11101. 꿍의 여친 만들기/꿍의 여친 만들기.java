import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            String input1 = br.readLine();
            String input2 = br.readLine();

            //인풋1 처리
            String[] sub = input1.split(",");
            Map<String, Integer> map = new HashMap<>();
            for(int j = 0; j < sub.length; j++){
                String[] subScore = sub[j].split(":");
                map.put(subScore[0], Integer.parseInt(subScore[1]));
            }

            //인풋2 처리
            String[] condition = input2.split("\\|");
            int[] times = new int[condition.length];

            for(int j = 0; j < condition.length; j++){
                String[] detailCon = condition[j].split("&");
                int maxTime = Integer.MIN_VALUE;
                for(int z = 0; z < detailCon.length; z++){
                    int time = map.get(detailCon[z]);
                    maxTime = Math.max(maxTime, time);
                }
                times[j] = maxTime;
            }
            Arrays.sort(times);
            sb.append(times[0]);
            if(i != t-1) sb.append("\n");
        }
        System.out.println(sb);
    }
}
