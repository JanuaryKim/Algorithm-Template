import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] kl = Arrays.stream(bf.readLine().split(" ")).mapToInt(i-> Integer.parseInt(i)).toArray();
        int k = kl[0], l = kl[1];

        Map<String, Integer> map = new HashMap<>();
        Queue<String> clickQueue = new LinkedList<>();
        for(int i = 0; i < l; i++){
            String number = bf.readLine();
            clickQueue.add(number);
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        int ctn = 0;
        while(!clickQueue.isEmpty()){

            String number = clickQueue.poll();
            int repeat = map.get(number);
            if(repeat == 1){
                System.out.println(number);
            }
            else{
                map.put(number, repeat-1);
                continue;
            }
            ctn++;
            if(ctn == k) break;
        }
    }
}
