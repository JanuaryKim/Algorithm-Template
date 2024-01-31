import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        int[] result = new int[t];
        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(bf.readLine());
            int[] woods = Arrays.stream(bf.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
            int[] tempWoods = new int[n];
            Arrays.sort(woods);
            int first = 0, last = n-1;

            int idx = 0;
            while (first <= last) {
                if(first == last){
                    tempWoods[first] = woods[idx];
                    break;
                }
                tempWoods[first] = woods[idx++];
                tempWoods[last] = woods[idx++];
                first++;
                last--;
            }

            int maxDiff = Math.abs(tempWoods[0] - tempWoods[n-1]);
            for(int j = 0; j < n-1; j++){
                int diff = Math.abs(tempWoods[j] - tempWoods[j + 1]);
                if(maxDiff < diff) maxDiff = diff;
            }
            result[i] = maxDiff;
        }
        for(int i = 0; i < t; i++) System.out.println(result[i]);
    }
}
