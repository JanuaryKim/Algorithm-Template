import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strNM = br.readLine().split(" ");

        int n = Integer.parseInt(strNM[0]);
        int m = Integer.parseInt(strNM[1]);
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int k = Integer.parseInt(br.readLine());
            String[] strNums = br.readLine().split(" ");
            for(int j = 0; j < k; j++){
                map.put(strNums[j], map.getOrDefault(strNums[j], 0) + 1);
            }
        }

        System.out.println(map.values().stream().filter(v -> v >= m).collect(Collectors.toList()).size());
    }
}
