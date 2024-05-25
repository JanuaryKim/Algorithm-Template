import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        int result = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] splStr = bf.readLine().split(" ");
        int n = Integer.parseInt(splStr[0]);
        int k = Integer.parseInt(splStr[1]);
        boolean[] inedible = new boolean[n];
        String[] strBench = bf.readLine().split("");
        List<Integer> personIdxList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(strBench[i].equals("P")){
                personIdxList.add(i);
                inedible[i] = true;
            }
        }

        for(Integer idx : personIdxList){
            int startIdx = Math.max(0, idx-k);
            int endIdx = Math.min(n-1, idx+k);
            for(int i = startIdx; i <= endIdx; i++){
                if(inedible[i]) continue;
                inedible[i] = true;
                result++;
                break;
            }
        }

        System.out.println(result);
    }
}
