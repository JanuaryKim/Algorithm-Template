import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean[] visited;
    static int[] kit;
    static int n, k;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] nk = Arrays.stream(bf.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
        n = nk[0]; k = nk[1];
        kit = Arrays.stream(bf.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
        visited = new boolean[nk[0]];

        for(int i = 0; i < nk[0]; i++){
            int tempMaxWeight = 500 - nk[1] + kit[i];
            if(tempMaxWeight < 500) continue;
            visited[i] = true;
            dfs(1, tempMaxWeight);
            visited[i] = false;
        }
        System.out.println(result);
    }

    static void dfs(int depth, int curMaxWeight){
        if(depth >= n){
            result++;
            return;
        }

        for(int i = 0; i < n; i++){
            if (!visited[i]) {
                int tempMaxWeight = curMaxWeight + kit[i] - k;
                if(tempMaxWeight < 500) continue;
                visited[i] = true;
                dfs(depth+1, tempMaxWeight);
                visited[i] = false;
            }
        }

    }
}
